package Tugas;

public class StackDLL {
    DoublyNode top;
    DoubleLinkedList dll = new DoubleLinkedList();
    
    public StackDLL() {
        top = dll.head = dll.tail = null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void makeEmpty() {
        top = dll.head = dll.tail = null;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        
        Object removedData = dll.removeLast();
        top = dll.tail;
        return removedData;
    }

    public void push(Object data) {
        dll.addLast(data);
        top = dll.tail;
    }
    
    public void print() {
        DoublyNode p = dll.tail;
        while (p != null) {
            System.out.println(p.data);
            p = p.prev;
        }
        System.out.println("-----");
    }
    
    public void print(String kom) {
        System.out.println(kom);
        DoublyNode p = dll.tail;
        while (p != null) {
            System.out.println(p.data);
            p = p.prev;
        }
        System.out.println("-----");
    }
}
