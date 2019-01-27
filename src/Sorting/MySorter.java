package Sorting;

public class MySorter {
    
    public static void insertionSort(int array[]) {
        long start = System.nanoTime();
        for(int i = 1; i< array.length; i++) {
            int temp = array[i];
            int j = i;
            while(j > 0 && array[j-1] >= temp) { array[j] = array[j-1]; j--; }
            array[j] = temp;
        }
        System.out.print("Insertion Sort : ");
        for (int i = 0; i < array.length; i++) { System.out.print(array[i] + " "); }
        long finish = System.nanoTime();
        System.out.println("\nWaktu Komputasi : " + ((finish - start)) + " nanodetik\n");
    }
    
    private static void mergeSort(int array[], int l, int h) {
        int lower = l;
        int higher = h;
        if (lower >= higher) { return; }
        int between = (lower + higher) / 2;
        mergeSort(array, lower, between);
        mergeSort(array, between + 1, higher);
        int end = between;
        int start_high = between + 1;
        while ((l <= end) && (start_high <= higher)) {
            if (array[lower] < array[start_high]) { lower++; } 
            else {
                int Temp = array[start_high];
                for (int m = start_high - 1; m >= lower; m--) { array[m + 1] = array[m]; }
                array[lower] = Temp;
                lower++;
                end++;
                start_high++;
            }
        }
    }
    
    public static void mergeSort(int array[]) {
        long start = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        System.out.print("Merge Sort     : ");
        for (int i = 0; i < array.length; i++) { System.out.print(array[i] + " "); }
        long finish = System.nanoTime();
        System.out.println("\nWaktu Komputasi : " + ((finish - start)) + " nanodetik\n");
    }
    
    private static void quickSort(int array[], int lower, int higher) {
        int l = lower, h = higher;
        int temp;
        int middle = array[(lower + higher) / 2];
        while (l <= h) { 
            while (array[l] < middle) { l++; }
            while (array[h] > middle) { h--; }
            if (l <= h) { 
                temp = array[l];
                array[l] = array[h];
                array[h] = temp;
                l++;
                h--;
            }
        }
        if (lower < l) { quickSort(array, lower, h); }
        if (h < higher) { quickSort(array, l, higher); }
    }
    
    public static void quickSort(int array[]) {
        long start = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        System.out.print("Quick Sort     : ");
        for (int i = 0; i < array.length; i++) { System.out.print(array[i] + " "); }
        long finish = System.nanoTime();
        System.out.println("\nWaktu Komputasi : " + ((finish - start)) + " nanodetik\n");
    }
    
    public static void main(String[] args) {
        int array[] = {29, 27, 10, 8, 76, 21};
        System.out.print("Before Sorting : ");
        for (int i = 0; i < array.length; i++) { System.out.print(array[i] + " "); }
        System.out.println("\n");
        insertionSort(array);
        mergeSort(array);
        quickSort(array);
        System.out.println("Kesimpulan : \n" + "Dari percobaan tersebut yang memiliki "
                + "\nwaktu komputasi paling cepat adalah \nmetode Quick Sort");
    }
}