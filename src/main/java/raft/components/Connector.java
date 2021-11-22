package raft.components;

import raft.components.group.NodeEndpoint;
import raft.rpc.AppendEntriesRPC;
import raft.rpc.AppendEntriesResult;
import raft.rpc.RequestVoteRPC;
import raft.rpc.RequestVoteResult;

import java.util.Collection;

public interface Connector
{
    void initialize();
    void sendRequestRPC(RequestVoteRPC requestVote, Collection<NodeEndpoint> destinationEndpoints);
    void replyRequestVote(RequestVoteResult result, NodeEndpoint destinationEndpoint);
    void sendAppendEntriesRPC(AppendEntriesRPC appendEntriesRPC, NodeEndpoint destinationEndpoint);
    void replyAppendEntries(AppendEntriesResult result, NodeEndpoint destinationEndpoint);
    void close();
}
