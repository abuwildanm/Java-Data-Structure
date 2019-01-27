package LinkedList.Circular;

public class Buku {
    private String kategori, judul;
    private double hargaSewa, hargaDenda;

    public Buku(String kategori, String judul, double hargaSewa, double hargaDenda) {
        this.kategori = kategori;
        this.judul = judul;
        this.hargaSewa = hargaSewa;
        this.hargaDenda = hargaDenda;
    }

    public double getHargaSewa() { return hargaSewa; }

    @Override
    public String toString() {
        return kategori + " " + judul + ", " + hargaSewa;
    }
}