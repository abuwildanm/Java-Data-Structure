package Collections.Set.HashSet;

import java.util.*;

public class Hashset {

    public static void main(String[] args) {
        HashSet <String> nama = new HashSet();
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