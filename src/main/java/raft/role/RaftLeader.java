package raft.role;

import raft.timer.LogReplicationTask;

public class RaftLeader extends AbstractNodeRole
{
    private final LogReplicationTask logReplicationTask;

    public RaftLeader(int term, LogReplicationTask logReplicationTask)
    {
        super(RoleName.RAFT_LEADER, term);
        this.logReplicationTask = logReplicationTask;
    }

    @Override
    public void cancelTimeoutOrTask()
    {

    }

    @Override
    public String toString()
    {
        return "Leader{ Term = " + term + "}.";
    }
}
