package AVLTree;

public class MainProgram {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.akar = tree.insert(tree.akar, 5);
        System.out.print("Preorder : ");
        tree.preOrder(tree.akar);
        System.out.print("\nInorder : ");
        tree.inOrder(tree.akar);
        System.out.println("\n");
        
        tree.akar = tree.insert(tree.akar, 4);
        System.out.print("Preorder : ");
        tree.preOrder(tree.akar);
        System.out.print("\nInorder : ");
        tree.inOrder(tree.akar);
        System.out.println("\n");
        
        tree.akar = tree.insert(tree.akar, 19);
        System.out.print("Preorder : ");
        tree.preOrder(tree.akar);
        System.out.print("\nInorder : ");
        tree.inOrder(tree.akar);
        System.out.println("\n");
        
        tree.akar = tree.insert(tree.akar, 9);
        System.out.print("Preorder : ");
        tree.preOrder(tree.akar);
        System.out.print("\nInorder : ");
        tree.inOrder(tree.akar);
        System.out.println("\n");
        
        tree.akar = tree.insert(tree.akar, 7);
        System.out.print("Preorder : ");
        tree.preOrder(tree.akar);
        System.out.print("\nInorder : ");
        tree.inOrder(tree.akar);
        System.out.println("\n");
        
        tree.akar = tree.insert(tree.akar, 65);
        System.out.print("Preorder : ");
        tree.preOrder(tree.akar);
        System.out.print("\nInorder : ");
        tree.inOrder(tree.akar);
        System.out.println("\n");
        
        tree.akar = tree.insert(tree.akar, 1997);
        System.out.print("Preorder : ");
        tree.preOrder(tree.akar);
        System.out.print("\nInorder : ");
        tree.inOrder(tree.akar);
        System.out.println("\n");
        
        /* hasil dari AVL Tree program diatas adalah
         150
         / \
        1 200
         \ \
        55 11154
        */
//        System.out.println("Preorder");
//        tree.preOrder(tree.akar);
//        System.out.println("\nInorder");
//        tree.inOrder(tree.akar);
    }
}