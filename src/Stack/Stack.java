package Stack;

public class Stack {
    private int size;
    private int top;
    private Object []data;
    
    public Stack(int n){
        top = -1;
        size = n;
        data = new Object[size];
    }
    public boolean isPalindrome(){ return true; }
    public boolean isFull(){ return top == (size-1); }
    public boolean isEmpty(){ return top == -1; }
    public void push(Object dt){ if (!isFull()){ data[++top] = dt; } }
    public Object pop(){
        Object hasil = -999;
        if (!isEmpty()){ hasil = data[top--]; }
        return hasil;
    }
}