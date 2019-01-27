package Collections.List.LinkedList;

public class CircularSLLNode {
    Object data;
    CircularSLLNode next;

    public CircularSLLNode() {
        data = null;
        next = null;
    }

    public CircularSLLNode(Object data, CircularSLLNode next) {
        this.data = data;
        this.next = next;
    }
}
