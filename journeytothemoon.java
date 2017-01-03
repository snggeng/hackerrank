/*
JOURNEY TO THE MOON
Source: https://www.hackerrank.com/challenges/journey-to-the-moon
Keywords: Graph Theory, Combinatrics, Disjoint Sets
*/


import java.io.*;
import java.util.*;

public class Solution {
    public static class Graph {
        private Map<Integer, Set<Integer>> graph = new HashMap<>();
        private Set<Integer> visited = new HashSet<>();
        private List<Long> components = new ArrayList<>();

        public Set<Integer> adj(Integer v){
            return graph.get(v);
        }

        public void addEdge(Integer v, Integer u) {
            Set<Integer> adj = graph.get(v);
            if (adj == null) {
                adj = new HashSet<>();
                graph.put(v, adj);
            }
            adj.add(u);
        }

        private int visit(Integer v) {
            int count = 1;
            visited.add(v);
            for (Integer u : graph.get(v)) {
                if (!visited.contains(u)) {
                    count += visit(u);
                }
            }
            return count;
        }

        public void dfs() {
            for (Integer v : graph.keySet()) {
                if (!visited.contains(v)) {
                    components.add((long)visit(v));
                }
            }
        }

        public List<Long> components() {
            return components;
        }
    }

   public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);

        // initialize graph
        Graph g = new Graph();

        for(int i = 0; i < I; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
          // Store a and b in an appropriate data structure of your choice
            g.addEdge(a, b);
            g.addEdge(b, a);
        }

        // Compute the final answer - the number of combinations
        // Ways = N choose 2 - (∑(Mi Choose 2) for i = 1 to M)

        // calculate number of connected components
        g.dfs();

        // N choose 2
        long combinations = (((long) (N - 1)) * ((long) N)) / 2;
        // subtract sum of i for each item i in arraylist from combinations
        for (int i = 0; i < g.components().size(); i++) {
            combinations -= (g.components().get(i) - 1) * g.components().get(i) / 2;
        }

        System.out.println(combinations);

    }
}
