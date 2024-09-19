import graphs.ConnectedComponents;

import java.util.*;


public class Main {

    private static void testCCMatrix() {
        int n = 5;
        Random r = new Random();
        boolean [][] graph = new boolean[n][n];
        int j = r.nextInt(n);
        for(int i = 0; i < n; i++) {
            if (i != j) {
                boolean val = r.nextBoolean();
                graph[j][i] = val;
                graph[i][j] = val;
            }
        }
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
        for(List<Integer> component : ConnectedComponents.components(graph)) {
            System.out.println(component.toString());
        }
    }

    private static void testCCHashMap() {
        Random r = new Random();
        int n = r.nextInt(20);
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(r.nextBoolean()) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        for(int key : graph.keySet()) {
            System.out.printf("%d: %s\n", key, graph.get(key).toString());
        }
        for(List<Integer> component : ConnectedComponents.components(graph)) {
            System.out.println(component.toString());
        }
    }

    public static void main(String[] args) {
        testCCMatrix();
        testCCHashMap();
    }
}
