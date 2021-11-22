package raft.timer;

import java.util.Random;

import java.util.concurrent.*;

public class DefaultScheduler implements Scheduler
{
    private final int minElectionTimeout;
    private final int maxElectionTimeout;
    private final int logReplicationDelay;
    private final int logReplicationInterval;
    private final Random electionTimeoutRandom;
    private final ScheduledExecutorService executorService;

    public DefaultScheduler(int minElectionTimeout, int maxElectionTimeout, int logReplicationDelay,
                            int logReplicationInterval)
    {
        if (minElectionTimeout < 0 || maxElectionTimeout < 0 || minElectionTimeout > maxElectionTimeout)
            throw new IllegalArgumentException();
        if (logReplicationDelay < 0 || logReplicationInterval <= 0) throw new IllegalArgumentException();
        this.minElectionTimeout = minElectionTimeout;
        this.maxElectionTimeout = maxElectionTimeout;
        this.logReplicationDelay = logReplicationDelay;
        this.logReplicationInterval = logReplicationInterval;
        this.electionTimeoutRandom = new Random();
        executorService = (ScheduledExecutorService) Executors.newSingleThreadExecutor(r -> new Thread(r, "scheduler"));
    }

    @Override
    public LogReplicationTask scheduleLogReplicationTask(Runnable task)
    {
        ScheduledFuture<?> scheduledFuture = this.executorService.scheduleWithFixedDelay(task, logReplicationDelay,
                logReplicationInterval, TimeUnit.MILLISECONDS);
        return new LogReplicationTask(scheduledFuture);
    }

    @Override
    public ElectionTimeout scheduleElectionTimeout(Runnable task)
    {
        int timeout = electionTimeoutRandom.nextInt(maxElectionTimeout - minElectionTimeout) + minElectionTimeout;
        ScheduledFuture<?> scheduledFuture = executorService.schedule(task, timeout, TimeUnit.MILLISECONDS);
        return new ElectionTimeout(scheduledFuture);
    }

    @Override
    public void stop()
    {

    }
}
