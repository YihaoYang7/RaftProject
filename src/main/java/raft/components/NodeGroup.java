package raft.components;

import raft.components.group.GroupMember;
import raft.components.group.NodeEndpoint;
import raft.role.NodeId;

import java.util.Collection;
import java.util.Map;

public class NodeGroup
{
    private final NodeId selfId;
    private Map<NodeId, GroupMember> memberMap;

    public NodeGroup(NodeId selfId)
    {
        this.selfId = selfId;
    }

    public Collection<NodeEndpoint> listEndPointExceptSelf()
    {
        return null;
    }
}
