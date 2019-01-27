package Sorting;

public class MergeSorter {
    
    public static void MergeSorter(int array[], int l, int h) {
        int lower = l;
        int higher = h;
        if (lower >= higher) {
            return;
        }
        int between = (lower + higher) / 2;
        MergeSorter(array, lower, between);
        MergeSorter(array, between + 1, higher);
        int end = between;
        int start_high = between + 1;
        while ((l <= end) && (start_high <= higher)) {
            if (array[lower] < array[start_high]) { //ganti ini kalo mau descending
                lower++;
            } else {
                int Temp = array[start_high];
                for (int m = start_high - 1; m >= lower; m--) {
                    array[m + 1] = array[m];
                }
                array[lower] = Temp;
                lower++;
                end++;
                start_high++;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("===========================");
        System.out.println("\t Program MergeSort");
        int in;
        int[] array = {10, 11 ,2, 9, 18, 96, 13};
        System.out.println("===========================");
        System.out.println("Sebelum tersortir:");
        for (in = 0; in < array.length; in++) {
            System.out.print(array[in] + " ");
        }
        System.out.println("");
        MergeSorter(array, 0, array.length - 1);
        System.out.println("==========================");
        System.out.println("Sesudah disortir:");
        for (in = 0; in < array.length; in++) {
            System.out.print(array[in] + " ");
        }
        System.out.println("");
        System.out.println("=========================");
    }
}
