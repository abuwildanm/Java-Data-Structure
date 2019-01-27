package TriwizardGame;

public class DoublyLinkedList <T> {
    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    public DoublyLinkedList() {
        this.makeEmpty();
    }

    public void makeEmpty() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addFirst(T data) {
        DoublyNode newNode = new DoublyNode(data);
        if(this.isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        DoublyNode newNode = new DoublyNode(data);
        if(this.isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        size++;
    }

    public void insertAfter(T key, T data) throws NoNodeException {
        if(isEmpty()) {
            throw new NoNodeException();
        } else {
            DoublyNode it = head;
            DoublyNode newNode = new DoublyNode(data);
            while(it != null) {
                if (it.data.equals(key)) {
                    if (it == this.tail){
                        addLast(data);
                    } else {
                        newNode.next = it.next;
                        it.next.prev = newNode;
                        newNode.prev = it;
                        it.next = newNode;
                    }
                    size++;
                    return;
                }
                it = it.next;
            }
            throw new NoNodeException();
        }
    }

    public void insertBefore(T key, T data) throws NoNodeException {
        if (isEmpty()) {
            throw new NoNodeException();
        } else {
            DoublyNode it = head;
            DoublyNode newNode = new DoublyNode(data);
            while (it != null) {
                if (it.data.equals(key)) {
                    if (it == this.head) {
                        addFirst(data);
                    } else {
                        newNode.next = it;
                        newNode.prev = it.prev;
                        it.prev.next = newNode;
                        it.prev = newNode;
                    }
                    size++;
                    return;
                }
                it = it.next;
            }
            throw new NoNodeException();
        }
    }
    public void removeFirst() throws NoNodeException {
        if(isEmpty()){
            throw new NoNodeException();
        } else {
            if (this.tail.prev == null) {
                this.makeEmpty();
                return;
            }
            
            this.head.next.prev = null;
            this.head = this.head.next;
            size--;
        }
    }
    public void removeLast() throws NoNodeException {
        if (isEmpty()){
            throw new NoNodeException();
        } else {
            if (this.tail.prev == null) {
                this.makeEmpty();
                return;
            }
            
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
            size--;
        }
    }
    public void remove(T data) throws NoNodeException {
        if (this.isEmpty()) {
            throw new NoNodeException();
        } else {
            if (this.head.data.equals(data)){
                this.removeFirst();
                return;
            } else {
                DoublyNode it = this.head;
                while(it != null) {
                    if (it.data.equals(data)) {
                        if(it == this.tail) {
                            this.removeLast();
                        } else {
                            it.prev.next = it.next;
                            it.next.prev = it.prev;
                        }
                        size--;
                        return;
                    }
                    it = it.next;
                }
                throw new NoNodeException();

            }
        }
    }

    public T getFirst() throws NoNodeException {
        if (isEmpty())
            throw new NoNodeException();
        else {
            return (T) this.head.data;
        }
    }

    public T getLast() throws NoNodeException {
        if (isEmpty())
            throw new NoNodeException();
        else {
            return (T) this.tail.data;
        }
    }

    public T get(int index) throws NoNodeException, IndexOutOfBoundsException {
        if (isEmpty())
            throw new NoNodeException();
        else {
            if(index < 0 || index >= size)
                throw new IndexOutOfBoundsException();
            else {
                int count = 0;
                DoublyNode it = this.head;
                while(it != null) {
                    if (index == count)
                        return (T) it.data;

                    count++;
                    it = it.next;
                }
                throw new NoNodeException();
            }
        }
    }

    public T get(T data) throws NoNodeException {
        if (isEmpty())
            throw new NoNodeException();
        else {
            DoublyNode it = this.head;
            while(it != null) {
                if (it.data.equals(data)) {
                    return (T) it.data;
                }

                it = it.next;
            }
            throw new NoNodeException();
        }
    }

    @Override
    public String toString() {
        String output = "";
        if (!isEmpty()) {
            DoublyNode it = head;
            while (it != null) {
                output += it.data + "  ";
                it = it.next;
            }
        }
        return output;
    }
    
    public int getSize() {
        return size;
    }
    
    public DoublyNode getHead() { return head; }

    public static void main(String[] args) {
        DoublyLinkedList d = new DoublyLinkedList();
        d.addLast(3);
        d.addLast(4);
        d.addLast(5);
        d.addLast(6);
        d.addLast(7);
        d.addFirst(2);
        d.addFirst(1);
        System.out.println(d);
        try {
            d.insertAfter(6, 17);
            d.insertBefore(4, 13);
            d.insertBefore(1, 1230);
            d.insertAfter(7, 150);
            d.insertBefore(0, 133);
            d.insertAfter(123, 1507);
        } catch (NoNodeException ex) {
            System.out.println("Error: Node doesn't exist");
        }
        System.out.println(d);

        try {
            d.removeFirst();
            d.removeLast();
        } catch (NoNodeException ex) {
            System.out.println("Error: Node doesn't exist");
        }
        System.out.println(d);

        try {
            d.remove(1);
            d.remove(7);
            d.remove(4);
            d.remove(400);
        } catch (NoNodeException ex) {
            System.out.println("Error: Node doesn't exist");
        }
        System.out.println(d);
    }
}
