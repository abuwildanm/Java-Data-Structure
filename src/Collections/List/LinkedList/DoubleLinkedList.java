package Collections.List.LinkedList;

public class DoubleLinkedList implements LinkedList1 {
    public DoublyNode head, tail;
    
    @Override
    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    @Override
    public void makeEmpty() {
        head = tail = null;
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public Object removeFirst() {
        if (isEmpty()) return null;
        
        Object removed = head.data;
        head = head.next;
        
        return removed;
    }

    @Override
    public Object removeLast() {
        if (isEmpty()) return null;
        
        Object removed = tail.data;
        tail = tail.prev;
        tail.next = null;
        
        return removed;
    }

    @Override
    public Object removeData(Object theData) {
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

    @Override
    public int size() {
        int counter = 0;
        DoublyNode p = head;
        
        while (p != null) {
            counter++;
            p = p.next;
        }
        
        return counter;
    }

    @Override
    public int indexOf(Object theData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Object theData, int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object removeIndex(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
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
    
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.addLast(10);
        dll.addLast(20);
        dll.addLast(30);
        dll.addLast(40);
        dll.addLast(50);
        
        dll.printToTail("DLL Asal");
        dll.addFirst(60);
        dll.printToTail("Coba addFirst");
        dll.insertBefore(70, 20);
        dll.printToTail("Coba insertBefore");
        dll.insertAfter(80, 30);
        dll.printToTail("Coba insertAfter");
        dll.removeFirst();
        dll.printToTail("Coba removeFirst");
        dll.removeLast();
        dll.printToTail("Coba removeLast");
        dll.removeData(30);
        dll.printToTail("Coba remove");
    }
}
