package Queue;

public class ListDouble {
    private NodeDouble nodeAwal, nodeAkhir;
    private String nama;
    
    public ListDouble(){ this( "list" ); }
    
    public ListDouble( String namaList ){
        nama = namaList;
        nodeAwal = nodeAkhir = null;
    }
    
    public void sisipDiAwal( Object dt ){
        NodeDouble temp = new NodeDouble(dt);
        if (kosong()) { nodeAwal = nodeAkhir = temp; }
        else { temp.next = nodeAwal; nodeAwal = temp; }
    }
    
    public void sisipDiAkhir( Object dt ){
        NodeDouble temp = new NodeDouble(dt);
        if (kosong()) { nodeAwal = nodeAkhir = temp; }
        else { nodeAkhir.next = temp; nodeAkhir = temp; }
    }
    
    public Object hapusDrDepan(){
        Object itemDihapus = null;
        if (!kosong()) {
            itemDihapus = nodeAwal.data;
            if ( nodeAwal == nodeAkhir ) nodeAwal = nodeAkhir = null;
            else nodeAwal = nodeAwal.next;
        }
        return itemDihapus;
    }
    
    public Object hapusDrBelakang(){
        Object itemDihapus = null;
        if (!kosong()) {
            itemDihapus = nodeAkhir.data;
            if ( nodeAwal == nodeAkhir ) nodeAwal = nodeAkhir = null;
            else { nodeAkhir = nodeAkhir.prev; nodeAkhir.next = null; }
        }
        return itemDihapus;
    }
    
    public boolean kosong(){ return nodeAwal == null; }
    
    public void cetak(){
        if ( kosong() ){ System.out.printf( "Kosong %s\n", nama ); return; }
        System.out.printf( "Isi %s adalah : ", nama );
        NodeDouble kini = nodeAwal;
        while ( kini != null ){
            System.out.printf( "%s ", kini.data );
            kini = kini.next;
        }
        System.out.println( "\n" );
    }
}