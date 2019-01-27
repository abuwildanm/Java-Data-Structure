package Collections.List.LinkedList;

public class CircularSLL implements LinkedList1 {
    CircularSLLNode head, tail;

    public CircularSLL() {
        head = tail = null;
    }

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
        CircularSLLNode newest = new CircularSLLNode(newData, null);
        if (isEmpty()) {
            head = tail = newest;
        }
        else {
            newest.next = head;
            head = newest;
        }
        tail.next = head;
    }

    @Override
    public void addLast(Object newData) {
        CircularSLLNode newest = new CircularSLLNode(newData, null);
        if (isEmpty()) {
            head = tail = newest;
        }
        else {
            tail.next = newest;
            tail = newest;
        }
        tail.next = head;
    }

    @Override
    public void insertBefore(Object newData, Object theData) {
        CircularSLLNode newest = new CircularSLLNode(theData, null);
        CircularSLLNode beforePointer = null;
        CircularSLLNode pointer = head;
        
        if (isEmpty()) {
            head = tail = newest;
        }
        else {
            do {
                if (pointer.data.equals(theData)) {
                    newest.next = pointer;
                    beforePointer.next = newest;
                }
                beforePointer = pointer;
                pointer = pointer.next;
            } while (pointer != head);
        }
        tail.next = head;
    }

    @Override
    public void insertAfter(Object newData, Object theData) {
        CircularSLLNode newest = new CircularSLLNode(theData, null);
        CircularSLLNode pointer = head;
        
        if (isEmpty()) {
            head = tail = newest;
        }
        else {
            do {
                if (pointer.data.equals(theData)) {
                    newest.next = pointer.next;
                    pointer.next = newest;
                }
                pointer = pointer.next;
            } while (pointer != head);
            
        }
        tail.next = head;
    }

    @Override
    public Object removeFirst() {
        if (isEmpty()) return null;
        
        Object removed = head.data;
        head = head.next;
        tail.next = head;
        
        return removed;
    }

    @Override
    public Object removeLast() {
        if (isEmpty()) return null;
        
//        int counter = 0;
        CircularSLLNode beforePointer = null;
        CircularSLLNode pointer = head;
        Object removed = tail.data;
        
        do {
//            if (counter == size() - 2) {
//                tail = pointer;
//                tail.next = head;
//            }
//            counter++;
            
            if (pointer.equals(tail)) {
                tail = beforePointer;
                tail.next = head;
            }
            beforePointer = pointer;
            pointer = pointer.next;
        } while (pointer != head);
        
        return removed;
    }

    @Override
    public Object removeData(Object theData) {
        CircularSLLNode beforePointer = null;
        CircularSLLNode pointer = head;
        Object removed = null;
        
        if (isEmpty()) return null;
        
        do {
            if (pointer.data.equals(theData)) {
                removed = pointer.data;
                beforePointer.next = pointer.next;
            }
            beforePointer = pointer;
            pointer = pointer.next;
        } while (pointer != head);
        
        return removed;
    }

    @Override
    public int size() {
        int counter = 0;
        CircularSLLNode p = head;
        
        do {
            counter++;
            p = p.next;
        } while (p != head);
        
        return counter;
    }
    
    public void rotate() {
        if (!isEmpty()) {
            head = head.next;
        }
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
        CircularSLLNode p = head;
        
        do {
            System.out.print(p.data + " -> ");
            p = p.next;
        } while (p != head);
        System.out.println("");
    }
    
    public void print(String kom) {
        System.out.println(kom);
        CircularSLLNode p = head;
        
        do {
            System.out.print(p.data + " -> ");
            p = p.next;
        } while (p != head);
        System.out.println("");
    }
    
    public static void main(String[] args) {
        CircularSLL csll = new CircularSLL();
        csll.addFirst(67);
        csll.addFirst(90);
        csll.addLast(100);
        csll.addLast(25);
        csll.print("List Awal");
        System.out.println("Size : " + csll.size());
//        csll.removeFirst();
//        csll.removeLast();
//        csll.print("Coba remove");
//        csll.addLast(70);
//        csll.insertBefore(50, 100);
//        csll.print("Coba insertBefore");
//        csll.insertAfter(80, 50);
//        csll.print("Coba insertAfter");
        csll.removeData(25);
        csll.print("Coba remove");
        csll.rotate();
        csll.print("Coba rotate");
    }
}
