import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private final Map<Vertex<T>, Double> distance = new HashMap<>();
    private final Map<Vertex<T>, Vertex<T>> edgeTo = new HashMap<>();

    public DijkstraSearch(WeightedGraph<T> graph, Vertex<T> start, Vertex<T> end) {
        super(start, end);
        dijkstra(graph, start);
    }

    private void dijkstra(WeightedGraph<T> graph, Vertex<T> source) {
        PriorityQueue<Vertex<T>> queue = new PriorityQueue<>(Comparator.comparingDouble(distance::get));
        for (Vertex<T> vertex : graph.getVertices()) {
            distance.put(vertex, Double.POSITIVE_INFINITY);
        }

        distance.put(source, 0.0);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();

            for (WeightedGraph.Edge<T> edge : graph.getNeighbors(current)) {
                Vertex<T> neighbor = edge.destination;
                double newDist = distance.get(current) + edge.weight;

                if (newDist < distance.get(neighbor)) {
                    distance.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    queue.remove(neighbor); // re-insert to update priority
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(Vertex<T> vertex) {
        return distance.get(vertex) != Double.POSITIVE_INFINITY;
    }

    @Override
    public List<Vertex<T>> pathTo(Vertex<T> vertex) {
        if (!hasPathTo(vertex)) return null;

        LinkedList<Vertex<T>> path = new LinkedList<>();
        for (Vertex<T> at = vertex; at != null; at = edgeTo.get(at)) {
            path.addFirst(at);
        }
        return path;
    }
}
