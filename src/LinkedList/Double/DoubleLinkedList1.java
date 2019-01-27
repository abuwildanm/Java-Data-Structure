//package LinkedList.Double;
//
//import java.util.Scanner;
//
//class NodeDLL{
//    Object data;
//    NodeDLL prev,next;
//}
//
//public class DoubleLinkedList1 {
//    private NodeDLL pKepala, pEkor;
//    
//    public DoubleLinkedList1(){
//        pKepala = null;
//        pEkor = null;
//    }
//    
//    public void buatKosong() { pKepala = pEkor = null; }
//    
//    public void sisipDipKepala(Object dt){
//        NodeDLL baru = new NodeDLL();
//        baru.data = dt;
//        if (pKepala == null) {
//            baru.prev = pKepala;
//            baru.next = pEkor;
//            pKepala = baru;
//            pEkor = baru;
//        } else {
//            baru.next = pKepala;
//            pKepala.prev = baru;
//            pKepala = baru;
//        }
//    }
//    
//    public void sisipDipEkor(Object data){
//        NodeDLL baru = new NodeDLL();
//        baru.data = data;
//        if (pEkor == null) {
//            baru.prev = pKepala;
//            baru.next = pEkor;
//            pKepala = baru;
//            pEkor = baru;
//        } else {
//            baru.prev = pEkor;
//            pEkor.next = baru;
//            pEkor = baru;
//        }
//    }
//    
//    public void cetak(String kom){
//        System.out.println(kom);
//        NodeDLL p = pKepala;
//        while (p!=pEkor.next){
//            System.out.println(p.data + "\n");
//            p = p.next;
//        }
//        System.out.println();
//    }
//    
//    public void hapusDataTertentu(Object dataHapus){
//        NodeDLL p = pKepala;
//        while (p != null) {
//            if (p.data == dataHapus) { p.prev.next = p.next; }
//            p = p.next;
//        }
//    }
//    
//    public void sisipDataTerurut(Object data){
//        NodeDLL p = pKepala;
//        
//        if (pKepala == null && pEkor == null) { sisipDipKepala(data); }
//        else {
//            sisipDipKepala(data);
//            while (p != null) {
//                Buku bookPPrev = (Buku)p.prev.data;
//                Buku bookP = (Buku)p.data;
//                if (bookPPrev.getHargaSewa() > bookP.getHargaSewa()) {
//                    Object tmp = p.prev.data;
//                    p.prev.data = p.data;
//                    p.data = tmp;
//                }
//                p = p.next;
//            }
//        }
//    }
//    
//    public static void inputBuku(Buku[] buku) {
//        Scanner masuk = new Scanner(System.in);
//        for (int i = 0; i < buku.length; i++) {
//            System.out.print("Masukkan No. ID Buku      : ");
//            short id = masuk.nextShort(); masuk.nextLine();
//            System.out.print("Masukkan Kategori Buku    : ");
//            String kategori = masuk.nextLine();
//            System.out.print("Masukkan Judul Buku       : ");
//            String judul = masuk.nextLine();
//            System.out.print("Masukkan Harga Sewa Buku  : ");
//            double sewa = masuk.nextDouble();
//            System.out.print("Masukkan Harga Denda Buku : ");
//            double denda = masuk.nextDouble();
//            buku[i] = new Buku(id, kategori, judul, sewa, denda);
//            System.out.println("");
//        }
//    }
//    
//    public static void menu(Buku[] buku) {
//        Scanner masuk = new Scanner(System.in);
//        byte pilihan = 0;
//        DoubleLinkedList1 dll = new DoubleLinkedList1();
//        do {
//        System.out.println("------ Menu Linked List ------");
//        System.out.println("1. Sisip di pKepala");
//        System.out.println("2. Sisip di pEkor");
//        System.out.println("3. Hapus Data Buku Tertentu");
//        System.out.println("4. Sisip Data Buku Terurut");
//        System.out.println("5. Melihat Isi List");
//        System.out.println("0. Berhenti");
//        System.out.println("------------------------------");
//        System.out.print("Masukkan pilihan anda : "); pilihan = masuk.nextByte();
//        System.out.println("");
//        
//        switch (pilihan) {
//            case 1 :
//                for (int i = 0; i < buku.length; i++) {
//                    dll.sisipDipKepala(buku[i]);
//                } System.out.println("BUKU BERHASIL DIINPUTKAN!\n"); break;
//            case 2 : 
//                for (int i = 0; i < buku.length; i++) {
//                    dll.sisipDipEkor(buku[i]);
//                } System.out.println("BUKU BERHASIL DIINPUTKAN!\n"); break;
//            case 3 : 
//                System.out.print("Masukkan No. ID Buku : ");
//                byte id = masuk.nextByte();
//                for (int i = 0; i < buku.length; i++) {
//                    if (buku[i].getId() == id) {
//                        dll.hapusDataTertentu(buku[i]);
//                    }
//                } System.out.println("PENGHAPUSAN BERHASIL!\n"); break;
//            case 4 :
//                dll.buatKosong();
//                for (int i = 0; i < buku.length; i++) {
//                    dll.sisipDataTerurut(buku[i]);
//                } System.out.println("BUKU BERHASIL DIINPUTKAN!\n"); break;
//            case 5 : dll.cetak("Isi List : "); break;
//            case 0 : System.out.println("Terima Kasih\n"); break;
//            default : System.err.println("Input Salah!\n"); break;
//        }
//        } while (pilihan != 0);
//    }
//    
//    public static void main(String s[]){
//        Scanner masuk = new Scanner(System.in);
//        System.out.print("Masukkan banyak buku : ");
//        byte banyakBuku = masuk.nextByte(); System.out.println("");
//        Buku[] buku = new Buku[banyakBuku];
//        inputBuku(buku);
//        menu(buku);
//    }
//}