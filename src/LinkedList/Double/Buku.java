package LinkedList.Double;

public class Buku {
    private String kategori, judul;
    private double hargaSewa, hargaDenda; private short id;

    public Buku(short id, String kategori, String judul, double hargaSewa, double hargaDenda) {
        this.id = id;
        this.kategori = kategori;
        this.judul = judul;
        this.hargaSewa = hargaSewa;
        this.hargaDenda = hargaDenda;
    }

    public short getId() { return id; }
    public double getHargaSewa() { return hargaSewa; }

    @Override
    public String toString() {
        return "No. ID      = " + id +
               "\nKategori    = " + kategori + 
               "\nJudul       = " + judul + 
               "\nHargaSewa   = " + hargaSewa + 
               "\nHargaDenda  = " + hargaDenda;
    }
}