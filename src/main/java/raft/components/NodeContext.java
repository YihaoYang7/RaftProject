package raft.components;

import raft.role.NodeId;
import raft.timer.Scheduler;

public class NodeContext
{
    private NodeId selfId;
    private Scheduler scheduler;
    private TaskExecutor taskExecutor;

    public NodeId getSelfId()
    {
        return selfId;
    }

    public void setSelfId(NodeId selfId)
    {
        this.selfId = selfId;
    }

    public Scheduler getScheduler()
    {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler)
    {
        this.scheduler = scheduler;
    }

    public TaskExecutor getTaskExecutor()
    {
        return taskExecutor;
    }

    public void setTaskExecutor(TaskExecutor taskExecutor)
    {
        this.taskExecutor = taskExecutor;
    }
}
