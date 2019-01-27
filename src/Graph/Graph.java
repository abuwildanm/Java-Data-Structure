package Graph;

public class Graph {
    private class Node {
        private int data;
        private Node next;
        private int jarak;
        public Node(int dt, Node n, int jarak) {
            data = dt;
            next = n;
            this.jarak = jarak;
        }
        public int getDt() {
            return data;
        }
        public Node getNext() {
            return next;
        }
        public int getJarak() {
            return jarak;
        }
    }
    private Node[] node;
    private int jNode;

    public Graph(int n) {
        jNode = n;
        node = new Node[jNode];
        for (int i = 0; i < jNode; i++) {
            node[i] = null;
        }
    }
    public void addAdj(int head, int adj, int jarak) {
        Node n = new Node(adj, node[head], jarak);
        node[head] = n;
    }
    public void cetak() {
        for (int i = 0; i < jNode; i++) {
            System.out.print("[" + i + "]");
            Node n = node[i];
            while (n != null) {
                System.out.print("->" + n.getDt());
                n = n.getNext();
            }
            System.out.println();
        }
    }
    public int edgeIn(int index) {
        int counter = 0;
        for (int i = 0; i < jNode; i++) {
            Node n = node[i];
            while (n != null) {
                if (n.getDt() == index) {
                    counter++;
                }
                n = n.getNext();
            }
        }
        return counter;
    }
    public int edgeOut(int index) {
        int counter = 0;
        Node n = node[index];
        while (n != null) {
            counter++;
            n = n.getNext();
        }
        return counter;
    }
    public void ajdMatrik() {
        int matrik[][] = new int[jNode][jNode];
        for (int i = 0; i < jNode; i++) {
            Node n = node[i];
            while (n != null) {
                matrik[n.getDt()][i] = 1;
                n = n.getNext();
            }
        }
        for (int j = 0; j < jNode; j++) {
            for (int k = 0; k < jNode; k++) {
                System.out.print(matrik[j][k] + " ");
            }
            System.out.println("");
        }
    }
    public void bfs() {
        int status[] = new int[jNode];
        for (int i = 0; i < jNode; i++) {
            status[i] = 0;
        }
        System.out.print(0);
        status[0] = 1;
        for (int i = 0; i < jNode; i++) {
            Node n = node[i];
            while (n != null) {
                if (status[n.data] == 1) {
                } else {
                    System.out.print("->" + n.getDt());
                    status[n.data] = 1;
                }
                n = n.getNext();
            }

        }
        System.out.println("");
    }
    public void dfs(int start) {
        int status[] = new int[jNode];
        for (int i = 0; i < jNode; i++) {
            status[i] = 0;
        }
        System.out.print(start);
        status[start] = 1;
        dfs(start, status);
        System.out.println("");
    }
    private void dfs(int start, int status[]) {
        Node n = node[start];
        while (n != null) {
            if (status[n.data] == 1) {
            } else {
                System.out.print("->" + n.data);
                status[n.data] = 1;
                dfs(n.data, status);
            }
            n = n.next;
        }
    }   
    public int shortesPath(int start, int destination) {
        int counter = 0;
        Node queue[] = new Node[jNode];
        int status[] = new int[jNode];
        for (int i = 0; i < jNode; i++) {
            status[i] = 0;
        }
        queue[0] = node[start];
        status[start] = 1;
        counter++;
        shortesPath(start, status, queue, counter);
        int temp = 0;
        for (int i = 0; i < jNode; i++) {
            temp += queue[i].jarak; 
            if(queue[i].data == destination){
                break;
            }
        }
        return temp;
    }
    private void shortesPath(int start, int status[], Node queue[], int counter) {
        Node n = node[start];
        while (n != null) {
            if (status[n.data] == 1) {
            } else {
                queue[counter] = n;
                status[n.data] = 1;
                counter++;
                shortesPath(n.data, status, queue, counter);
            }
            n = n.next;
        }
    }
    public static void main(String s[]) {
        Graph g = new Graph(5);
        g.addAdj(0, 3, 1);
        g.addAdj(0, 1, 3);
        g.addAdj(1, 4, 5);
        g.addAdj(1, 2, 3);
        g.addAdj(2, 4, 4);
        g.addAdj(2, 1, 2);
        g.addAdj(4, 3, 5);
        g.cetak();
        System.out.println("");
        System.out.println("Edge Masuk Node 4 : " + g.edgeIn(4));
        System.out.println("Edge Keluar Node 4 : " + g.edgeOut(4));
        System.out.println("");
        System.out.println("Representasi Matrik Adjacency");
        g.ajdMatrik();
        System.out.println("");
        System.out.println("BFS :");
        g.bfs();
        System.out.println("DFS dari 0:");
        g.dfs(0);
        System.out.println("");
        System.out.println("Jarak Terpendek Dari Node 0 Ke 4 : " + g.shortesPath(0, 4));
    }
}