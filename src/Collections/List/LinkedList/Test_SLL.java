package Collections.List.LinkedList;

public class Test_SLL {

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.addFirst(67);
        sll.addFirst(90);
        sll.addLast(100);
        sll.addLast(25);
        sll.print();
        System.out.println("");
        System.out.println("Size : " + sll.size());
        sll.removeFirst();
        sll.removeLast();
        System.out.println("");
        sll.print();
    }
    
}
