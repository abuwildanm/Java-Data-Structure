package Collections.Map.TreeMap;

import java.util.*;

public class Treemap {

    public static void main(String[] args) {
        Map <Integer, String> data = new TreeMap();
        
        data.put(300, "Tika");
        data.put(100, "Hilman");
        data.put(400, "Koko");
        data.put(200, "Endy");
        
        //cara cetak
        for (Map.Entry nama : data.entrySet()) {
            System.out.println("Key : " + nama.getKey() + " Value : " + nama.getValue());
        }
    }
}

//HashMap = tampilannya acak
//LinkedHashMap = tampilannya urut sesuai insertnya
//TreeMap = tampilannya urut sesuai key nya

//Pada map jika ada data sama, akan ditampilkan satu saja