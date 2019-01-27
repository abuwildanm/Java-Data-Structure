//package LinkedList.Single;
//
//class Node {
//    int data;
//    Node next;
//}
//
//public class SingleLinkedList {
//    private Node pointer;
//    
//    // contructor LL
//    public SingleLinkedList() {
//        pointer = null;
//    }
//    
//    // membuat suatu node baru
//    public void buatNode(int dt) {
//        Node nodeBaru = new Node();
//        nodeBaru.data = dt;
//        nodeBaru.next = pointer;
//        pointer = nodeBaru;
//    }
//    
//    // menambah data dt1 setelah data dt2 dalam LL
//    public boolean sisip(int dt1, int dt2){
//        Node n = pointer;
//        while ((n != null) && (n.data != dt2))
//            n = n.next;
//        if (n == null) return false;
//        Node nn = new Node();
//        nn.data = dt1;
//        nn.next = n.next;
//        n.next = nn;
//        return true;
//    }
//    
//    // secara normal data dihapus di depan
//    public int hapusDiDepan(){
//        Node hapus = pointer;
//        pointer = pointer.next;
//        return hapus.data;
//    }
//    
//    public void sisipDataDiAkhir(int data){
//        Node pSblAkhir, pAkhir;
//        pSblAkhir = null;
//        pAkhir = pointer;
//        Node baru = new Node();
//        baru.data = data;
//        baru.next = null;
//        while(pAkhir != null){
//            pSblAkhir = pAkhir;
//            pAkhir = pAkhir.next;
//        }
//        pSblAkhir.next = baru;
//    }
//    
//    public void sisipDataUrut(int data){
//        if (pointer == null) buatNode(data);
//        else {
//            buatNode(data);
//            Node pAkhir = pointer;
//            Node pSblAkhir = pAkhir;
//            while (pAkhir != null) {
//                if (pSblAkhir.data < pAkhir.data) {
//                    int tmp = pSblAkhir.data;
//                    pSblAkhir.data = pAkhir.data;
//                    pAkhir.data = tmp;
//                }
//                pSblAkhir = pAkhir;
//                pAkhir = pAkhir.next;
//            }
//        }
//    }
//    
//    public void hapusData(int dataHapus){
//        Node pSblAkhir = null;
//        Node pAkhir = pointer;
//        while (pAkhir != null) {
//            if (pAkhir.data == dataHapus) { pSblAkhir.next = pAkhir.next; }
//            else { pSblAkhir = pAkhir; }
//            pAkhir = pAkhir.next;
//        }
//    }
//    
//    public Node getPointer(){
//        return pointer;
//    }
//    
//    public static SingleLinkedList gabung(SingleLinkedList L1, SingleLinkedList L2){
//        SingleLinkedList tmp = L1;
//        Node p = L2.pointer;
//        while (p != null) {
//            tmp.sisipDataDiAkhir(p.data);
//            p = p.next;
//        }
//        return tmp;
//    }
//    
//    // cetak data
//    public void cetak(String kom) {
//        System.out.println(kom);
//        Node n = pointer;
//        while (n!= null) {
//            System.out.print(n.data+"->");
//            n = n.next;
//        }
//        System.out.println("NULL");
//    }
//    
//    public static void main(String[] args) {
//        SingleLinkedList l = new SingleLinkedList();
//        l.buatNode(11);
//        l.buatNode(2);
//        l.buatNode(30);
//        l.buatNode(14);
//        l.buatNode(5);
//        l.buatNode(16);
//        l.cetak("l : LL Asal");
//        l.sisipDataDiAkhir(56);
//        l.cetak("l : LL setelah sisip di akhir");
//        System.out.println(l.hapusDiDepan());
//        l.cetak("l : LL setelah dihapus di depan");
//        l.hapusData(30);
//        l.cetak("LL setelah 30 dihapus");
//        SingleLinkedList l2 = new SingleLinkedList();
//        l2.sisipDataUrut(5);
//        l2.sisipDataUrut(1);
//        l2.sisipDataUrut(21);
//        l2.sisipDataUrut(3);
//        l2.sisipDataUrut(9);
//        l2.sisipDataUrut(16);
//        l2.sisipDataUrut(12);
//        l2.cetak("L2 : LL terurut");
//        SingleLinkedList L3 = SingleLinkedList.gabung(l, l2);
//        L3.cetak("L3 : L gabungan L1 dan L2");
//    }
//}