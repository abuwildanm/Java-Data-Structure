package Collections.List.LinkedList;

import java.util.*;

public class Linkedlist {

    public static void main(String[] args) {
        List <String> ll = new LinkedList();
        ll.add("Hilman"); ll.add("Wildan");
//        ll.removeAll(ll);
        
        ll.set(1, "Tika"); //==> mengubah element pada indeks tertentu
        
//        Iterator itr = ll.iterator(); //==> pake ini bisa
        Iterator <String> itr = ll.iterator(); //==> pake ini juga bisa
        if (itr.hasNext()) {
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
        } else {
            System.out.println("List kosong bos");
        }
        
        System.out.println(ll.get(0)); //==> mengambil element pada indeks tertentu
    }  
}

//Jika untuk algoritme pencarian (search), juga minim add and remove ==> ArrayList much better
//Jika untuk algoritme add and remove, juga minim search ==> LinkedList more powerful
