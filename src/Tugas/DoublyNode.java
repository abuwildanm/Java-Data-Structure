package Tugas;

public class DoublyNode {
    public Object data;
    public DoublyNode prev;
    public DoublyNode next;
        
    public DoublyNode() {
        data = null;
        next = null;
    }

    public DoublyNode(Object data, DoublyNode prev,  DoublyNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
