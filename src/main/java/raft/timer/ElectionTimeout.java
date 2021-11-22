package raft.timer;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ElectionTimeout
{
    private final ScheduledFuture<?> scheduledFuture;

    public ElectionTimeout(ScheduledFuture<?> scheduledFuture)
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
        if (this.scheduledFuture.isCancelled())
            return "Election cancelled";
        if (this.scheduledFuture.isDone())
            return "Election finished";
        return "Election will be executed after " + this.scheduledFuture.getDelay(TimeUnit.MILLISECONDS) + " ms";
    }
}
