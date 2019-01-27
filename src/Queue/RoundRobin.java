package Queue;

public class RoundRobin {
    private ListCircular listAntrian;
    
    public RoundRobin() { listAntrian = new ListCircular(); }
    public void enqueue( Object object ){ listAntrian.sisipDiAkhir( object ); }
    public Object dequeue(){
        Object data = 0;
        if (!kosong()) {
            NodeCircular p = listAntrian.nodeAwal;
            do {
                if (p.data.equals(0)) {
                    if (p.equals(listAntrian.nodeAwal)) { listAntrian.hapusDrDepan(); }
                    else { data = p.data; listAntrian.hapusData(data); }
                } 
                else if ((int)p.data > 0) {
                    data = p.data;
                    p.data = (int)p.data - 1;
                }
                p = p.next;
            } while (p != listAntrian.nodeAwal);
        }
        return data; 
    }
    public boolean kosong(){ return listAntrian.kosong(); }
    public void cetak(){listAntrian.cetak();}

    public static void main( String args[]){
        RoundRobin q = new RoundRobin();
        q.enqueue( 10 );
        q.enqueue( 54 );
        q.enqueue( 10 );
        q.enqueue( 94 );
        q.cetak();
        while(!q.kosong()){
            if (q.listAntrian.size() == 1 && q.listAntrian.nodeAwal.data.equals(0)) { 
                System.out.println("Kosong queue"); break; 
            }
            q.dequeue();
            q.cetak();
        }
    }
}