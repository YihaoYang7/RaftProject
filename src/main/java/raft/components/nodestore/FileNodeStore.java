package raft.components.nodestore;

import raft.components.Node;
import raft.role.NodeId;

public class FileNodeStore implements NodeStore
{


    @Override
    public int getTerm()
    {
        return 0;
    }

    @Override
    public void setTerm(int term)
    {

    }

    @Override
    public NodeId getVotedFor()
    {
        return null;
    }

    @Override
    public void setVotedFor(NodeId votedFor)
    {

    }

    @Override
    public void close()
    {

    }
}
