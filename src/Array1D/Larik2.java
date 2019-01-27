package Array1D;

public class Larik2 {
    private int size;
    private double []itemDt;
    
    public Larik2(double []A){
        this.size = A.length;
        this.itemDt = new double[this.size];
        for (int i=0; i<this.size; i++){
            this.itemDt[i] = A[i];
        }
    }
    
    public int getSize(){ return this.size; }
    
    public double getItem(int i){ return this.itemDt[i]; }
    
    public static Larik2 sambung(Larik2 l1, Larik2 l2){
        int sizeBaru = l1.size + l2.size; int j = 0;
        double[] arrayBaru = new double[sizeBaru];
        for (int i = 0; i < l1.size; i++) {
            arrayBaru[i] = l1.itemDt[i];
        }
        for (int i = l1.size; i < arrayBaru.length; i++) {
            arrayBaru[i] = l2.itemDt[j];
            j++;
        }
        Larik2 baru = new Larik2(arrayBaru);
        return baru;
    }
    
    public void isiItem(int id, double dt){
        this.itemDt[id] = dt;
    }
    
    public void cetak(String komentar){
        System.out.println(komentar);
        for(int i=0; i<this.size; i++){
            System.out.printf("%.2f ",this.itemDt[i]);
        }
        System.out.println();
    }
    
    public double findBesar(){
        double besar = this.itemDt[0];
        for (int i=1;i<this.size; i++){
            if (besar < this.itemDt[i]){
                besar = this.itemDt[i];
            }
        }
        return besar;
    }
    
    public int getPosisi(double dtCari){
        int pos = -99;
        boolean ketemu = false;
        int i=0;
        while (!ketemu && i<this.size){
            if (dtCari == this.itemDt[i]){
                ketemu = true;
                pos = i;
            }
            i++;
        }
        return pos;
    }
    
    public static Larik2 copyLarik(int k, int n, Larik2 l){
        double[] arrayBaru = new double[n];
        System.arraycopy(l.itemDt, k, arrayBaru, 0, n);
        Larik2 baru = new Larik2(arrayBaru);
        return baru;
    }
    
    public int getPosBesar(int awal, int akhir){
        int posBesar = -1;
        double itemBesar;
        if (awal <= akhir){
            posBesar = awal;
            itemBesar = this.getItem(awal);
            for (int i=awal+1; i<akhir; i++){
                double nilaiItem = this.getItem(i);
                if (itemBesar < nilaiItem){
                    itemBesar = nilaiItem;
                    posBesar = i;
                }
            }
        }
        return posBesar;
    }
    
    public int getPosKecil(int awal, int akhir){
        int posKecil = -1;
        double itemKecil;
        if (awal <= akhir){
            posKecil = awal;
            itemKecil = this.getItem(awal);
            for (int i = awal+1; i < akhir; i++){
                double nilaiItem = this.getItem(i);
                if (itemKecil > nilaiItem){
                    itemKecil = nilaiItem;
                    posKecil = i;
                }
            }
        }
        return posKecil;
    }
    
    public static Larik2 SelectionSort(Larik2 lAsal, int status){
        int n = lAsal.getSize();
        Larik2 lhasil = Larik2.copyLarik(0, n, lAsal);
        if (status == 0){ // urutkan data dari kecil ke besar
            for (int i=0; i<n; i++){
                int posKecil = lhasil.getPosKecil(i, n);
                double itemKecil = lhasil.getItem(posKecil);
                double itemI = lhasil.getItem(i);
                lhasil.isiItem(i, itemKecil);
                lhasil.isiItem(posKecil, itemI);
            }
        } else { // urutkan data dari besar ke kecil
            for (int i=0; i<n; i++){
                int posBesar = lhasil.getPosBesar(i, n);
                double itemBesar = lhasil.getItem(posBesar);
                double itemI = lhasil.getItem(i);
                lhasil.isiItem(i, itemBesar);
                lhasil.isiItem(posBesar, itemI);
            }
        }
        return lhasil;
    }
    
    public int[] FindPosPos(int i) {
        int temp[] = null;
        int size = 0;
        for(int j = 0; j < this.getSize(); j++){
            if(this.itemDt[j] == i){ size++; }
        }       
        temp = new int[size];
        size = 0;
        for(int j = 0; j < this.getSize(); j++){
            if(this.itemDt[j] == i){
                temp[size] = j;
                size++;
            }
        }
        return temp;
    }
    
    public static double LarikKaliLarik(Larik2 l1, Larik2 l2) {
        double hasil = 0;
        for (int i = 0; i < l1.size; i++) {
            hasil += (l1.itemDt[i] * l2.itemDt[i]);
        }
        return hasil;
    }
}