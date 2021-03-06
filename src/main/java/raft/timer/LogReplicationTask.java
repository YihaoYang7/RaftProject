package raft.timer;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class LogReplicationTask
{
    private final ScheduledFuture<?> scheduledFuture;

    public LogReplicationTask(ScheduledFuture<?> scheduledFuture)
    {
        this.scheduledFuture = scheduledFuture;
    }

    public void cancel()
    {
        this.scheduledFuture.cancel(false);
    }

    @Override
    public String toString()
    {
        return "Log Replication Executed after " + scheduledFuture.getDelay(TimeUnit.MILLISECONDS) + " ms";
    }
}
