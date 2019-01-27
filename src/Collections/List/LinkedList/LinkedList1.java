package Collections.List.LinkedList;

public interface LinkedList1 {
    boolean isEmpty();
    void makeEmpty();
    void addFirst(Object newData);
    void addLast(Object newData);
    void insertBefore(Object newData, Object theData);
    void insertAfter(Object newData, Object theData);
    Object removeFirst();
    Object removeLast();
    Object removeData(Object theData);
    int size();
    int indexOf(Object theData);
    void add(Object theData, int index);
    Object removeIndex(int index);
    Object get(int index);
    void print();
}
