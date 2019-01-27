package LinkedList.Circular;

class NodeCDLL {
    Object data;
    NodeCDLL prev;
    NodeCDLL next;
}

public class CircularDoubleLinkedList {
    private NodeCDLL pAwal, pAkhir;
    private int counter;
    
    public CircularDoubleLinkedList(){
        pAwal = null;
        pAkhir = null;
        counter = -1;
    }
    
    public void SisipDataDiAwal(Object data){
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.prev = null;
        pBaru.next = null;
        if (pAwal == null){
            pAwal = pBaru;
            pAkhir = pBaru;
            counter = 0;
        } else {
            pBaru.next = pAwal;
            pAwal = pBaru;
            counter++;
        }
        pAwal.prev = pAkhir;
        pAkhir.next = pAwal;
    }
    
    public void hapusData(Object dtHapus){
        if(pAwal != null) {
            NodeCDLL pSbl, pKini,pHapus;
            pSbl = null; pKini = pAwal;
            boolean ketemu = false;
            int i=-1;
            if (pAwal != null) i = 0;
            while(!ketemu && (i <= counter) && (i != -1)){
                if (pKini.data.equals(dtHapus)) {
                    ketemu = true;
                }
                else {
                    pSbl = pKini;
                    pKini = pKini.next;
                }
                i++;
            }
            if (ketemu){
                if(pSbl == null) {
                    pHapus = pAwal;
                    pHapus = null;
                } else {
                    pSbl.next = pKini.next;
                    pKini.next.prev = pSbl;
                    pHapus = pKini;
                    pHapus = null;
                }
                this.counter--;
            }
        }
    }
    
    public Object hapusSatuDataDiAkhir(){
        if (pAwal != null) {
            NodeCDLL p = pAwal;
            Object removed = pAkhir.data;
            do {
                if (p.next.equals(pAkhir)) {
                    pAkhir = p;
                    pAkhir.next = pAwal;
                    pAwal.prev = pAkhir;
                    counter--;
                }
                p = p.next;
            } while (p != pAwal);
            return removed;
        }
        return null;
    }
    
    public void cetak(String Komentar){
        System.out.println(Komentar);
        NodeCDLL pCetak;
        pCetak = pAwal;
        int i = -1;
        while((i < counter) ){
            System.out.print(pCetak.data+"->");
            pCetak = pCetak.next;
            i++;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        cdll.SisipDataDiAwal(new Integer(50));
        cdll.SisipDataDiAwal(new Integer(60));
        cdll.SisipDataDiAwal(new Integer(70));
        cdll.SisipDataDiAwal(new Integer(8));
        cdll.SisipDataDiAwal(new Integer(9));
        cdll.SisipDataDiAwal(new Integer(90));
        cdll.SisipDataDiAwal(new Integer(19));
        cdll.cetak("cdll Asal");
        cdll.hapusData(8);
        cdll.cetak("cdll stl 8 di hapus");
        cdll.hapusData(90);
        cdll.cetak("cdll stl 90 di hapus");
        cdll.hapusSatuDataDiAkhir(); 
        cdll.cetak("Data di hapus 50");
    }
}