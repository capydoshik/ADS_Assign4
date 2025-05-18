import java.util.*;

public class WeightedGraph<T> {
    private final Map<Vertex<T>, List<Edge<T>>> adjacencyMap = new HashMap<>();

    public void addVertex(Vertex<T> vertex) {
        adjacencyMap.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination, double weight) {
        this.addVertex(source);
        this.addVertex(destination);
        adjacencyMap.get(source).add(new Edge<>(destination, weight));
    }

    public List<Edge<T>> getNeighbors(Vertex<T> vertex) {
        return adjacencyMap.getOrDefault(vertex, new ArrayList<>());
    }

    public Set<Vertex<T>> getVertices() {
        return adjacencyMap.keySet();
    }

    public static class Edge<T> {
        public final Vertex<T> destination;
        public final double weight;

        public Edge(Vertex<T> destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
