import java.util.*;

public class AdjacencyListGraph<E> implements Graph<E> {
    //From Video
    Map<Node<E>, List<Node<E>>> adjacencyList;

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

    //add a new empty node to the adjacency list and give it an empty array list so it can have a placeholder for possible edges
    @Override
    public void addNode(Node<E> node) {
        //From Video
        adjacencyList.put(node, new ArrayList<>());
    }

    @Override
    public void addEdge(Node<E> start, Node<E> end) {
        //From Video
        adjacencyList.get(start).add(end);
    }

    @Override
    public void addEdge(Node<E> start, Node<E> end, int cost) {
        //From Video
        adjacencyList.get(start).add(end);

    }

    @Override
    public void addTwoWayEdge(Node<E> start, Node<E> end) {
        adjacencyList.get(start).add(end);
        adjacencyList.get(end).add(start);
    }

    @Override
    public void addTwoWayEdge(Node<E> start, Node<E> end, int cost) {
    }

    @Override
    public Set<Node<E>> getNeighbors(Node<E> node) {
        return null;

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
