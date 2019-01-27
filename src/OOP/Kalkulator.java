package OOP;

import java.util.Scanner;

public class Kalkulator {
    Scanner masuk = new Scanner(System.in);
    private int angka1, angka2;
    
    public void Display() {
        System.out.println("=== Program Kalkulator ===");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pembagian");
        System.out.println("==========================");
        System.out.print("Masukkan pilihan : ");
        byte pilihan = masuk.nextByte();
        
        switch (pilihan) {
            case 1: 
                System.out.println("Masukkan bilangan : "); 
                System.out.println("Hasilnya : " + Penjumlahan(masuk.nextInt(), masuk.nextInt())); 
                break;
            case 2: 
                System.out.println("Masukkan bilangan : ");
                System.out.println("Hasilnya : " + Pengurangan(masuk.nextInt(), masuk.nextInt())); 
                break;
            case 3: 
                System.out.println("Masukkan bilangan : ");
                System.out.println("Hasilnya : " + Perkalian(masuk.nextInt(), masuk.nextInt())); 
                break;
            case 4: 
                System.out.println("Masukkan bilangan : ");
                System.out.println("Hasilnya : " + Pembagian(masuk.nextInt(), masuk.nextInt())); 
                break;
            default: 
                System.err.println("Input Salah !"); 
                break;
        }
    }
    
    public int Penjumlahan(int angka1, int angka2) { return angka1 + angka2; }
    public int Pengurangan(int angka1, int angka2) { return angka1 - angka2; }
    public int Perkalian(int angka1, int angka2) { return angka1 * angka2; }
    public int Pembagian(int angka1, int angka2) { return angka1 / angka2; }
}
