package Collections.List.Stack;

public class StackArray {
    private Object[] data;
    private int top;
    
    public StackArray(int n) {
        this.top = -1;
        this.data = new Object[n];
    }
    
    public boolean isEmpty() {
        return (top == -1) ? true : false;
    }
    
    public boolean isFull() {
        return (top >= data.length - 1) ? true : false;
    }
    
    public void print() {
        for (int i = top; i >= 0; i--) {
            if (data[i] != null) {
                System.out.println(data[i]);
            }
        }
        System.out.println("----------");
    }
    
    public void push(Object newData) {
        if (!isFull()) {
            data[++top] = newData;
        }
        else {
            arrayDoubling();
            data[++top] = newData;
        }
    }
    
    public Object pop() {
        return (!isEmpty()) ? data[top--] : null;
    }
    
    public void arrayDoubling() {
        Object[] oldArray = data;
        data = new Object[oldArray.length*2];
        for (int i = 0; i < oldArray.length; i++) {
            data[i] = oldArray[i];
        }
    }
    
    public static void main(String[] args) {
        StackArray stack = new StackArray(2);
        
        System.out.println("Data awal");
        stack.push(20);
        stack.push(10);
        stack.push(56);
        stack.print();
        System.out.println("");
        stack.pop();
        System.out.println("Setelah pop data");
        stack.print();
        stack.push(-99);
        System.out.println("Setelah push data");
        stack.print();
    }
    
}
