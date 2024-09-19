package graphs;

import java.util.*;

public class ConnectedComponents {

    public static List<List<Integer>> components(boolean [][] graph) {
        int n = graph.length;
        ArrayList<List<Integer>> ccs = new ArrayList<>();
        boolean [] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                ccs.add(BFS(i, graph, visited));
            }
        }
        return ccs;
    }

    public static List<List<Integer>> components(HashMap<Integer, List<Integer>> graph) {
        int n = graph.keySet().size();
        ArrayList<List<Integer>> ccs = new ArrayList<>();
        boolean [] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                ccs.add(BFS(i, graph, visited));
            }
        }
        return ccs;
    }

    private static List<Integer> BFS(int s, boolean [][] graph, boolean [] visited) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> path = new ArrayList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int vertex = q.poll();
            path.add(vertex);
            for(int i = 0; i < graph.length; i++) {
                if (graph[vertex][i] && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return path;
    }

    private static List<Integer> BFS(int s, HashMap<Integer, List<Integer>> graph, boolean [] visited) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> path = new ArrayList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int vertex = q.poll();
            path.add(vertex);
            for (Integer neigh : graph.get(vertex)) {
                if (!visited[neigh]) {
                    q.add(neigh);
                    visited[neigh] = true;
                }
            }
        }
        return path;
    }
}
