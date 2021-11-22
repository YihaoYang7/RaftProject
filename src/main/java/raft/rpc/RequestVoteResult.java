package raft.rpc;

public class RequestVoteResult
{
    private final int term;
    private final boolean ifVoted;

    public RequestVoteResult(int term, boolean ifVoted)
    {
        this.term = term;
        this.ifVoted = ifVoted;
    }

    @Override
    public String toString()
    {
        return "Term: " + term + ", If Voted: " + ifVoted + ".";
    }

    public int getTerm()
    {
        return term;
    }

    public boolean isIfVoted()
    {
        return ifVoted;
    }
}
