//package LinkedList.Circular;
//
//class NodeCSLL {
//    Object data;
//    NodeCSLL next;
//}
//
//public class CircularSingleLinkedList1 {
//    private NodeCSLL pAwal, pAkhir;
//    private int counter;
//    
//    public CircularSingleLinkedList1(){
//        pAwal = null;
//        pAkhir = null;
//        counter = -1;
//    }
//    
//    public void SisipDataDiAwal(Object data){
//        NodeCSLL pBaru = new NodeCSLL();
//        pBaru.data = data;
//        pBaru.next = null;
//        if (pAwal == null){
//            pAwal = pBaru;
//            pAkhir = pBaru;
//            pBaru.next = pAwal;
//            counter = 0;
//        } else {
//            pBaru.next = pAwal;
//            pAwal = pBaru;
//            pAkhir.next = pAwal;
//            counter++;
//        }
//    }
//    
//    public void hapusData(Object dtHapus){
//        if(pAwal != null) {
//            NodeCSLL pSbl, pKini,pHapus;
//            pSbl = null; pKini = pAwal;
//            boolean ketemu = false;
//            int i=-1;
//            if (pAwal != null) i = 0;
//            while(!ketemu && (i <= counter) && (i != -1)){
//                if (pKini.data.equals(dtHapus)) {
//                    ketemu = true;
//                }
//                else {
//                    pSbl = pKini;
//                    pKini = pKini.next;
//                }
//                i++;
//            }
//            if (ketemu){
//                if(pSbl == null) {
//                    pHapus = pAwal;
//                    pHapus = null;
//                } else {
//                    pSbl.next = pKini.next;
//                    pHapus = pKini;
//                    pHapus = null;
//                }
//                this.counter--;
//            }
//        }
//    }
//    
//    public Object hapusSatuDataDiAkhir(){
//        if (pAwal != null) {
//            NodeCSLL p = pAwal;
//            Object removed = pAkhir.data;
//            do {
//                if (p.next.equals(pAkhir)) {
//                    pAkhir = p;
//                    pAkhir.next = pAwal;
//                    counter--;
//                }
//                p = p.next;
//            } while (p != pAwal);
//            return removed;
//        }
//        return null;
//    }
//    
//    public void cetakBuku(String param, double hargaSewa) {
//        NodeCSLL pCetak = pAwal;
//        int i = -1, anggota = 0;
//        
//        if (param.equalsIgnoreCase("lebihdari")) {
//            System.out.println("Buku dengan sewa lebihdari Rp " + hargaSewa);
//        }
//        else if (param.equalsIgnoreCase("kurangdari")) {
//            System.out.println("Buku dengan sewa kurangdari Rp " + hargaSewa);
//        }
//        else if (param.equalsIgnoreCase("samadengan")) {
//            System.out.println("Buku dengan sewa samadengan Rp " + hargaSewa);
//        }
//        
//        while((i < counter)){
//            Buku book = (Buku)pCetak.data;
//            if (param.equalsIgnoreCase("lebihdari") && book.getHargaSewa() > hargaSewa) {
//                System.out.println((++anggota) + ". " + pCetak.data);
//            }
//            else if (param.equalsIgnoreCase("kurangdari") && book.getHargaSewa() < hargaSewa) {
//                System.out.println((++anggota) + ". " + pCetak.data);
//            }
//            else if (param.equalsIgnoreCase("samadengan") && book.getHargaSewa() == hargaSewa) {
//                System.out.println((++anggota) + ". " + pCetak.data);
//            }
//            pCetak = pCetak.next;
//            i++; 
//        }
//        System.out.println("");
//    }
//    
//    public void cetak(String Komentar){
//        System.out.println(Komentar);
//        NodeCSLL pCetak;
//        pCetak = pAwal;
//        int i=-1;
//        while((i < counter)){
//            System.out.println((i + 2) + ". " + pCetak.data);
//            pCetak = pCetak.next;
//            i++;
//        }
//        System.out.println("");
//    }
//    
//    public static void main(String[] args) {
//        Buku buku1 = new Buku("Komik", "Doraemon", 1000, 100);
//        Buku buku2 = new Buku("Komik", "One Piece", 2000, 200);
//        Buku buku3 = new Buku("Pelajaran", "Kalkulus", 3000, 300);
//        Buku buku4 = new Buku("Pelajaran", "Metode Numerik", 4000, 400);
//        Buku buku5 = new Buku("Novel", "Tenggelamnya Kapal Van der Wijck", 10000, 500);
//        CircularSingleLinkedList1 csll = new CircularSingleLinkedList1();
//        csll.SisipDataDiAwal(buku1);
//        csll.SisipDataDiAwal(buku2);
//        csll.SisipDataDiAwal(buku3);
//        csll.SisipDataDiAwal(buku4);
//        csll.SisipDataDiAwal(buku5);
//        csll.cetak("Data Buku");
//        csll.cetakBuku("lebihdari", 3000);
//        csll.cetakBuku("kurangdari", 3000);
//        csll.cetakBuku("samadengan", 3000);
//    }
//}