package Collections.List.LinkedList;

public class SinglyNode {
    public Object data;
    public SinglyNode next;
        
    public SinglyNode() {
        data = null;
        next = null;
    }

    public SinglyNode(Object data, SinglyNode next) {
        this.data = data;
        this.next = next;
    }
}