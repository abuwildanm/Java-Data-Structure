package Collections.List.LinkedList;

public class Latihan_SLL {

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        
        sll.addFirst(100);
        sll.addLast(200);
        sll.addLast(300);
        sll.addLast(400);
        sll.print();
        System.out.println("");
        
        sll.addLast(500);
        sll.addFirst(50);
        sll.insertAfter(250, 200);
        sll.print();
        System.out.println("");
        
        sll.removeFirst();
        sll.removeLast();
        sll.print();
        System.out.println("");
    }
    
}
