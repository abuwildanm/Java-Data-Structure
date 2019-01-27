package Collections.List.Stack;

import Collections.List.LinkedList.*;

public class StackSLL implements Stack1 {

    SinglyNode top;
    SingleLinkedList sll = new SingleLinkedList();
    
    public StackSLL() {
        top = sll.head = sll.tail = null;
    }

    @Override
    public boolean isEmpty() {
        return (top == null);
    }

    @Override
    public void makeEmpty() {
        top = sll.head = sll.tail = null;
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
        
        Object removedData = sll.removeFirst();
        top = sll.head;
        return removedData;
    }
    
    public Object popAll() {
        if (isEmpty()) return null;
        
        this.pop();
        return popAll();
    }

    @Override
    public void push(Object data) {
        sll.addFirst(data);
        top = sll.head;
    }
    
    @Override
    public int size() {
        return sll.size();
    }
    
    public StackSLL clone() {
        StackSLL temp = new StackSLL();
        SinglyNode p = this.sll.head;
        while (p != null) {
            temp.sll.addLast(p.data);
            p = p.next;
        }
        return temp;
    }
    
    @Override
    public void print() {
        SinglyNode p = sll.head;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
        System.out.println("-----");
    }
    
    public void print(String kom) {
        System.out.println(kom);
        SinglyNode p = sll.head;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
        System.out.println("-----");
    }
    
    public static void main(String[] args) {
        StackSLL stack = new StackSLL();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.print("Stack Awal");
        stack.pop();
        stack.print("Setelah di pop");
        StackSLL stack1 = stack.clone();
        stack1.print("Isi Stack1");
        stack1.push(40);
        stack1.print("Coba push Stack1");
        stack.print("Isi Stack");
//        stack1.popAll();
//        stack1.print("Coba popAll");
        
        stack.makeEmpty();
        stack.print("Setelah make empty");
    }
}
