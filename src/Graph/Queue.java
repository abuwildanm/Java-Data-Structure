package Graph;

public class Queue {
    private LList listAntrian;
    public Queue() { listAntrian = new LList(); }
    public void enqueue(int dt) { listAntrian.sisipDiAkhir(dt); }
    public int dequeue() { return listAntrian.hapusDrDepan(); }
    public boolean isEmpty() { return listAntrian.kosong(); }
}