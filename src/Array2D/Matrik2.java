package Array2D;

public class Matrik2 {
    private int nBaris, nKolom;
    private double [][]itemDt;
    
    public Matrik2(int nBrs, int nKlm){
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new double[nBaris][nKolom];
    }
    
    public Matrik2(double [][]A){
        this(A.length,A[0].length); // panggil contructor
        this.nBaris = A.length;
        this.nKolom = A[0].length;
        for (int i=0; i<nBaris; i++){
            for (int j=0; j<nKolom; j++){
                this.itemDt[i][j] = A[i][j];
            }
        }
    }
    
    public int getNBaris(){ return nBaris;}
    
    public int getNKolom(){ return nKolom;}
    
    public double getItem(int idB, int idK){ return this.itemDt[idB][idK]; }
    
    public void setItem(int idB, int idK, double dt){ this.itemDt[idB][idK] = dt; }
    
    public static Matrik2 tambah(Matrik2 A, Matrik2 B){
        Matrik2 temp = null;
        if ((A.nBaris == B.nBaris)&& (A.nKolom == B.nKolom)){
            temp = new Matrik2(A.nBaris, A.nKolom);
            for (int i = 0; i < temp.nBaris; i++) {
                for (int j = 0; j < temp.nKolom; j++) {
                    temp.setItem(i, j, A.itemDt[i][j] + B.itemDt[i][j]);
                }
            }
        }
        return temp;
    }
    
    public static Larik VektorKaliMatrik(Larik L, Matrik2 M){
        Larik lHasil = null;
        Larik lKolom = null;
        if (L.getSize() == M.getNBaris()){
            lHasil = new Larik(M.getNKolom());
            for (int i=0; i<M.getNKolom(); i++){
                lKolom = M.getKolom(i);
                double hasil = Larik.LarikKaliLarik(L, lKolom);
                System.out.println(hasil);
                lHasil.isiItem(i, hasil);
            }
        }
        return lHasil;
    }
    
    public double determinan() throws DeterminanException {
        double[][] M;
        int i, j, k, n = 0, p, q;
        
        if (this.nBaris != this.nKolom) {
            throw new DeterminanException("Bukan matriks persegi");
        }
        if (this.nBaris == 2)
            return itemDt[0][0] * itemDt[1][1] - itemDt[1][0] * itemDt[0][1];
        
        for (i = 0; i < this.nBaris; i++) {
            M = new double[this.nBaris - 1][this.nKolom - 1];
            for (j = 1, p = 0; j < this.nBaris; j++, p++) {
                for (k = 0, q = 0; k < this.nKolom; k++) {
                    if (k != i) {
                        M[p][q] = itemDt[j][k];
                        q++;
                    }
                }
            }
            n += itemDt[0][i] * new Matrik1(M).determinan() * (i % 2 == 0? 1 : -1);
        }
        
        return n;
    }
    
    public static Matrik2 tranpos(Matrik2 A){
        Matrik2 tmp = new Matrik2(A.nKolom, A.nBaris);
        for (int i = 0; i < tmp.getNBaris(); i++) {
            for (int j = 0; j < tmp.getNKolom(); j++) {
                tmp.setItem(i, j, A.itemDt[j][i]);
            }
        }
        return tmp;
    }
    
    public Larik getBaris(int idBaris){
        double[] temp = new double[this.nKolom];
        for (int i = 0; i < temp.length; i++) { temp[i] = this.itemDt[idBaris][i]; }
        return new Larik(temp);
    }
    
    public Larik getKolom(int idKolom){
        Larik l = new Larik(this.nBaris);
        for (int i=0; i<this.nBaris; i++){
            double itemKolom = this.getItem(i, idKolom);
            l.isiItem(i, itemKolom);
        }
        return l;
    }
    
    public void cetak(String kom){
        System.out.println(kom);
        for (int i=0; i<this.nBaris; i++){
            for (int j=0; j<this.nKolom; j++){
                System.out.printf("%.2f ",this.itemDt[i][j]);
            }
            System.out.println();
        }
    }
}