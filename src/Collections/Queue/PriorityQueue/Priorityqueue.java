package Collections.Queue.PriorityQueue;

import java.util.*;

public class Priorityqueue {

    public static void main(String[] args) {
        PriorityQueue <String> nama = new PriorityQueue();
        nama.add("Hilman"); nama.add("Endy"); nama.add("Tiqa");
        
        if (nama.contains("koko")) {
            System.out.println("Disini ada Koko...");
        }
        System.out.println("");
        
//        System.out.println("Hasil dari peek : " + nama.peek()); //peek = ambil data pertama tanpa remove
        System.out.println("Hasil dari poll : " + nama.poll()); //poll = ambil data pertama dengan remove
        System.out.println("");
        
        System.out.println("=== Antrian sekarang : ===");
        Iterator <String> itr = nama.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

//Pada queue tampilannya urut sesuai abjad

//Pada list kita bisa menyisipkan data
//Pada queue kita tak bisa menyisipkan data (Algoritmenya FIFO)