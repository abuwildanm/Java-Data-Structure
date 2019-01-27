package Graph;

public class MainClass {

    public static void main(String[] args) {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(8);
        graph.addEdge(0, 1, 1); 
        graph.addEdge(0, 4, 4);
        graph.addEdge(1, 0, 1); 
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 1, 3); 
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 7, 7);
        graph.addEdge(4, 2, 2); 
        graph.addEdge(4, 6, 6);
        graph.addEdge(6, 4, 6); 
        graph.addEdge(6, 7, 7);
        graph.addEdge(7, 5, 5);
        System.out.println("Hasil penelusuran BFS mulai node 0 : ");
        graph.BreadthFirstSearch(0);
        System.out.println("Hasil penelusuran DFS mulai node 0 : ");
        graph.DepthFirstSearch(0);
        System.out.println("");
        System.out.println("Tetangga dari node 1             : " + graph.neighbour(1));
        System.out.println("Jarak antara node 1 dan 2        : " + graph.getWeight(1, 2));
        System.out.println("Jarak terpendek dari node 0 ke 5 : " + graph.shortestPath(0, 5));
    }
}