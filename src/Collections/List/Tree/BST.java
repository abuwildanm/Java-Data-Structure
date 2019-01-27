package Collections.List.Tree;

public class BST {
    
    class Node {
        Object data;
        Node left, right;

        public Node(Object data) {
            this.data = data;
        }
    }
    
    Node root;
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public void makeEmpty() {
        root = null;
    }
    
    public void insert(Object data) {
        if (isEmpty()) {
            root = new Node(data);
        } else {
            insert(root, data);
        }
    }
    
    private void insert(Node subroot, Object data) {
        Node temp = new Node(data);
        
        if ((int)temp.data < (int)subroot.data) {
            if (subroot.left == null) {
                subroot.left = temp;
            } else {
                insert(subroot.left, data);
            }
        } else {
            if (subroot.right == null) {
                subroot.right = temp;
            } else {
                insert(subroot.right, data);
            }
        }
    }
    
    public void preorder() {
        preorder(root);
    }
    
    private void preorder(Node subroot) {
        if (subroot != null) {
            System.out.print(subroot.data + " ");
            preorder(subroot.left);
            preorder(subroot.right);
        }
    }
    
    public static void main(String[] args) {
        BST b = new BST();
        b.insert(1);
        b.insert(2);
        b.insert(7);
        b.insert(5);
        b.insert(8);
        b.insert(9);
        b.insert(4);
        b.insert(6);
        b.insert(10);
        b.insert(11);
        b.insert(12);
        System.out.println("PreOrder");
        b.preorder();
    }
    
}
