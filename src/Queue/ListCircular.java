package Queue;

public class ListCircular {
    NodeCircular nodeAwal, nodeAkhir;
    private String nama;
    
    public ListCircular(){ this( "list" ); }
    
    public ListCircular( String namaList ){
        nama = namaList;
        nodeAwal = nodeAkhir = null;
    }
    
    public void sisipDiAwal( Object dt ){
        NodeCircular temp = new NodeCircular(dt);
        if (kosong()) { nodeAwal = nodeAkhir = temp; }
        else { temp.next = nodeAwal; nodeAwal = temp; } 
        nodeAkhir.next = nodeAwal;
    }
    
    public void sisipDiAkhir( Object dt ){
        NodeCircular temp = new NodeCircular(dt);
        if (kosong()) { nodeAwal = nodeAkhir = temp; }
        else { nodeAkhir.next = temp; nodeAkhir = temp; }
        nodeAkhir.next = nodeAwal;
    }
    
    public Object hapusDrDepan(){
        Object itemDihapus = null;
        if (!kosong()) {
            itemDihapus = nodeAwal.data;
            nodeAwal = nodeAwal.next;
            nodeAkhir.next = nodeAwal;
        }
        return itemDihapus;
    }
    
    public Object hapusData(Object data){
        NodeCircular beforePointer = null;
        NodeCircular pointer = nodeAwal;
        Object removed = null;
        
        if (kosong()) return null;
        
        do {
            if (pointer.data.equals(data)) {
                removed = pointer.data;
                beforePointer.next = pointer.next;
            }
            beforePointer = pointer;
            pointer = pointer.next;
        } while (pointer != nodeAwal);
        
        return removed;
    }
        
    public boolean kosong(){ return nodeAwal == null; }
    
    public int size() {
        int counter = 0;
        NodeCircular p = nodeAwal;   
        do { counter++; p = p.next; } while (p != nodeAwal);        
        return counter;
    }
    
    public void cetak(){
        if ( kosong() ){ System.out.printf( "Kosong %s\n", nama ); return; }
        System.out.printf( "Isi %s adalah : ", nama );
        NodeCircular kini = nodeAwal;
        do {
            System.out.printf( "%s ", kini.data );
            kini = kini.next;
        } while ( kini != nodeAwal );
        System.out.println( "\n" );
    }
}