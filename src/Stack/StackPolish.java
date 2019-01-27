package Stack;

import java.util.EmptyStackException;

class NodePolish {
    Object data;
    NodePolish next;
    NodePolish(Object data) { this.data = data; }
}

public class StackPolish {
    private NodePolish head, tail, top;
    
    public StackPolish() { head = tail = top = null; }
    
    public boolean isEmpty() { return top == null; }
    
    public Object pop() {
        if (isEmpty()) { throw new EmptyStackException(); }
        Object dataPop = top.data;
        removeFirst();
        top = head;
        return dataPop;
    }
    
    private void removeFirst() {
        if (!isEmpty()) {
            if (tail == head) { head = tail = null; } 
            else { head = head.next; }
        }
    }
    
    private void removeLast() {
        NodePolish temp = head;
        if (!isEmpty()) {
            if (tail == head) { head = tail = null; } 
            else {
                while (temp.next != tail) { temp = temp.next; }
                temp.next = null;
                tail = temp;
                temp = null;
            }
        }
    }
    
    public void push(Object dt) { addFirst(dt); top = head; }
    
    private void addFirst(Object dt) {
        NodePolish newNode = new NodePolish(dt);
        if (isEmpty()) { head = tail = newNode; } 
        else { newNode.next = head; head = newNode; }
    }
    
    private void addLast(Object dt) {
        NodePolish newNode = new NodePolish(dt);
        if (isEmpty()) { head = tail = newNode; } 
        else { tail.next = newNode; tail = newNode; }
    }
    
    public Object peek() { return top.data; }
    
    public void cetak(String komentar) {
        System.out.println(komentar);
        NodePolish pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + "<-");
            pointer = pointer.next;
        }
        System.out.println("");
    }
}