package Collections.Queue.PriorityQueue;

public class QueueArray implements Queue {
    int front, rear, itemCount;
    Object queue[];

    public QueueArray(int n) {
        queue = new Object[n];
        itemCount = 0;
        front = 0;
        rear = -1;
    }
    
    @Override
    public boolean isEmpty() {
        return (itemCount == 0);
    }
    
    public boolean isFull() {
        return (itemCount == queue.length - 1);
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < queue.length; i++) {
            queue[i] = null;
        }
        itemCount = 0;
    }

    @Override
    public Object getFront() {
        return queue[front];
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) return null;
        else {
            Object temp = queue[front];
            for (int i = 0; i < itemCount; i++) {
                queue[i] = queue[i+1];
            }
            queue[itemCount--] = null;
            rear--;
            return temp;
        }
    }

    @Override
    public void enqueue(Object data) {
        if (isFull()) arrayDoubling();
        itemCount++;
        queue[++rear] = data;
    }
    
    @Override
    public int size() {
        return itemCount;
    }
    
    public void arrayDoubling() {
        Object oldArray[] = queue;
        queue = new Object[oldArray.length*2];
        for (int i = 0; i < oldArray.length; i++) {
            queue[i] = oldArray[i];
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] != null) {
                System.out.print(queue[i] + " | ");
            }
        }
        System.out.println("");
    }
    
    public void print(String kom) {
        System.out.println(kom);
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] != null) {
                System.out.print(queue[i] + " | ");
            }
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(3);
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
