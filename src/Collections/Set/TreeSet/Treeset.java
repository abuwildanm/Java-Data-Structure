package Collections.Set.TreeSet;

import java.util.*;

public class Treeset {

    public static void main(String[] args) {
        TreeSet <String> nama = new TreeSet();
        nama.add("Hilman"); nama.add("Endy"); nama.add("Tiqa");
        
        Iterator <String> itr = nama.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

//Interface set tak memiliki nomor indeks
//Hashset ==> Tampilannya tidak urut
//LinkedHashSet ==> Tampilannya urut berdasarkan insertnya
//TreeSet ==> Tampilannya urut berdasarkan alphabet (performa paling lambat karena dia harus sorting datanya dulu)

