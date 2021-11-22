package raft.components.group;

import raft.log.ReplicationState;

public class GroupMember
{
    private final NodeEndpoint endpoint;
    private ReplicationState replicationState;

    public GroupMember(NodeEndpoint endpoint)
    {
        this(endpoint,null);
    }

    public GroupMember(NodeEndpoint endpoint, ReplicationState replicationState)
    {
        this.endpoint = endpoint;
        this.replicationState = replicationState;
    }

    public NodeEndpoint getEndpoint()
    {
        return endpoint;
    }

    public ReplicationState getReplicationState()
    {
        return replicationState;
    }

    public void setReplicationState(ReplicationState replicationState)
    {
        this.replicationState = replicationState;
    }
}
