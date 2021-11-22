package raft.components;

import com.google.common.eventbus.EventBus;
import raft.components.nodestore.NodeStore;
import raft.role.NodeId;
import raft.timer.Scheduler;

import java.util.concurrent.ExecutorService;

public class NodeContext
{
    private NodeId selfId;
    private Scheduler scheduler;
    //    private TaskExecutor taskExecutor;
    private ExecutorService executor;
    private Connector connector;
    private EventBus eventBus;
    private NodeStore store;
    private NodeGroup group;

    public ExecutorService getExecutor()
    {
        return executor;
    }

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

    public void setExecutor(ExecutorService executor)
    {
        this.executor = executor;
    }

    public Connector getConnector()
    {
        return connector;
    }

    public void setConnector(Connector connector)
    {
        this.connector = connector;
    }

    public EventBus getEventBus()
    {
        return eventBus;
    }

    public void setEventBus(EventBus eventBus)
    {
        this.eventBus = eventBus;
    }

    public NodeStore getStore()
    {
        return store;
    }

    public void setStore(NodeStore store)
    {
        this.store = store;
    }

    public NodeGroup getGroup()
    {
        return group;
    }

    public void setGroup(NodeGroup group)
    {
        this.group = group;
    }
}
