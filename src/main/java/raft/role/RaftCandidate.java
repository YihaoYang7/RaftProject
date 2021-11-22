package raft.role;

import raft.timer.ElectionTimeout;

public class RaftCandidate extends AbstractNodeRole
{
    private final int voteNumber;
    private final ElectionTimeout electionTimeout;

    public RaftCandidate(int term, int voteNumber, ElectionTimeout electionTimeout)
    {
        super(RoleName.RAFT_CANDIDATE,term);
        this.voteNumber = voteNumber;
        this.electionTimeout = electionTimeout;
    }

    public RaftCandidate(int term, ElectionTimeout electionTimeout)
    {
        this(term,1,electionTimeout);
    }

    @Override
    public void cancelTimeoutOrTask()
    {
        electionTimeout.cancel();
    }

    public int getVoteNumber()
    {
        return voteNumber;
    }

    @Override
    public String toString()
    {
        return "Candidate{ Term = " + term + ", Got votes = " + voteNumber + "}.";
    }
}
