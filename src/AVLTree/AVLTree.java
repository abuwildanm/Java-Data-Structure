package AVLTree;

public class AVLTree {
    Node akar;

    int getTinggi(Node N) { return (N != null) ? N.tinggi : 0; }
    
    // Lihat diagram diatas
    Node putarKanan(Node y) {
        Node x = y.nodeKiri;
        Node T2 = x.nodeKanan;

        // Melakukan putaran
        x.nodeKanan = y;
        y.nodeKiri = T2;

        // Update tinggi
        y.tinggi = Math.max(getTinggi(y.nodeKiri), getTinggi(y.nodeKanan)) + 1;
        x.tinggi = Math.max(getTinggi(x.nodeKiri), getTinggi(x.nodeKanan)) + 1;

        // hasilkan pasangan node baru
        return x;
    }

    // Fungsi untuk memutar node melalui x
    // Lihat diagram diatas
    Node putarKiri(Node x) {
        Node y = x.nodeKanan;
        Node T2 = y.nodeKiri;

        // Melakukan putaran
        y.nodeKiri = x;
        x.nodeKanan = T2;

        // Update tinggi
        x.tinggi = Math.max(getTinggi(x.nodeKiri), getTinggi(x.nodeKanan)) + 1;
        y.tinggi = Math.max(getTinggi(y.nodeKiri), getTinggi(y.nodeKanan)) + 1;

        // hasilkan pasangan node baru
        return y;
    }

    // Dapatkan nilai seimbang dari node N
    int getBalance(Node N) {
        return (N!=null) ? getTinggi(N.nodeKiri) - getTinggi(N.nodeKanan) : 0;
    }

    Node insert(Node node, int data) {
    
        /* 1. Penambahan Node pada BST biasa */
        if (node == null) { return (new Node(data)); }

        if (data < node.data) { node.nodeKiri = insert(node.nodeKiri, data); } 
        else if (data > node.data) { node.nodeKanan = insert(node.nodeKanan, data); } 
        else { return node; }

        /* 2. Update tinggi pada ancestor node */
        node.tinggi = 1 + Math.max(getTinggi(node.nodeKiri), getTinggi(node.nodeKanan));

        /* 3. Melakukan keseimbangan pada melalui nilai ancestor untuk mengecek 
        apakah node tidak seimbang*/
        Node result = balance(node, data);

        // hasilkan pasangan node baru
        return result;
    }

    Node balance(Node node, int data) {
        int balance = getBalance(node);

        // Apabila kondisi tidak seimbang maka terjadi rotasi
        // Kondisi putar kanan
        if (balance > 1 && data < node.nodeKiri.data) { return putarKanan(node); }

        // Kondisi putar kiri
        else if (balance < -1 && data > node.nodeKanan.data) { return putarKiri(node); }

        // Kondisi putar kiri kanan
        else if (balance > 1 && data > node.nodeKiri.data) {
            node.nodeKiri = putarKiri(node.nodeKiri);
            return putarKanan(node);
        }

        // Kondisi putar kanan kiri
        else if (balance < -1 && data < node.nodeKanan.data) {
            node.nodeKanan = putarKanan(node.nodeKanan);
            return putarKiri(node);
        }

        // Kondisi tidak berubah sama sekali
        else { return node; }
    }
    
    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.nodeKiri);
            System.out.print(node.data + " ");
            inOrder(node.nodeKanan);
        }
    }
    
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.nodeKiri);
            preOrder(node.nodeKanan);
        }
    }
    
    public void cariDt(int dt) {
        if (cariDt(akar, dt)) { System.out.println("Data " + dt + " ditemukan!"); } 
        else { System.err.println("Data " + dt + " tidak ditemukan!"); }
    }
    
    private boolean cariDt(Node temp, int dt) {
        while (temp != null) {
            if (dt == temp.data) { return true; }
            else if (dt < temp.data) { temp = temp.nodeKiri; }
            else { temp = temp.nodeKanan; }
        }
        return false;
    }

    public void delete(int dt) { akar = delete(akar, dt); balance(akar, dt); }
    
    private Node delete(Node subroot, int dt) {
        if (subroot == null) { return null; }
        if (subroot.data == dt) {
            if (subroot.nodeKiri == null && subroot.nodeKanan == null) { return null; }
            if (subroot.nodeKiri == null) { return subroot.nodeKanan; }
            if (subroot.nodeKanan == null) { return subroot.nodeKiri; }
            Node min = findMinNode(subroot.nodeKanan);
            subroot.nodeKanan = delete(subroot.nodeKanan, min.data);
            min.nodeKiri = subroot.nodeKiri;
            min.nodeKanan = subroot.nodeKanan;
            return min;
        } else if (dt >= subroot.data) {
            subroot.nodeKanan = delete(subroot.nodeKanan, dt);
            return subroot;
        } else {
            subroot.nodeKiri = delete(subroot.nodeKiri, dt);
            return subroot;
        }
    }

    private Node findMinNode(Node subroot) {
        if (subroot.nodeKiri == null) { return subroot; }
        return findMinNode(subroot.nodeKiri);
    }

    public int minNodeByLevel(int depth) {
        int n = depth;
        if (n == 0) { return 1; }
        if (n == 1) { return 2; }
        if (n == 2) { return 4; } 
        else { return 1 + minNodeByLevel(n - 1) + minNodeByLevel(n - 2); }
    }
}