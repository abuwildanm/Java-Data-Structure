package Tugas;

public class DoubleLinkedList {
    public DoublyNode head, tail;
    
    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    public void makeEmpty() {
        head = tail = null;
    }

    public void addFirst(Object newData) {
        DoublyNode newest = new DoublyNode(newData, null, null);
        
        if (isEmpty()) {
            head = newest;
            tail = newest;
        }
        else {
            newest.next = head;
            head.prev = newest;
            head = newest;
        }
    }

    public void addLast(Object newData) {
        DoublyNode newest = new DoublyNode(newData, null, null);
        
        if (isEmpty()) {
            head = newest;
            tail = newest;
        }
        else {
            tail.next = newest;
            newest.prev = tail;
            tail = newest;
        }
    }

    public void insertBefore(Object newData, Object theData) {
        DoublyNode newest = new DoublyNode(newData, null, null);
        DoublyNode p = head;
        
        if (isEmpty()) {
            head = newest;
            tail = newest;
        }
        else {
            while (p != null) {
                if (p.data.equals(theData)) {
                    newest.prev = p.prev;
                    newest.next = p;
                    p.prev.next = newest;
                    p.prev = newest;
                }
                p = p.next;
            }
        }
    }

    public void insertAfter(Object newData, Object theData) {
        DoublyNode newest = new DoublyNode(newData, null, null);
        DoublyNode p = head;
        
        if (isEmpty()) {
            head = newest;
            tail = newest;
        }
        else {
            while (p != null) {
                if (p.data.equals(theData)) {
                    newest.prev = p;
                    newest.next = p.next;
                    p.next.prev = newest;
                    p.next = newest;
                }
                p = p.next;
            }
        }
    }

    public Object removeFirst() {
        if (isEmpty()) return null;
        
        Object removed = head.data;
        head = head.next;
        
        return removed;
    }

    public Object removeLast() {
        if (isEmpty()) return null;
        
        Object removed = tail.data;
        tail = tail.prev;
        tail.next = null;
        
        return removed;
    }

    public Object remove(Object theData) {
        DoublyNode p = head;
        Object removed = null;
        
        if (isEmpty()) return null;
        
        while (p != null) {
            if (p.data.equals(theData)) {
                p.prev.next = p.next;
                p.next.prev = p.prev;
            }
            p = p.next;
        }
        
        return removed;
    }

    public int size() {
        int counter = 0;
        DoublyNode p = head;
        
        while (p != null) {
            counter++;
            p = p.next;
        }
        
        return counter;
    }

    public void print() {
        DoublyNode p = head;
        
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.println("[X]");
    }
    
    public void printToTail(String kom) {
        System.out.println(kom);
        DoublyNode p = head;
        
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.println("[X]");
    }
    
    public void printToHead(String kom) {
        System.out.println(kom);
        DoublyNode p = tail;
        
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.prev;
        }
        System.out.println("[X]");
    }
}
