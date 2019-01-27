package TriwizardGame;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {   
        Scanner in = new Scanner(System.in);
        Triwizard triwizard = new Triwizard();
        System.out.println("=========== TRIWIZARD GAME ===========");
        System.out.print("Masukkan luas arena (n): ");
        int luas = in.nextInt(); in.nextLine();
        System.out.print("Masukkan path arena: ");
        triwizard.makeArena(luas, in.nextLine());
        triwizard.printArena();

        triwizard.play();
    }

    public static int getPath() {
        return 0;
    }
}