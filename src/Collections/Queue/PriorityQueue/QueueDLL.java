package Collections.Queue.PriorityQueue;

import Collections.List.LinkedList.*;

public class QueueDLL implements Queue {
    DoubleLinkedList dll = new DoubleLinkedList();

    public QueueDLL() {
        dll.head = dll.tail = null;
    }

    @Override
    public boolean isEmpty() {
        return (dll.head == null && dll.tail == null);
    }

    @Override
    public void makeEmpty() {
        dll.head = dll.tail = null;
    }

    @Override
    public Object getFront() {
        return dll.head.data;
    }

    @Override
    public Object dequeue() {
        return dll.removeFirst();
    }

    @Override
    public void enqueue(Object data) {
        dll.addLast(data);
    }
    
    @Override
    public int size() {
        return dll.size();
    }

    @Override
    public void print() {
        DoublyNode p = dll.head;
        while (p != null) {
            System.out.println(p.data + " <- ");
            p = p.next;
        }
        System.out.println("");
    }
    
    public void print(String kom) {
        System.out.println(kom);
        DoublyNode p = dll.head;
        while (p != null) {
            System.out.print(p.data + " <- ");
            p = p.next;
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        QueueSLL queue = new QueueSLL();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.print("Queue Awal");
        queue.dequeue();
        queue.dequeue();
        queue.print("Setelah dequeue");
        System.out.println(queue.getFront());
        queue.makeEmpty();
        queue.print("Make empty");
    }
}
