package raft.role;

import raft.timer.ElectionTimeout;
import raft.timer.LogReplicationTask;

public class StateMachine
{
    //leader
    private LogReplicationTask logReplicationTask;

    //candidate
    private int voteNumber;
    private ElectionTimeout electionTimeout;

    //follower
    private NodeId votedFor;
    private NodeId leaderId;
}
