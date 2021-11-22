package raft.components.nodestore;

import raft.role.NodeId;

public interface NodeStore
{
    int getTerm();
    void setTerm(int term);
    NodeId getVotedFor();
    void setVotedFor(NodeId votedFor);
    void close();
}
