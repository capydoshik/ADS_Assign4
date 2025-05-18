import java.util.*;

public class BreadthFirstSearch<T> extends Search<T> {
    private final Map<Vertex<T>, Vertex<T>> edgeTo = new HashMap<>();
    private final Set<Vertex<T>> visited = new HashSet<>();

    public BreadthFirstSearch(WeightedGraph<T> graph, Vertex<T> start, Vertex<T> end) {
        super(start, end);
        bfs(graph, start);
    }

    private void bfs(WeightedGraph<T> graph, Vertex<T> source) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        visited.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            for (WeightedGraph.Edge<T> edge : graph.getNeighbors(current)) {
                Vertex<T> neighbor = edge.destination;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(Vertex<T> vertex) {
        return visited.contains(vertex);
    }

    @Override
    public List<Vertex<T>> pathTo(Vertex<T> vertex) {
        if (!hasPathTo(vertex)) return null;

        LinkedList<Vertex<T>> path = new LinkedList<>();
        for (Vertex<T> x = vertex; !x.equals(start); x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(start);
        return path;
    }
}
