package Graph;

class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; this.next = null; }
}

public class LList {
    private Node nodeAwal, nodeAkhir;
    
    public LList() { nodeAwal = nodeAkhir = null; }
    
    public void sisipDiAkhir(int dt) {
        Node newNode = new Node(dt);
        if (kosong()) { nodeAkhir = nodeAwal = newNode; } 
        else { nodeAkhir.next = newNode; nodeAkhir = newNode; }
    }
    
    public int hapusDrDepan() {
        int itemDihapus = -99;
        if (!kosong()) {
            itemDihapus = nodeAwal.data;
            if (nodeAwal == nodeAkhir) { nodeAwal = nodeAkhir = null; } 
            else { nodeAwal = nodeAwal.next; }
        }
        return itemDihapus;
    }
    
    public boolean kosong() { return nodeAwal == null; }
}