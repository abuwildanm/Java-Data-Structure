package OOP;

public class Aplikasi {

    public static void main(String[] args) {
        Buku doraemon = new Buku("Doraemon", "Komik", 1000, 100);
        
        System.out.println("Peminjaman " + doraemon.getTipe() + " " + doraemon.getJudul() + " selama 4 hari akan menghasilkan biaya sewa \nsebesar Rp" + doraemon.getBiayaSewa(4) + ",00. Apabila terlambat 2 hari, maka peminjam wajib membayar \ndenda sebesar Rp" + doraemon.getDenda(2) + ",00.");
        System.out.println("");
        
        Buku matematika = new Buku("Matematika", "Buku Pelajaran", 2000, 200);
        
        System.out.println("Peminjaman " + matematika.getTipe() + " " + matematika.getJudul() +  " selama 5 hari akan menghasilkan biaya sewa \nsebesar Rp" + matematika.getBiayaSewa(5) + ",00. Apabila terlambat 3 hari, maka peminjam wajib membayar \ndenda sebesar Rp" + matematika.getDenda(3) + ",00.");
    }
}
