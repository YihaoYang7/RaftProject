package raft.rpc;

public class AppendEntriesResult
{
    private final int term;
    private final boolean success;

    public AppendEntriesResult(int term, boolean success)
    {
        this.term = term;
        this.success = success;
    }

    public int getTerm()
    {
        return term;
    }

    public boolean isSuccess()
    {
        return success;
    }
}
