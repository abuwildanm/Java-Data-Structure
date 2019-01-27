package Array1D;

public class AppPr1 {
    public static void main(String[] args) {
        // implementasi untuk ADT_Larik
        double []A = {3,4,1,10,5,2,10,20,16};
        double []B = {4,3,1,11,7};
        Larik2 L1 = new Larik2(A);
        Larik2 L2 = new Larik2(B);
        L1.cetak("Isi Larik L1");
        L2.cetak("Isi Larik L2");
        Larik2 L3 = Larik2.sambung(L1, L2);
        L3.cetak("L3 = gabungan dari L1 dan L2");
        Larik2 L4 = Larik2.copyLarik(0, L1.getSize(), L1);
        L1.cetak("Isi Larik L1");
        L4.cetak("L4 Copy dari L1");
        Larik2 L5 = Larik2.SelectionSort(L1, 0);
        L5.cetak("L5 Hasil pengurutan dari L1 kecil -> besar");
        Larik2 L6 = Larik2.SelectionSort(L1, 1);
        L6.cetak("L6 Hasil pengurutan dari L1 besar -> kecil");
        L1.cetak("Isi Larik L1");
        int []posisi = L1.FindPosPos(10);
        double hasil = Larik2.LarikKaliLarik(L1, L4);
        System.out.printf("HASIL KALI Larik L1*L4 = %.3f\n",hasil);
    }
}