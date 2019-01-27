package Sorting;

public class QuickSorter {
    
    public static void QuickSorter(int array[], int lower, int higher) {
        int l = lower, h = higher;
        int temp;
        int middle = array[(lower + higher) / 2];
        while (l <= h) { 
            while (array[l] < middle) {
                l++;
            }
            while (array[h] > middle) {
                h--;
            }
            if (l <= h) { 
                temp = array[l];
                array[l] = array[h];
                array[h] = temp;
                l++;
                h--;
            }
        }
        if (lower < l) {
            QuickSorter(array, lower, h);
        }
        if (h < higher) {
            QuickSorter(array, l, higher);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=============================");
        System.out.println("\tProgram QuickSort");
        int c = 0, k;
        int array[] = {11,2, 13, 10, 18, 96, 7};
        System.out.println("=============================");
        System.out.println("Sebelum tersortir:");
        for (k = 0; k < array.length; k++) {
            System.out.print(array[k] + " ");
        }System.out.println("");
        QuickSorter(array, 0, array.length - 1);
        System.out.println("=============================");
        System.out.println("Sesudah disortir:");
        for (k = 0; k < array.length; k++) {
            System.out.print(array[k] + " ");
        }System.out.println("");
        System.out.println("=============================");
    }
}


