import java.util.Scanner;
import java.util.Stack;

public class index {
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    String[] arr1 = in.nextLine().split(" ");// splitting the string input
    int N = Integer.parseInt(arr1[0]);// number of vertices
    int M = Integer.parseInt(arr1[1]);// number of edges
    int T = Integer.parseInt(arr1[2]);// gate switch time
    int C = Integer.parseInt(arr1[3]);// traverse an edge time
    Graph g = new Graph(N);// initilazing the graph with N

    for (int i = 0; i < M; i++) {// adding edges M times
      String[] arr2 = in.nextLine().split(" ");
      int U = Integer.parseInt(arr2[0]);
      int V = Integer.parseInt(arr2[1]);
      g.addEdge(U - 1, V - 1);// connecting U to V decrasing each by one,
      // since question assumes that the islands start from 1
    }

    String[] arr = in.nextLine().split(" ");
    int X = Integer.parseInt(arr[0]);// starting vertex
    int Y = Integer.parseInt(arr[1]);// ending vertex

    BreadthFirstPaths s = new BreadthFirstPaths(g, X - 1);// initilazing bfs,
    // decreasing x by one since the starting point of islands is 1
    Stack<Integer> stack = s.pathTo(Y - 1);// getting the path to Y

    int size = stack.size();

    int noIsland = 0;
    Stack<Integer> route = new Stack<Integer>();
    // bft returns the route as a reversed stack, moving it into a new stack so it
    // reverses.
    for (int i = 0; i < size; i++) {
      route.push(stack.pop() + 1);
      noIsland++;
    }

    int totalTime = 0;
    boolean gateState = true;// gatestate is true since the gate is open at the beggining

    // looping through each island excluding the last
    for (int i = 0; i < noIsland - 1; i++) {
      // if the gate is closed add the remaining time
      if (!gateState) {
        totalTime += T - (totalTime % T);
        gateState = true;
      }
      // add the road time taken
      totalTime += C;
      // switch the gatestate according to the totaltime
      for (int j = totalTime / T; j > 0; j--) {
        gateState = !(gateState);
      }
    }

    System.out.println((noIsland));
    System.out.println((route));
    System.out.println(totalTime);
  }
}
