import java.util.Stack;

public class Tester {
  public static void main(String[] args) {

    // provide the inputs in the order: N, M, T, C, M times->(U,V), X, Y
    int arr[][] = { { 6, 5, 8, 3, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 1, 2 }, //shortest path test
                    { 4, 3, 3, 2, 1, 2, 2, 3, 3, 4, 1, 4 },//the case where T>C
                    { 4, 4, 3, 3, 1, 2, 1, 3, 2, 4, 2, 3, 1, 4 } };//the case where T=C

    for (int k = 0; k < arr.length; k++) {
      int index = 0;
      int N = arr[k][index++];
      int M = arr[k][index++];
      int T = arr[k][index++];
      int C = arr[k][index++];
      Graph g = new Graph(N);
      int X = arr[k][arr[k].length - 2];
      int Y = arr[k][arr[k].length - 1];

      for (int i = 0; i < M; i++) {
        int U = arr[k][index++];
        int V = arr[k][index++];
        g.addEdge(U - 1, V - 1);
      }

      BreadthFirstPaths s = new BreadthFirstPaths(g, X - 1);
      Stack<Integer> stack = s.pathTo(Y - 1);
      int size = stack.size();
      int noIsland = 0;
      Stack<Integer> route = new Stack<Integer>();

      for (int i = 0; i < size; i++) {
        route.push(stack.pop() + 1);
        noIsland++;
      }

      int totalTime = 0;
      boolean gateState = true;

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

      System.out.println("TEST CASE:" + (k + 1));

      System.out.print(" Time: " + totalTime);
      System.out.print(" Islands: " + noIsland);
      System.out.println(" Route: " + route);
    }
  }
}
