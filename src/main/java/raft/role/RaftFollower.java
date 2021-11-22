package raft.role;

import raft.timer.ElectionTimeout;

public class RaftFollower extends AbstractNodeRole
{
    private final NodeId votedFor;
    private final NodeId leaderId;
    private final ElectionTimeout electionTimeout;

    public RaftFollower(int term, NodeId votedFor, NodeId leaderId, ElectionTimeout electionTimeout)
    {
        super(RoleName.RAFT_FOLLOWER,term);
        this.votedFor = votedFor;
        this.leaderId = leaderId;
        this.electionTimeout = electionTimeout;
    }

    public NodeId getVotedFor()
    {
        return votedFor;
    }

    public NodeId getLeaderId()
    {
        return leaderId;
    }

    @Override
    public void cancelTimeoutOrTask()
    {
        electionTimeout.cancel();
    }

    @Override
    public String toString()
    {
        return "Follower{ Term = " + term + ", Leader Id = " + leaderId + ", Voted For = " + votedFor + "}.";
    }
}
