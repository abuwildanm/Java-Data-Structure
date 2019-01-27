package Array2D;

public class Matrik1 {
    private int nBaris, nKolom;
    private double [][]itemDt;
    
    public Matrik1(int nBrs, int nKlm){
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new double[nBaris][nKolom];
    }
    
    public Matrik1(double [][]dt){
        nBaris = dt.length;
        nKolom = dt[0].length;
        this.itemDt = new double[nBaris][nKolom];
        for(int i=0; i<nBaris; i++){
            for (int j=0; j<nKolom; j++){
                this.setItem(i, j, dt[i][j]);
            }
        }
    }
    
    public int getNBaris(){ return nBaris;}
    
    public int getNKolom(){ return nKolom;}
    
    public double getItem(int idB, int idK){ return this.itemDt[idB][idK]; }
    
    public void setItem(int idB, int idK, double dt){ this.itemDt[idB][idK] = dt; }
    
    public Matrik1 tambah(Matrik1 x){
        Matrik1 y = null;
        if ((this.nBaris == x.getNBaris())&& (this.nKolom == x.getNKolom())){
            y = new Matrik1(x.getNBaris(),x.getNKolom());
            for (int i=0; i<this.nBaris; i++){
                for (int j=0; j<this.nKolom; j++){
                    y.setItem(i, j, this.itemDt[i][j]+x.getItem(i,j));
                }
            }
        }
        return y;
    }
    
    public void cetak(String kom){
        System.out.println(kom);
        for (int i=0; i<this.nBaris; i++){
            for (int j=0; j<this.nKolom; j++){
                System.out.print(this.itemDt[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public double determinan() {
        double[][] M;
        int i, j, k, n = 0, p, q;
        
        if (this.nBaris != this.nKolom) return -999999999;
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
    
    public Matrik1 tranposeMatrik() {
        Matrik1 tmp = new Matrik1(this.nKolom, this.nBaris);
        for (int i = 0; i < tmp.getNBaris(); i++) {
            for (int j = 0; j < tmp.getNKolom(); j++) {
                tmp.setItem(i, j, this.itemDt[j][i]);
            }
        }
        return tmp;
    }
    
    public Matrik1 kali(Matrik1 m) {
        double hasil = 0;
        Matrik1 tmp = new Matrik1(this.nBaris, this.nKolom);
        if ((this.nBaris == m.nKolom) && (this.nKolom == m.nBaris)) {
            for (int i = 0; i < this.nKolom; i++) {
                for (int j = 0; j < this.nKolom; j++) {
                    for (int k = 0; k < this.nKolom; k++) {
                        hasil += this.itemDt[i][k] * m.itemDt[k][j];
                        tmp.setItem(i, j, hasil);
                    }
                    hasil = 0;
                }
            }
        }
        return tmp;
    }
    
    public Larik getKolom(int idK) {
        double[] temp = new double[this.nBaris];
        for (int i = 0; i < temp.length; i++) { temp[i] = this.itemDt[i][idK]; }
        return new Larik(temp);
    }
    
    public Larik getBaris(int idB) {
        double[] temp = new double[this.nKolom];
        for (int i = 0; i < temp.length; i++) { temp[i] = this.itemDt[idB][i]; }
        return new Larik(temp);
    }
    
    public static void main (String[] args) {
        // implementasi untuk ADT_Matrik
        Matrik1 A, B, C;
        double [][] X = {{1, 2, 3},{2, 14, 5},{16, 8, 13}};
        double [][] Y = {{10, 12, 0},{5, 1, 5},{3, 1, 10}};
        A = new Matrik1(X);
        B = new Matrik1(Y);
        A.cetak("Matrik A");
        B.cetak("Matrik B");
        C = A.tambah(B);
        C.cetak("Matrik C = A+B");
//        Larik lb,lk;
//        lb = D.getBaris(1);
//        lb.cetak("Larik baris ke-1");
//        lk = D.getKolom(1);
//        lk.cetak("Larik kolom ke-1");

        A.tranposeMatrik().cetak("Tanspose");
        A.kali(B).cetak("Perkalian");
        System.out.println("Determinan Matrik A : " + A.determinan());
        A.getKolom(1).cetak("Kolom");
        A.getBaris(1).cetak("Baris");
    }
}