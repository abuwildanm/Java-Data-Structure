package Collections.List.LinkedList;

public class SingleLinkedList implements LinkedList1 {
    public SinglyNode head, tail;
    
    @Override
    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    @Override
    public void makeEmpty() {
        head = null;
    }

    @Override
    public void addFirst(Object newData) {
        SinglyNode newest = new SinglyNode();
        newest.data = newData;

//        Node newest = new Node(newData, null); // bisa juga pake ini
        
        if (isEmpty()) {
            head = newest;
            tail = newest;
        } else {
            newest.next = head;
            head = newest;
        }
    }

    @Override
    public void addLast(Object newData) {
        SinglyNode newest = new SinglyNode();
        newest.data = newData;
        
//        Node newest = new Node(newData, null); // bisa juga pake ini
        
        if (isEmpty()) {
            head = newest;
            tail = newest;
        } else {
            tail.next = newest;
            tail = newest;
        }
    }
    
    @Override
    public void insertBefore(Object newData, Object theData) {
        SinglyNode newest = new SinglyNode();
        newest.data = newData;
        SinglyNode beforePointer = null;
        SinglyNode pointer = head;
        
        if (isEmpty()) {
            head = newest;
            tail = newest;
        } else {
            while (pointer != null) {
                if (pointer.data.equals(theData)) {
                    newest.next = pointer;
                    beforePointer.next = newest;
                }
                beforePointer = pointer;
                pointer = pointer.next;
            }
        }
    }
    
    @Override
    public void insertAfter(Object newData, Object theData) {
        SinglyNode newest = new SinglyNode();
        newest.data = newData;
        SinglyNode pointer = head;
        
        if (isEmpty()) {
            head = newest;
            tail = newest;
        } else {
            while (pointer != null) {
                if (pointer.data.equals(theData)) {
                    newest.next = pointer.next;
                    pointer.next = newest;
                }
                pointer = pointer.next;
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
        
//        int counter = 0;
        SinglyNode pointer = head;
        SinglyNode beforePointer = null;
        Object removed = tail.data;
        
        while (pointer != null) {
//            if (counter == size() - 2) {
//                tail = pointer;
//                tail.next = null;
//            }
//            counter++;
            
            if (pointer.equals(tail)) {
                tail = beforePointer;
                tail.next = null;
            }
            beforePointer = pointer;
            pointer = pointer.next;
        }
        
        return removed;
    }
    
    @Override
    public Object removeData(Object theData) {
        if(isEmpty()) return null;
        
        Object removed = null;
        SinglyNode beforePointer = null;
        SinglyNode pointer = head;
        
        while (pointer != null) {
            if (pointer.data.equals(theData)) {
                removed = pointer.data;
                beforePointer.next = pointer.next;
            }
            beforePointer = pointer;
            pointer = pointer.next;
        }
        
        return removed;
    }

    @Override
    public int size() {
        int counter = 0;
        SinglyNode pointer = head;
        
        while (pointer != null) {
            counter++;
            pointer = pointer.next;
        }
        
        return counter;
    }

    @Override
    public void print() {
        SinglyNode pointer = head;
        
        while (pointer != null) {
            System.out.printf("%s -> ", pointer.data);
            pointer = pointer.next;
        }
        System.out.println("");
    }
    
    public void print(String kom) {
        System.out.println(kom);
        SinglyNode pointer = head;
        
        while (pointer != null) {
            System.out.printf("%s -> ", pointer.data);
            pointer = pointer.next;
        }
        System.out.println("");
    }

    @Override
    public int indexOf(Object theData) {
        int index= -1;
        SinglyNode p = head;
        while (p != null) {
            index++;
            if (p.data.equals(theData)) {
                return index;
            }
            p = p.next;
        }
        return -1;
    }

    @Override
    public void add(Object theData, int index) {
        SinglyNode pointer = head;
        int counter = -1;
        while (pointer != null) {
            counter++;
            if (counter == index) {
                insertBefore(theData, pointer.data);
            }
            pointer = pointer.next;
        }
    }

    @Override
    public Object removeIndex(int index) {
        int counter = -1;
        Object removed = null;
        SinglyNode beforeP = null;
        SinglyNode p = head;
        while (p != null) {
            counter++;
            if (counter == index) {
//                removed = removeData(p.data);
                removed = p.data;
                beforeP.next = p.next;
            }
            beforeP = p;
            p = p.next;
        }
        return removed;
    }

    @Override
    public Object get(int index) {
        int counter = -1;
        SinglyNode p = head;
        while (p != null) {
            counter++;
            if (counter == index) {
                return p.data;
            }
            p = p.next;
        }
        return null;
    }
    
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.addFirst(67);
        sll.addFirst(90);
        sll.addLast(100);
        sll.addLast(25);
        sll.print("List Awal");
        System.out.println("Size : " + sll.size());
        sll.removeFirst();
        sll.removeLast();
        sll.print("Coba remove");
        sll.insertBefore(50, 100);
        sll.print("Coba insertBefore");
        sll.insertAfter(80, 50);
        sll.print("Coba insertAfter");
        sll.insertAfter(50, 80);
        sll.print("Coba insertAfter");
//        sll.removeData(50);
//        sll.print("Coba remove");
        System.out.println("IndexOf : " + sll.indexOf(80));
        System.out.println("Get : " + sll.get(3));
        sll.removeIndex(3);
        sll.print("Coba removeIndex");
        sll.add(70, 3);
        sll.print("Coba add");
    }
}