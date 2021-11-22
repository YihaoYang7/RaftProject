package raft.role;

public abstract class AbstractNodeRole
{
    protected final RoleName name;
    protected final int term;

    public AbstractNodeRole(RoleName name, int term)
    {
        this.name = name;
        this.term = term;
    }

    public RoleName getName()
    {
        return name;
    }

    public abstract void cancelTimeoutOrTask();

    public int getTerm()
    {
        return term;
    }
}
