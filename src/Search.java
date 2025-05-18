import java.util.List;

public abstract class Search<T> {
    protected final Vertex<T> start;
    protected final Vertex<T> end;

    public Search(Vertex<T> start, Vertex<T> end) {
        this.start = start;
        this.end = end;
    }

    public abstract boolean hasPathTo(Vertex<T> vertex);
    public abstract List<Vertex<T>> pathTo(Vertex<T> vertex);
}