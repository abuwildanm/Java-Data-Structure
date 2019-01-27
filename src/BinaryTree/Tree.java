package BinaryTree;

//package Tree;
//
//import java.util.Random;
//class Node{
//    int data;
//    Node nodeKiri, nodeKanan;
//    
//    public Node(int dt){ data = dt; nodeKiri = nodeKanan = null; }
//    
//    public void sisipDt(int dtSisip ){
//        if (dtSisip < data){
//            if(nodeKiri == null) nodeKiri = new Node( dtSisip );
//            else nodeKiri.sisipDt( dtSisip );
//        }
//        else if(dtSisip > data){
//            if ( nodeKanan == null ) nodeKanan = new Node(dtSisip);
//            else nodeKanan.sisipDt(dtSisip);
//        }
//    }
//    
//    public boolean isLeaf() { return nodeKiri == null && nodeKanan == null; }
//}
//
//public class Tree {
//    private Node root;
//    private int counter, leaf;
//    
//    public Tree() { root = null; counter = 0; leaf = 0; }
//    
//    public void sisipDtNode(int dtSisip){
//        if (root == null) root = new Node( dtSisip );
//        else root.sisipDt(dtSisip);
//        counter++;
//    }
//    
//    public void preorderTraversal() { preorder(root); }
//    
//    private void preorder(Node node){
//        if(node == null) return;
//        System.out.printf( "%d ", node.data );
//        preorder(node.nodeKiri);
//        preorder(node.nodeKanan);
//    }
//    
//    public void inorderTraversal(){ inorder( root ); }
//    
//    private void inorder(Node node){
//        if (node == null) return;
//        inorder(node.nodeKiri);
//        System.out.printf( "%d ", node.data );
//        inorder( node.nodeKanan );
//    }
//    
//    public void postorderTraversal(){ postorder( root ); }
//    
//    private void postorder(Node node){
//        if (node == null) return;
//        postorder(node.nodeKiri);
//        postorder(node.nodeKanan);
//        System.out.printf( "%d ", node.data );
//    }
//    
//    public int size() { return counter; }
//    
//    public int countLeaf() { countLeaf(root); return leaf; }
//    
//    public void countLeaf(Node node) {
//        if (node == null) { return; }
//        if (node.isLeaf()) { leaf++; }
//        countLeaf(node.nodeKiri);
//        countLeaf(node.nodeKanan);
//    }
//    
//    public int height() { return height(root); }
//    
//    public int height(Node node) {
//        if (node == null) { return -1; }
//        int left = height(node.nodeKiri);
//        int right = height(node.nodeKanan);
//        return Math.max(left, right) + 1;
//    }
//    
//    public int level() { return height(root) + 1; }
//    
//    public static void main(String args[]) {
//        Tree Tree = new Tree();
//        int nilai;
//        Random randomNumber = new Random();
//        
//        System.out.println( "sisip nilai data berikut : " );
//        
//        // sisipDt 10 bilangan acak dari 0-99 ke dalam tree
//        for ( int i = 1; i <= 10; i++ ) {
//            nilai = randomNumber.nextInt( 100 );
//            System.out.print(nilai + " " );
//            Tree.sisipDtNode(nilai);
//        }
//        
//        System.out.println ( "\n\nPreorder traversal" );
//        Tree.preorderTraversal();
//        System.out.println ( "\n\nInorder traversal" );
//        Tree.inorderTraversal();
//        System.out.println ( "\n\nPostorder traversal" );
//        Tree.postorderTraversal();
//        System.out.println();
//        
//        System.out.println("\nJumlah Simpul : " + Tree.size());
//        System.out.println("Jumlah daun   : " + Tree.countLeaf());
//        System.out.println("Height        : " + Tree.height());
//        System.out.println("Level         : " + Tree.level());
//    }
//}