package Collections.List.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Arraylist {

    public static void main(String[] args) {
        ArrayList al = new ArrayList(); //non-generic (tipe datanya tak disebutkan)
        ArrayList <String> al2 = new ArrayList(); //generic (tipe datanya disebutkan)
        
        //cara nambah elemen (add)
        al2.add("Hilman");
        al2.add("Wildan");
        al2.add("Tika");
        al2.add(1, "Sisipan");
        
        //cara nambah elemen(addAll)
        String[] daftarNama = {"Duki", "Radit", "Nisa"};
//        al2.addAll(Arrays.asList("Duki", "Radit", "Nisa"));
        al2.addAll(Arrays.asList(daftarNama)); //==> di dalam aslist harus berupa objek bukan primitif
        
        //cara hapus elemen
//        al2.remove("Nisa"); //hapus sebagian
//        al2.removeAll(al2); //hapus semua
        
        for (String nama : al2) { //cara print pake foreach
            System.out.println(nama);
        }
        System.out.println("");
        
        Iterator it = al2.iterator();
        while (it.hasNext()) { //cara print pake iterator, hasNext = selama ada isinya
            System.out.println(it.next());
        }
    }
}

//Jika untuk algoritme pencarian (search), juga minim add and remove ==> ArrayList much better
//Jika untuk algoritme add and remove, juga minim search ==> LinkedList more powerful

//Pada interface list, jika ada data kembar akan tetap ditampilkan semuanya
//Pada interface set, jika ada data kembar akan ditampilkan satu saja
