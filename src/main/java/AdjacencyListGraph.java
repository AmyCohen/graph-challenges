import java.util.*;

public class AdjacencyListGraph<E> implements Graph<E> {
    //From Video
    Map<Node<E>, Set<Node<E>>> adjacencyList;
    Map<Node<E>, Map<Node<E>, Integer>> costs;

    public AdjacencyListGraph() {
        //From Video
        adjacencyList = new HashMap<>();
    }

    public Set<Node<E>> getNodes() {
        //From Video
        return adjacencyList.keySet();
    }

    public Set<Edge<E>> getEdges() {
        return null;
    }

    //add a new empty node to the adjacency list and give it an empty array list so it can have a placeholder for possible connections
    //add a way to track the costs also by adding a new empty hash map on the node to via costs
    @Override
    public void addNode(Node<E> node) {
        //From Video
        adjacencyList.put(node, new HashSet<>());
        costs.put(node, new HashMap<>());
    }

    @Override
    public void addEdge(Node<E> start, Node<E> end) {
        //From Video
        adjacencyList.get(start).add(end);
    }

    //add a new edge, then use costs to get the start of that edge. It will have a map associated with it that you can then call to put both the end of the edge and the cost associated with it.
    @Override
    public void addEdge(Node<E> start, Node<E> end, int cost) {
        //From Video
        addEdge(start, end);
        Map<Node<E>, Integer> options = costs.get(start);
        options.put(end, cost);
    }

    @Override
    public void addTwoWayEdge(Node<E> start, Node<E> end) {
        //From Video
        addEdge(start, end);
        addEdge(end, start);
    }

    @Override
    public void addTwoWayEdge(Node<E> start, Node<E> end, int cost) {
        //From Video
        addEdge(start, end, cost);
        addEdge(end, start, cost);
    }

    @Override
    public Set<Node<E>> getNeighbors(Node<E> node) {
        //From Video
        return adjacencyList.get(node);
    }

    @Override
    public boolean isConnected(Node<E> start, Node<E> end) {
        return false;
    }

    @Override
    public Edge<E> getEdge(Node<E> start, Node<E> end) {
        return null;

    }

    private void checkNodesExists(Node<E> node1, Node<E> node2) {
    }

    // leverage method overloading and use plural naming even for the single node check
    // because it's way easier to write the same method name everywhere than to remember to
    // write either "node" vs "nodes" in "checkNodeExists" or "checkNodesExists"
    private void checkNodesExists(Node<E> node) {
    }
}
