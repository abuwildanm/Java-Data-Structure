package LinkedList.Single;

class Node {
    Buku data;
    Node next;
}

public class SingleLinkedList1 {
    private Node pointer;
    
    public SingleLinkedList1() {
        pointer = null;
    }
    
    public void buatNode(Buku dt) {
        Node nodeBaru = new Node();
        nodeBaru.data = dt;
        nodeBaru.next = pointer;
        pointer = nodeBaru;
    }
    
    public boolean sisip(Buku dt1, Buku dt2){
        Node n = pointer;
        while ((n != null) && (n.data != dt2))
            n = n.next;
        if (n == null) return false;
        Node nn = new Node();
        nn.data = dt1;
        nn.next = n.next;
        n.next = nn;
        return true;
    }
    
    public Buku hapusDiDepan(){
        Node hapus = pointer;
        pointer = pointer.next;
        return hapus.data;
    }
    
    public void sisipDataDiAkhir(Buku data){
        Node pSblAkhir, pAkhir;
        pSblAkhir = null;
        pAkhir = pointer;
        Node baru = new Node();
        baru.data = data;
        baru.next = null;
        while(pAkhir != null){
            pSblAkhir = pAkhir;
            pAkhir = pAkhir.next;
        }
        pSblAkhir.next = baru;
    }
    
//    public void sisipDataUrut(Buku data){
//        if (pointer == null) buatNode(data);
//        else {
//            buatNode(data);
//            Node pAkhir = pointer;
//            Node pSblAkhir = pAkhir;
//            while (pAkhir != null) {
//                if (pSblAkhir.data.getHargaSewa() < pAkhir.data.getHargaSewa()) {
//                    double tmp = pSblAkhir.data.getHargaSewa();
//                    pSblAkhir.data.getHargaSewa() = pAkhir.data.getHargaSewa();
//                    pAkhir.data.getHargaSewa() = tmp;
//                }
//                pSblAkhir = pAkhir;
//                pAkhir = pAkhir.next;
//            }
//        }
//    }
    
    public void sisipDataUrut(Buku book) {
        if (pointer == null) { buatNode(book); } 
        else {
            while (pointer != null) {
                if (pointer.data.getHargaSewa() < book.getHargaSewa()) {
                    buatNode(book);
                    break;
                } 
                else if (pointer.data.getHargaSewa() > book.getHargaSewa()) {
                    while (pointer.next != null) {
                        if (pointer.next.data.getHargaSewa() < book.getHargaSewa())
                            break;
                        pointer = pointer.next;
                    }
                    sisip(book, pointer.data);
                    break;
                }
            }
        }
    }
    
    public void hapusData(Object dataHapus){
        Node pSblAkhir = null;
        Node pAkhir = pointer;
        while (pAkhir != null) {
            if (pAkhir.data.equals(dataHapus)) { pSblAkhir.next = pAkhir.next; }
            else { pSblAkhir = pAkhir; }
            pAkhir = pAkhir.next;
        }
    }
    
    public Node getPointer(){
        return pointer;
    }
    
    public static SingleLinkedList1 gabung(SingleLinkedList1 L1, SingleLinkedList1 L2){
        SingleLinkedList1 tmp = L1;
        Node p = L2.pointer;
        while (p != null) {
            tmp.sisipDataDiAkhir(p.data);
            p = p.next;
        }
        return tmp;
    }
    
    public void cetak(String kom) {
        System.out.println(kom);
        Node n = pointer;
        while (n!= null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        Buku buku1 = new Buku("Komik", "Doraemon", 1000, 100);
        Buku buku2 = new Buku("Komik", "One Piece", 2000, 200);
        Buku buku3 = new Buku("Pelajaran", "Kalkulus", 3000, 300);
        Buku buku4 = new Buku("Pelajaran", "Metode Numerik", 4000, 400);
        SingleLinkedList1 l = new SingleLinkedList1();
        l.buatNode(buku1);
        l.buatNode(buku2);
        l.buatNode(buku3);
        l.cetak("l : LL Asal");
        l.sisipDataDiAkhir(buku4);
        l.cetak("l : LL setelah sisip di akhir");
        System.out.println(l.hapusDiDepan());
        l.cetak("l : LL setelah dihapus di depan");
        l.hapusData(buku1);
        l.cetak("LL setelah buku1 dihapus");
        SingleLinkedList1 l2 = new SingleLinkedList1();
        l2.sisipDataUrut(buku1);
        l2.sisipDataUrut(buku2);
        l2.sisipDataUrut(buku3);
        l2.sisipDataUrut(buku4);
        l2.cetak("L2 : LL terurut");
        SingleLinkedList1 L3 = SingleLinkedList1.gabung(l, l2);
        L3.cetak("L3 : L gabungan L1 dan L2");
    }
}