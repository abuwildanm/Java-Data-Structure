package Array1D;

public class Larik1 {
    private int size;
    private int []itemDt;
    
    public void buatLarik(int n){
        this.size = n;
        this.itemDt = new int[this.size];
    }
    
    public Larik1(int n){ buatLarik(n);}
    
    public int getSize(){ return this.size;}
    
    public Larik1(int []dt){
        buatLarik(dt.length);
        for (int i=0; i<dt.length; i++) isiItem(i,dt[i]);
    }
    
    public void isiItem(int id, int dt){
        this.itemDt[id] = dt;
    }
    
    public void cetak(String komentar){
        System.out.println(komentar);
        for(int i=0; i<this.size; i++){
            System.out.print(this.itemDt[i]+" ");
        }
        System.out.println();
    }
    
    public int findBesar(){
        int besar = this.itemDt[0];
        for (int i=1;i<this.size; i++){
            if (besar < this.itemDt[i]){
                besar = this.itemDt[i];
            }
        }
        return besar;
    }
    
    public int getPosisi(int dtCari){
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
    
    private int getPosMax(int id){
        int max = this.itemDt[id];
        int posMax = id;
        for (int i=id+1;i<size; i++){
            if (max <= this.itemDt[i]) {
                max = this.itemDt[i];
                posMax = i;
            }
        }
        return posMax;
    }
    
    private int getPosMin(int id){
        int min = this.itemDt[id];
        int posMin = id;
        for (int i=id+1;i<size; i++){
            if (min >= this.itemDt[i]) {
                min = this.itemDt[i];
                posMin = i;
            }
        }
        return posMin;
    }
    
    public int PencarianBiner(int dtCari, int awal, int akhir){
        int pos = -99;
        int tengah = (awal+akhir)/2;
        if(dtCari< this.itemDt[tengah])
            return PencarianBiner(dtCari, awal, tengah);
        else if (dtCari > this.itemDt[tengah])
            return PencarianBiner(dtCari,tengah+1,akhir);
        else if (dtCari == this.itemDt[tengah]) return tengah;
        else return pos;
    }
    
    public Larik1 copyLarik(int k, int n){
        Larik1 lHasil = null;
        if (n <= this.size-k){
            lHasil = new Larik1(n);
            int j = 0;
            for (int i=k; i<k+n; i++){
                lHasil.isiItem(j++, this.itemDt[i]);
            }
        }
        return lHasil;
    }
    
    public Larik1 SelectionSort(int pilihan){
        Larik1 lsort = copyLarik(0,size);
        for (int i=0; i<lsort.getSize();i++){
            int posData;
            if (pilihan == 0) posData = lsort.getPosMin(i);
            else posData = lsort.getPosMax(i);
            
            int dt1 = lsort.itemDt[i];
            int dt2 = lsort.itemDt[posData];
            
            lsort.itemDt[i] = dt2;
            lsort.itemDt[posData] = dt1;
        }
        return lsort;
    }
    
    public Larik1 BubbleSort(int pilihan) {
        Larik1 lsort = copyLarik(0, size);
        int tmp;
        for (int i = 0; i < lsort.size; i++) {
            for (int j = 0; j < lsort.size - 1; j++) {
                if (pilihan == 0) { // urutkan data dari kecil ke besar
                    if (lsort.itemDt[j] > lsort.itemDt[j+1]) {
                        tmp = lsort.itemDt[j];
                        lsort.itemDt[j] = lsort.itemDt[j+1];
                        lsort.itemDt[j+1] = tmp;
                    }
                }
                else { // urutkan data dari besar ke kecil
                    if (lsort.itemDt[j] < lsort.itemDt[j+1]) {
                        tmp = lsort.itemDt[j];
                        lsort.itemDt[j] = lsort.itemDt[j+1];
                        lsort.itemDt[j+1] = tmp;
                    }
                }
            }
        }
        return lsort;
    }
    
    public int findPosKelipatan(int x0, int x1, int x2) {
        int pos = -1;
        for (int i = x1; i <= x2; i++) {
            if (itemDt[i] % x0 == 0) {
                System.out.print(i + " ");
            }
        }
        return pos;
    }
    
    public static void main (String[] args) {
        int []A = {2,34,5,7,10};
        Larik1 lA = new Larik1(A);
        
        lA.cetak("Sebelum");
        lA.SelectionSort(0).cetak("Sesudah di sort");
        lA.cetak("Sesudah");
//        int k = lA.PencarianBiner(34,0,5);
//        System.out.println(k);
        Larik1 lB = lA.SelectionSort(0);
        int p = lB.PencarianBiner(10,0,5);
        System.out.println(p);
        System.out.println("Indeks kelipatan");
        lA.findPosKelipatan(5, 0, 4);
        System.out.println("");
        lA.BubbleSort(0).cetak("Sesudah di sort BubbleSort");
    }
}