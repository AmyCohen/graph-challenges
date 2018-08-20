import java.util.*;

public class AdjacencyListGraph<E> implements Graph<E> {
    //From Video
    Map<Node<E>, Set<Node<E>>> adjacencyList;
    Map<Node<E>, Map<Node<E>, Edge>> costs;
    Set<Edge<E>> edges;

    public AdjacencyListGraph() {
        //From Video
        adjacencyList = new HashMap<>();
        costs = new HashMap<>();
        edges = new HashSet<>();
    }

    public Set<Node<E>> getNodes() {
        //From Video
        return adjacencyList.keySet();
    }

    public Set<Edge<E>> getEdges() {
        return edges;
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
        checkNodesExists(start, end);
        addEdge(start, end, 0);
    }

    //add a new edge, then use costs to get the start of that edge. It will have a map associated with it that you can then call to put both the end of the edge and the cost associated with it.
    @Override
    public void addEdge(Node<E> start, Node<E> end, int cost) {
        //From Video
        checkNodesExists(start, end);

        Map<Node<E>, Edge> options = costs.get(start);
        Edge edge  = new Edge(start, end, cost);
        adjacencyList.get(start).add(end);

        options.put(end, edge);
        edges.add(edge);
    }

    @Override
    public void addTwoWayEdge(Node<E> start, Node<E> end) {
        //From Video
        checkNodesExists(start, end);
        addTwoWayEdge(start, end, 0);
    }

    @Override
    public void addTwoWayEdge(Node<E> start, Node<E> end, int cost) {
        //From Video
        checkNodesExists(start, end);
        addEdge(start, end, cost);
        addEdge(end, start, cost);
    }

    @Override
    public Set<Node<E>> getNeighbors(Node<E> node) {
        //From Video
        checkNodesExists(node);
        return adjacencyList.get(node);
    }

    @Override
    public boolean isConnected(Node<E> start, Node<E> end) {
        //From Video (boolean zen!)
        checkNodesExists(start, end);
        return adjacencyList.get(start).contains(end);
    }

    //Steve's example for why this would be useful:
    //Edge edge = graph.getEdge(seattle, bellingham);
    //sout("It costs: " + edge.cost + " to go from "
    //      + edge.start + " to " + edge.edge);
    @Override
    public Edge<E> getEdge(Node<E> start, Node<E> end) {
        //From Video
        checkNodesExists(start, end);
        return costs.get(start).get(end);
    }

    private void checkNodesExists(Node<E> node1, Node<E> node2) {
        //From Video
        checkNodesExists(node1);
        checkNodesExists(node2);
    }

    // leverage method overloading and use plural naming even for the single node check
    // because it's way easier to write the same method name everywhere than to remember to
    // write either "node" vs "nodes" in "checkNodeExists" or "checkNodesExists"
    private void checkNodesExists(Node<E> node) {
        //From Video
        if (!adjacencyList.containsKey(node)) {
            String message = "Attempt to access node that is not in the graph. Node: " + node;
            throw new IllegalArgumentException(message);
        }
    }

}

