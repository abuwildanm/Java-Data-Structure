package Sorting;

import java.util.*;

public class LLBubbleSorter {
    
    int[] L = {54, 94, 32, 2, 10, 10};
    List <Integer> list = new LinkedList();
    
    LLBubbleSorter() { for (int i = 0; i < L.length; i++) { list.add(L[i]); } }
    
    void bubbleSort(String method) {
        if (list.isEmpty()) { for (int i = 0; i < L.length; i++) { list.add(L[i]); } }
        
        int i, j, Max = 6, temp;
        for (i = 0; i < Max - 1; i++) {
            for (j = Max - 1; j > i; j--) {
                if (method.equalsIgnoreCase("Ascending")) {
                    if (list.get(j - 1) > list.get(j)) {
                        temp = list.get(j);
                        list.set(j, list.get(j - 1));
                        list.set(j - 1, temp);
                    }
                } else if (method.equalsIgnoreCase("Descending")) {
                    if (list.get(j - 1) < list.get(j)) {
                        temp = list.get(j);
                        list.set(j, list.get(j - 1));
                        list.set(j - 1, temp);
                    }
                } else { System.err.println("Your method is not found!"); }
            }
        }
    }
    
    public static void main(String[] args) {
        LLBubbleSorter sorter = new LLBubbleSorter();
        System.out.println("Sebelum sorting  : " + sorter.list);
        sorter.bubbleSort("Ascending");
        System.out.println("Hasil Ascending  : " + sorter.list);
        sorter.list.removeAll(sorter.list);
        sorter.bubbleSort("Descending");
        System.out.println("Hasil Descending : " + sorter.list);
    }
}