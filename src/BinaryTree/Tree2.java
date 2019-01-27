package BinaryTree;

class Node{
    Object data;
    Node nodeKiri, nodeKanan;
    
    public Node(Object dt){ data = dt; nodeKiri = nodeKanan = null; }
    
    public boolean isNumberInt(Object dtSisip) {
        return dtSisip.getClass() == Integer.class;
    }
    
    public boolean isCharacter(Object dtSisip) {
        return dtSisip.getClass() == Character.class;
    }
    
    public void sisipDt(Object dtSisip ){
        Integer angkaDataSisip = 0, angkaData = 0;
        Character charDataSisip = ' ', charData = ' ';
        
        if (isNumberInt(dtSisip)) {
            angkaDataSisip = (Integer)dtSisip;
            angkaData = (Integer)this.data;
        } else if (isCharacter(dtSisip)) {
            charDataSisip = (Character)dtSisip;
            charData = (Character)this.data;
        }
        
        if (angkaDataSisip < angkaData || charDataSisip < charData){
            if(nodeKiri == null) nodeKiri = new Node( dtSisip );
            else nodeKiri.sisipDt( dtSisip );
        }
        else if(angkaDataSisip > angkaData || charDataSisip > charData){
            if ( nodeKanan == null ) nodeKanan = new Node(dtSisip);
            else nodeKanan.sisipDt(dtSisip);
        }
    }
    
    public boolean isLeaf() { return nodeKiri == null && nodeKanan == null; }
}

public class Tree2 {
    private Node root;
    private int counter, leaf;
    
    public Tree2() { root = null; counter = 0; leaf = 0; }
    
    public void makeEmpty() { root = null; }
    
    public void sisipDtNode(Object dtSisip){
        if (root == null) root = new Node( dtSisip );
        else root.sisipDt(dtSisip);
        counter++;
    }
    
    public void preorderTraversal() { preorder(root); }
    
    private void preorder(Node node){
        if(node == null) return;
        System.out.print(node.data + " ");
        preorder(node.nodeKiri);
        preorder(node.nodeKanan);
    }
    
    public void inorderTraversal(){ inorder( root ); }
    
    private void inorder(Node node){
        if (node == null) return;
        inorder(node.nodeKiri);
        System.out.print(node.data + " ");
        inorder( node.nodeKanan );
    }
    
    public void postorderTraversal(){ postorder( root ); }
    
    private void postorder(Node node){
        if (node == null) return;
        postorder(node.nodeKiri);
        postorder(node.nodeKanan);
        System.out.print(node.data + " ");
    }
    
    public int size() { return counter; }
    
    public int countLeaf() { countLeaf(root); return leaf; }
    
    public void countLeaf(Node node) {
        if (node == null) { return; }
        if (node.isLeaf()) { leaf++; }
        countLeaf(node.nodeKiri);
        countLeaf(node.nodeKanan);
    }
    
    public int height() { return height(root); }
    
    public int height(Node node) {
        if (node == null) { return -1; }
        int left = height(node.nodeKiri);
        int right = height(node.nodeKanan);
        return Math.max(left, right) + 1;
    }
    
    public int level() { return height(root) + 1; }
    
    public static void main(String args[]) {
        Tree2 Tree = new Tree2();
        
        System.out.println("=== Inputan Angka ===");
        Tree.sisipDtNode(1154);
        Tree.sisipDtNode(11);
        Tree.sisipDtNode(200);
        Tree.sisipDtNode(150);
        Tree.sisipDtNode(1);
        Tree.sisipDtNode(55);
        
        System.out.print( "Preorder traversal  : " );
        Tree.preorderTraversal();
        System.out.print( "\nInorder traversal   : " );
        Tree.inorderTraversal();
        System.out.print( "\nPostorder traversal : " );
        Tree.postorderTraversal();
        System.out.println();
        Tree.makeEmpty();
        
        System.out.println("\n=== Inputan Karakter ===");
        Tree.sisipDtNode('N');
        Tree.sisipDtNode('B');
        Tree.sisipDtNode('A');
        Tree.sisipDtNode('D');
        
        System.out.print( "Preorder traversal  : " );
        Tree.preorderTraversal();
        System.out.print( "\nInorder traversal   : " );
        Tree.inorderTraversal();
        System.out.print( "\nPostorder traversal : " );
        Tree.postorderTraversal();
        System.out.println();
    }
}