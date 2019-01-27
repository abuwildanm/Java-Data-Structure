package TriwizardGame;

public class Stack<T> {
    public DoublyLinkedList<T> list = new DoublyLinkedList<T>();

    public void push(T data) {
        list.addLast(data);
    }

    public T pop() {
        try {
            T x = list.getLast();
            list.removeLast();
            return x;
        } catch (NoNodeException ex) {
            return null;
        }
    }

    public T top() {
        try {
            T x = list.getLast();
            return x;
        } catch (NoNodeException ex) {
            return null;
        }
    }

    public T get(int index) {
        try {
            return this.list.get(index);
        } catch (IndexOutOfBoundsException | NoNodeException ex) {
            return null;
        }
    }

    public T get(T data) {
        try {
            return this.list.get(data);
        } catch (NoNodeException ex) {
            return null;
        }
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void makeEmpty(){
        list.makeEmpty();
    }

    public int getSize() {
        return list.getSize();
    }
    
    @Override
    public String toString() {
        return list.toString();
    }
}