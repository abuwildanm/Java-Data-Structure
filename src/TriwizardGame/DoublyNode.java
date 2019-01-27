package TriwizardGame;

public class DoublyNode <T> {
    T data;
    DoublyNode next;
    DoublyNode prev;

    public DoublyNode() { }

    public DoublyNode(T data) {
        this.data = data;
    }

    public DoublyNode(DoublyNode prev, DoublyNode next, T data) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
