import java.util.*;

public class BreadthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  public BreadthFirstPaths(Graph G, int s) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    bfs(G, s);
  }

  private void bfs(Graph G, int s) {
    Queue<Integer> queue = new LinkedList<Integer>();
    marked[s] = true;
    queue.add(s);
    while (!queue.isEmpty()) {
      int v = queue.remove();
      for (int w : G.adj(v))
        if (!marked[w]) {
          edgeTo[w] = v;
          marked[w] = true;
          queue.add(w);
        }
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Stack<Integer> pathTo(int v) {
    if (!hasPathTo(v))
      return null;
    Stack<Integer> path = new Stack<Integer>();
    for (int x = v; x != s; x = edgeTo[x])
      path.push(x);
    path.push(s);
    return path;
  }
}
