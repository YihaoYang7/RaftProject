package raft.components;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import raft.components.nodestore.NodeStore;
import raft.role.AbstractNodeRole;
import raft.role.RaftCandidate;
import raft.role.RaftFollower;
import raft.role.RoleName;
import raft.rpc.RequestVoteRPC;
import raft.timer.ElectionTimeout;

public class NodeImpl implements Node
{
    private static final Logger logger = LogManager.getLogger(NodeImpl.class);
    private final NodeContext context;
    private boolean started;
    private AbstractNodeRole role;

    public NodeImpl(NodeContext context)
    {
        this.context = context;
    }

    @Override
    public synchronized void start()
    {
        if (started) return;
        context.getEventBus().register(this);
        context.getConnector().initialize();
        NodeStore store = context.getStore();
        changeToRole(new RaftFollower(store.getTerm(), store.getVotedFor(), null, scheduleElectionTimeout()));
    }

    private void changeToRole(AbstractNodeRole newRole)
    {
        logger.debug("Node {}, role changed to {}", context.getSelfId(), newRole);
        NodeStore store = context.getStore();
        if (newRole.getName() == RoleName.RAFT_FOLLOWER)
        {
            store.setVotedFor(((RaftFollower) newRole).getVotedFor());
        }
        role = newRole;
    }

    private ElectionTimeout scheduleElectionTimeout()
    {
        return context.getScheduler().scheduleElectionTimeout(this::electionTimeout);
    }

    void electionTimeout()
    {
        context.getExecutor().submit(this::doProcessElectionTimeout);
    }

    private void doProcessElectionTimeout()
    {
        if (role.getName() == RoleName.RAFT_LEADER)
        {
            logger.warn("{} is the leader, ignore the election timeout.", context.getSelfId());
            return;
        }
        int newTerm = role.getTerm();
        role.cancelTimeoutOrTask();
        logger.info("Election start.");
        changeToRole(new RaftCandidate(newTerm, scheduleElectionTimeout()));
        RequestVoteRPC rpc = new RequestVoteRPC();
        rpc.setTerm(newTerm);
        rpc.setCandidateId(context.getSelfId());
        rpc.setLastLogIndex(0);
        rpc.setLastLogTerm(0);
        context.getConnector().sendRequestRPC(rpc, context.getGroup().listEndPointExceptSelf());
    }

    @Override
    public void stop()
    {

    }
}
