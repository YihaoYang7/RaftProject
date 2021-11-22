package raft.rpc;

import raft.role.NodeId;
import java.util.*;

public class AppendEntriesRPC
{
    private int term;
    private NodeId leaderId;
    private int preLogIndex = 0;
    private int preLogTerm = 0;
    private List<Object> entries = Collections.emptyList();

    public int getTerm()
    {
        return term;
    }

    public void setTerm(int term)
    {
        this.term = term;
    }

    public NodeId getLeaderId()
    {
        return leaderId;
    }

    public void setLeaderId(NodeId leaderId)
    {
        this.leaderId = leaderId;
    }

    public int getPreLogIndex()
    {
        return preLogIndex;
    }

    public void setPreLogIndex(int preLogIndex)
    {
        this.preLogIndex = preLogIndex;
    }

    public int getPreLogTerm()
    {
        return preLogTerm;
    }

    public void setPreLogTerm(int preLogTerm)
    {
        this.preLogTerm = preLogTerm;
    }

    public List<Object> getEntries()
    {
        return entries;
    }

    public void setEntries(List<Object> entries)
    {
        this.entries = entries;
    }
}
