public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");

        graph.addEdge(a, b, 2);
        graph.addEdge(a, c, 1);
        graph.addEdge(b, d, 5);
        graph.addEdge(c, d, 2);
        graph.addEdge(d, e, 1);

        System.out.println("BFS:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, a, e);
        System.out.println(bfs.pathTo(e));

        System.out.println("Dijkstra:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, a, e);
        System.out.println(dijkstra.pathTo(e));
    }
}
