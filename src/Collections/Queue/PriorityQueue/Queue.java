package Collections.Queue.PriorityQueue;

public interface Queue {
    public boolean isEmpty();
    public void makeEmpty();
    public Object getFront();
    public Object dequeue();
    public void enqueue(Object data);
    public int size();
    public void print();
}
