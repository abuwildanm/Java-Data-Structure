package Graph;

import java.util.*;

public class AdjacencyMatrixGraph {
    
    private int size;
    private boolean[][] adj;
    private int weight[][];
    
    AdjacencyMatrixGraph(int size) {
        this.size = size;
        this.adj = new boolean[size][size];
        this.weight = new int[size][size];
    }
    
    void addEdge(int i, int j, int jarak) {
        this.adj[i][j] = true;
        this.weight[i][j] = jarak;
    }
    
    void addEdge(int i, int j) { this.adj[i][j] = true; }
    
    void removeEdge(int i, int j) {
        this.adj[i][j] = false;
        this.weight[i][j] = 0;
    }
    
    boolean hasEdge(int i, int j) { return this.adj[i][j]; }
    
    int getWeight(int start, int end) { return weight[start][end]; }
    
    List <Integer> outEdges(int i) {
        List<Integer> edges = new ArrayList<Integer>();
        for (int j = 0; j < size; j++) if (this.adj[i][j]) edges.add(j);
        return edges;
    }
    
    List <Integer> inEdges(int i) {
        List <Integer> edges = new ArrayList<Integer>();
        for (int j = 0; j < size; j++) if (this.adj[j][i]) edges.add(j);
        return edges;
    }
    
    //BFS menggunakan antrian
    public void BreadthFirstSearch(int nodeAwal) {
        boolean[] terkunjungi = new boolean[size];
        Queue q = new Queue();
        q.enqueue(nodeAwal);
        terkunjungi[nodeAwal] = true;
        System.out.printf("%d ", nodeAwal);
        while (!q.isEmpty()) {
            int i = q.dequeue();
            for (int j : this.outEdges(i)) {
                if (!terkunjungi[j]) {
                    q.enqueue(j);
                    terkunjungi[j] = true;
                    System.out.printf("%d ", j);
                }
            }
        }
        System.out.println("");
    }
    
//    //DFS menggunakan stack
//    public void DepthFirstSearch(int nodeAwal) {
//        boolean[] terkunjungi = new boolean[size];
//        Stack s = new Stack();
//        s.push(nodeAwal);
//        terkunjungi[nodeAwal] = true;
//        System.out.printf("%d ", nodeAwal);
//        while (!s.isEmpty()) {
////            int i = (int)s.pop();
//            Integer i = (Integer)s.peek();
////            int i = this.outEdges((int)s.peek());
////            for (int j : this.outEdges(i)) {
////                if (!terkunjungi[j]) {
////                    s.push(j);
////                    terkunjungi[j] = true;
////                    System.out.printf("%d ", j);
////                }
////                i = (int)s.pop();
////            }
//            Iterator <Integer> j = this.outEdges(i).iterator();
//            if (j.hasNext()) {
//                int k = j.next();
//                
//                if (!terkunjungi[k]) {
//                    s.push(j);
//                    terkunjungi[k] = true;
//                    System.out.printf("%d ", k);
//                }
//            }
//            else {
//                s.pop();
//            }
//
////            while (this.outEdges(i) != null) {
////                Iterator <Integer> j = this.outEdges(i).iterator();
////                if (!terkunjungi[j.next()]) {
////                    s.push(j);
////                    terkunjungi[j.next()] = true;
////                    System.out.print(j);
////                }
////                i = (int)s.pop();
////            }
//            
//        }
//        System.out.println("");
//    }
    
    public void DepthFirstSearch(int vertex) {
        DepthFirstSearch(vertex, new boolean[size]);
        System.out.println();
    }
    
    private void DepthFirstSearch(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.printf("%d ", vertex);
        
        for (int j : this.outEdges(vertex)) {
            if (!visited[j]) { DepthFirstSearch(j, visited); visited[j] = true; }
        }
    }
    
    public List<Integer> neighbour(int vertex) {
        List<Integer> neighbour = new ArrayList<Integer>();
        for (int j = 0; j < size; j++)
            if (this.adj[j][vertex] != false || this.adj[vertex][j] != false)
                neighbour.add(j);
        return neighbour;
    }
    
    private int shortestPath(int start, int destination, Stack<Integer> stack) {
        List <Integer> list = this.outEdges(start), values = new ArrayList();
        int n;
        
        if (start == destination) return 0;
        if (list.isEmpty() && start != destination) return -1;
        
        stack.push(start);
        
        int jarak;
        for (int i : list) 
            if ((jarak = weight[start][i]) != 0) {
                if (stack.indexOf(i) != -1) n = -1;
                else if ((n = shortestPath(i, destination, stack)) != -1)
                    values.add(n + jarak);
            }
        
        stack.pop();
        if (values.isEmpty()) return -1;
        return getSmallestListValue(values);
    }
    
    public int shortestPath(int start, int destination) {
        return shortestPath(start, destination, new Stack<Integer>());
    }
    
    public int getSmallestListValue(List<Integer> list) {
        if (list.isEmpty()) return 0;
        int min = list.get(0);
        for (int i : list) if (min > i) min = i;
        return min;
    }
}