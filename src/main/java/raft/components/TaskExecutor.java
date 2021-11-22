package raft.components;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public interface TaskExecutor
{
    Future<?> submit(Runnable task);
    <V>Future<V> submit(Callable<V> task);
}
