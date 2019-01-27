package Collections.Queue.Deque;

import java.util.*;

public class deque {

    public static void main(String[] args) {
        Deque <String> nama = new ArrayDeque();
        nama.push("Hilman"); nama.push("Endy"); nama.push("Koko"); nama.push("Tiqa");
        
//        System.out.println("Hasil dari peek : " + nama.peek()); //peek = ambil data tanpa remove
//        System.out.println("Hasil dari pop : " + nama.pop()); //pop = ambil data dengan remove
//        System.out.println("Hasil dari poll : " + nama.poll()); //poll = ambil data dengan remove
        
//        System.out.println("Hasil dari pollFirst : " + nama.pollFirst()); //pollFirst = ambil data dengan remove
        System.out.println("Hasil dari pollLast : " + nama.pollLast()); //pollLast = ambil data dengan remove
        
        Iterator <String> itr = nama.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

//Deque bisa lebih cepat daripada class Stack jika kita pakai sebagai stack
//Deque bisa lebih cepat daripada class LinkedList jika kita pakai sebagai queue

//Deque ini semacam class gabungan queue + stack
//Deque itu interface yang salah satu class turunannya adalah ArrayDeque

//Deque tampilannya urut dari yang paling terakhir masuk