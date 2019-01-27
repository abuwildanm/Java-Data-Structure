package LinkedList.Single;

public class Buku {
    private String kategori, judul;
    private double hargaSewa, hargaDenda;

    public Buku() {
    }

    public Buku(String kategori, String judul, double hargaSewa, double hargaDenda) {
        this.kategori = kategori;
        this.judul = judul;
        this.hargaSewa = hargaSewa;
        this.hargaDenda = hargaDenda;
    }
    public String getKategori() { return kategori; }
    public String getJudul() { return judul; }
    public double getHargaSewa() { return hargaSewa; }
    public double getHargaDenda() { return hargaDenda; }

    @Override
    public String toString() {
        return "Buku {" + "kategori = " + kategori + ", judul = " + judul + ", hargaSewa = " + hargaSewa + ", hargaDenda = " + hargaDenda + '}';
    }
}