package OOP;

public class Buku {
    private String judul, tipe;
    private int biayaSewa, denda;

    public Buku(String judul, String tipe, int biayaSewa, int denda) {
        this.judul = judul;
        this.tipe = tipe;
        this.biayaSewa = biayaSewa;
        this.denda = denda;
    }

    public String getJudul() { return judul; }
    public String getTipe() { return tipe; }
    public int getBiayaSewa(int hari) { return biayaSewa * hari; }
    public int getDenda(int hari) { return denda * hari; }
}
