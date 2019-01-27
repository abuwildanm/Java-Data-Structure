package Collections.List.Stack;

import Collections.List.LinkedList.*;

public class StackDLL implements Stack1 {
    DoublyNode top;
    DoubleLinkedList dll = new DoubleLinkedList();
    
    public StackDLL() {
        top = dll.head = dll.tail = null;
    }

    @Override
    public boolean isEmpty() {
        return (top == null);
    }

    @Override
    public void makeEmpty() {
        top = dll.head = dll.tail = null;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        
        Object removedData = dll.removeLast();
        top = dll.tail;
        return removedData;
    }

    @Override
    public void push(Object data) {
        dll.addLast(data);
        top = dll.tail;
    }
    
    @Override
    public int size() {
        return dll.size();
    }
    
    public StackDLL clone() {
        StackDLL temp = new StackDLL();
        DoublyNode p = this.dll.head;
        while (p != null) {
            temp.dll.addLast(p.data);
            p = p.next;
        }
        return temp;
    }
    
    @Override
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
    
    public static void main(String[] args) {
        StackDLL stack = new StackDLL();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.print("Stack Awal");
        stack.pop();
        stack.print("Setelah di pop");
        stack.makeEmpty();
        stack.print("Make empty");
    }
}
