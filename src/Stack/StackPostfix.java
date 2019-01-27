package Stack;

import java.util.EmptyStackException;

class NodePostfix {
    Object data;
    NodePostfix next;
    NodePostfix(Object data) {
        this.data = data;
    }
}

public class StackPostfix {
    private NodePostfix head, tail, top;
    
    public StackPostfix() {
        head = tail = top = null;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object dataPop = top.data;
        removeLast();
        top = tail;
        return dataPop;
    }
    
    private void removeFirst() {
        if (!isEmpty()) {
            if (tail == head) {
                head = tail = null;
            } else {
                head = head.next;
            }
        }
    }
    
    private void removeLast() {
        NodePostfix temp = head;
        if (!isEmpty()) {
            if (tail == head) {
                head = tail = null;
            } else {
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                temp = null;
            }
        }
    }
    
    public void push(Object dt) {
        addLast(dt);
        top = tail;
    }
    
    private void addFirst(Object dt) {
        NodePostfix newNode = new NodePostfix(dt);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    
    private void addLast(Object dt) {
        NodePostfix newNode = new NodePostfix(dt);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public Object peek() {
        return top.data;
    }
    
    public void print(String komentar) {
        System.out.print(komentar + " : ");
        NodePostfix pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.println("");
    }
}
