package raft.rpc;

import raft.role.NodeId;

public class RequestVoteRPC
{
    private int term;
    private NodeId candidateId;
    private int lastLogIndex = 0;
    private int lastLogTerm = 0;

    @Override
    public String toString()
    {
        return "Candidate Id: " + candidateId + ", Last Log Index: " + lastLogIndex + ", Last Log Term: " + lastLogTerm + ".";
    }

    public int getTerm()
    {
        return term;
    }

    public void setTerm(int term)
    {
        this.term = term;
    }

    public NodeId getCandidateId()
    {
        return candidateId;
    }

    public void setCandidateId(NodeId candidateId)
    {
        this.candidateId = candidateId;
    }

    public int getLastLogIndex()
    {
        return lastLogIndex;
    }

    public void setLastLogIndex(int lastLogIndex)
    {
        this.lastLogIndex = lastLogIndex;
    }

    public int getLastLogTerm()
    {
        return lastLogTerm;
    }

    public void setLastLogTerm(int lastLogTerm)
    {
        this.lastLogTerm = lastLogTerm;
    }
}
