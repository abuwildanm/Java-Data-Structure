package Sorting;

public class WaktuKomputasi {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	long waktuMulai;
	long waktuSelesai;
 
	waktuMulai = System.currentTimeMillis();
 
	double panjang, lebar, sisiMiring;  	// sisi segitiga siku-siku
	panjang = 18.0;
	lebar = 27;
 
	sisiMiring = Math.sqrt(panjang*panjang + lebar*lebar);
	System.out.print("Segitiga siku-siku dengan panjang 18 dan lebar 27 memiliki sisi miring ");
	System.out.println(sisiMiring);
 
	System.out.println("\nSecara matematis, sin(x)*sin(x) + " + "cos(x)*cos(x) - 1 = 0");
	System.out.println("Mari kita cek untuk x = 1 :");
	System.out.print("sin(1)*sin(1) + cos(1)*cos(1) - 1 = ");
	System.out.println( Math.sin(1)*Math.sin(1) + Math.cos(1)*Math.cos(1) - 1 );
	System.out.println("(Mungkin akan ada kesalahan desimal dalam " + "perhitungan bilangan real!)");
 
	System.out.print("\nIni adalah bilangan acak : ");
        System.out.println(Math.random());
 
	waktuSelesai = System.currentTimeMillis();
	System.out.print("\nTotal waktu perhitungan : ");
        System.out.print((waktuSelesai - waktuMulai)/1000.0);
        System.out.println(" detik");
 
    }
}