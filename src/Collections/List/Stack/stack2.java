package Collections.List.Stack;

import java.util.*;

public class stack2 {

    public static void main(String[] args) {
        Stack <String> nama = new Stack();
        nama.push("Hilman"); nama.push("Endy"); nama.push("Koko"); nama.push("Tiqa");
        
//        System.out.println("Hasil dari peek : " + nama.peek()); //peek = ambil data terakhir tanpa remove
        System.out.println("Hasil dari pop : " + nama.pop()); //pop = ambil data terakhir dengan remove
        
        Iterator <String> itr = nama.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

//Algoritme stack => LIFO
//Pada stack tampilannya urut berdasarkan insertnya