package Collections.Set.LinkedHashSet;

import java.util.*;

public class Linkedhashset {

    public static void main(String[] args) {
        LinkedHashSet <String> nama = new LinkedHashSet();
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