package Collections.List.Tree;

import Collections.Queue.PriorityQueue.*;

public class BinarySearchTree {
    
    class Node {
        int id;
        Object data;
        Node left, right;
        
        Node(int id, Object data) {
            this.id = id;
            this.data = data;
        }
    }
    
    Node root = null;
    int counter = 0;
    
    //Method tambah data
    public void insert(int id, Object data) {
        Node newest = new Node(id, data);
        
        if (root == null) {
            root = newest;
        } else {
            insert(root, newest);
        }
    }
    
    private void insert(Node subroot, Node newest) {
        if (newest.id < subroot.id) {
            if (subroot.left == null) {
                subroot.left = newest;
            } else {
                insert(subroot.left, newest);
            }
        } else {
            if (subroot.right == null) {
                subroot.right = newest;
            } else {
                insert(subroot.right, newest);
            }
        }
    }
    
    public void printPreOrder() {
        preOrder(root);
    }
    
    public void printInOrder() {
        inOrder(root);
    }
    
    public void printPostOrder() {
        postOrder(root);
    }
    
    private void preOrder(Node subroot) {
        if (subroot != null) {
            System.out.println(subroot.id);
            preOrder(subroot.left);
            preOrder(subroot.right);
        }
    }
    
    private void inOrder(Node subroot) {
        if (subroot != null) {
            inOrder(subroot.left);
            System.out.println(subroot.id);
            inOrder(subroot.right);
        }
    }
    
    private void postOrder(Node subroot) {
        if (subroot != null) {
            postOrder(subroot.left);
            postOrder(subroot.right);
            System.out.println(subroot.id);
        }
    }
    
    private void printLevelOrder() {
        QueueArray q = new QueueArray(10);
//        QueueSLL q = new QueueSLL();
        q.enqueue(root);
        while (q.size() != 0) {
            Node n = (Node)q.dequeue();
            System.out.println(n.id);
            if (n.left != null) {
                q.enqueue(n.left);
            }
            if (n.right != null) {
                q.enqueue(n.right);
            }
        }
    }
    
    public int height(Node subroot) {
        if (subroot == null) {
            return -1;
        } else {
            return Math.max(height(subroot.left) + 1, height(subroot.left) + 1);
        }
    }
    
    public int level(Node subroot) {
        if (subroot == null) {
            return 0;
        } else {
            return Math.max(level(subroot.left) + 1, level(subroot.left) + 1);
        }
    }
    
    public int size(Node subroot) {
//        int counter = 0;
        if (subroot != null) {
            counter++;
            size(subroot.left);
            size(subroot.right);
        }
        return counter;
    }
    
//    public int numOfLeaves(Node subroot) {
//        if (subroot == null) {
//            return 0;
//        } else {
//            if (subroot.left == null) {
//                return 1;
//            }
//        }
//    }
    
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(89, 89);
        b.insert(60, 60);
        b.insert(91, 91);
        b.insert(57, 57);
        b.insert(63, 63);
        b.insert(100, 100);
        b.insert(10, 10);
        System.out.println("PreOrder");
        b.printPreOrder();
        System.out.println("\nInOrder");
        b.printInOrder();
        System.out.println("\nPostOrder");
        b.printPostOrder();
        System.out.println("\nLevelOrder");
        b.printLevelOrder();
        System.out.println("\nHeight : " + b.height(b.root));
        System.out.println("\nLevel : " + b.level(b.root));
        System.out.println("\nSize : " + b.size(b.root));
    }
}
