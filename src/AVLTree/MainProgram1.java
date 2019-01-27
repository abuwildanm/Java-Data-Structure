package AVLTree;

import java.util.Scanner;

public class MainProgram1 {

    public static void main(String[] args) {
        Scanner masuk = new Scanner(System.in);
        AVLTree tree = new AVLTree();
        
        tree.akar = tree.insert(tree.akar, 200);
        tree.akar = tree.insert(tree.akar, 1);
        tree.akar = tree.insert(tree.akar, 150);
        tree.akar = tree.insert(tree.akar, 111154);
        tree.akar = tree.insert(tree.akar, 55);
        
        System.out.println("Preorder");
        tree.preOrder(tree.akar);
        System.out.println("\nInorder");
        tree.inOrder(tree.akar);
        System.out.println();
        System.out.println("");
        
        //No. 1
        System.out.print("Masukkan data yang ingin dicari : ");
        int data = masuk.nextInt();
        tree.cariDt(data);
        System.out.println();
        System.out.print("Masukkan data yang ingin dicari : ");
        data = masuk.nextInt();
        tree.cariDt(data);
        System.out.println();
        System.out.print("Data yang ingin dihapus : ");
        int hapusdata = masuk.nextInt();
        tree.delete(hapusdata);
        System.out.println("Setelah data " + hapusdata + " dihapus : ");
        System.out.println("Preorder");
        tree.preOrder(tree.akar);
        System.out.println("\nInorder");
        tree.inOrder(tree.akar);
        System.out.println();
        System.out.println("");
        
        //No. 2
        AVLTree tree2 = new AVLTree();
        System.out.print("Masukkan level node : ");
        int level = masuk.nextInt();
        int minNode = tree2.minNodeByLevel(level);
        System.out.println("Jumlah minimal node: " + minNode);
        int urutan[] = new int[minNode];
        System.out.print("Masukkan urutan node : ");
        for (int i = 0; i < urutan.length; i++) {
            urutan[i] = masuk.nextInt();
            tree2.akar = tree2.insert(tree2.akar, urutan[i]);
        }
        System.out.print("Urutan node yang mungkin adalah : ");
        for (int i = 0; i < urutan.length; i++) {
            System.out.print(urutan[i] + " ");
        }
        System.out.println("");
    }
}