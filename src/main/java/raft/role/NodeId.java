package raft.role;

import java.io.Serializable;
import java.util.Objects;

public class NodeId implements Serializable
{
    private final String value;

    public NodeId(String value)
    {
        this.value = value;
    }

    public static NodeId of(String value)
    {
        return new NodeId(value);
    }
    public boolean equals(Object o){

        if (this == o) return true;
        if (! (o instanceof NodeId)) return false;
        NodeId id = (NodeId) o;
        return Objects.equals(value , id.value);
    }

    public String getValue()
    {
        return value;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(value);
    }

    @Override
    public String toString()
    {
        return this.value;
    }
}
