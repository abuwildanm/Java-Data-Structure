package Collections.Queue.PriorityQueue;

import Collections.List.LinkedList.*;

public class QueueSLL implements Queue {
    SingleLinkedList sll = new SingleLinkedList();

    public QueueSLL() {
        sll.head = sll.tail = null;
    }

    @Override
    public boolean isEmpty() {
        return (sll.head == null && sll.tail == null);
    }

    @Override
    public void makeEmpty() {
        sll.head = sll.tail = null;
    }

    @Override
    public Object getFront() {
        return sll.head.data;
    }

    @Override
    public Object dequeue() {
        return sll.removeFirst();
    }

    @Override
    public void enqueue(Object data) {
        sll.addLast(data);
    }
    
    @Override
    public int size() {
        return sll.size();
    }

    @Override
    public void print() {
        SinglyNode p = sll.head;
        while (p != null) {
            System.out.println(p.data + " <- ");
            p = p.next;
        }
        System.out.println("");
    }
    
    public void print(String kom) {
        System.out.println(kom);
        SinglyNode p = sll.head;
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
        System.out.println(queue.size());
        queue.makeEmpty();
        queue.print("Make empty");
    }
}
