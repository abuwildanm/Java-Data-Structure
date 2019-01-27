//package TriwizardGame;
//
//import java.util.Scanner;
//
//class Point {
//    public int x, y;
//    public Point(int arg1, int arg2) {
//        x = arg1;
//        y = arg2;
//    }
//}
//
//class User {
//    public Point path[];
//    public String name, moveData[] = new String[4];
//    public int index = 0;
//
//    public User(String arg, int luas) {
//        name = arg;
//        path = new Point[luas * luas];
//    }
//
//    public void addPath(int x, int y) {
//        if (index >= path.length) return;
//        path[index++] = new Point(x, y);
//    }
//}
//
//class Triwizard {
//    public int luas, arena[][];
//    public User users[];
//    public Point awal, akhir;
//
//    public void makeArena(int luas) { this.luas = luas; this.arena = new int[luas][luas]; }
//    public void makeArena(int luas, String arenaCoordinate) {
//        makeArena(this.luas = luas);
//        String[] arr = arenaCoordinate.split(" ");
//
//        for (int i = 0; i < arr.length; i++) 
//            arena[arr[i].charAt(0) - 48][arr[i].charAt(2) - 48] = 1;
//        awal = new Point(arr[0].charAt(0) - 48, arr[0].charAt(2) - 48);
//        akhir = new Point(arr[arr.length - 1].charAt(0) - 48, arr[arr.length - 1].charAt(2) - 48);
//    }
//
//    public void play() {
//        Scanner in = new Scanner(System.in);
//        int i, j, k, m, n;
//            
//        System.out.println("\n\n=============== GAME PLAY ===============");
//        System.out.print("Masukkan banyak peserta: ");
//        n = in.nextInt();
//        users = new User[n];
//        for (i = 0; i < n; i++) {
//            in.nextLine();
//            System.out.print("Masukkan nama user ke-" + i + ": ");
//            User user = new User(in.nextLine(), this.luas);
//
//            System.out.print("Masukkan pergerakan user ke-" + i + ": ");
//            user.moveData[0] = in.next();
//            user.moveData[1] = in.next();
//            user.moveData[2] = in.next();
//            user.moveData[3] = in.next();
//            findPath(user, awal.x, awal.y);
//            printResult(user);
//        }
//    }
//
//    public void play2() {
//        Scanner in = new Scanner(System.in);
//        int i, j, k, m, n;
//        n = in.nextInt();
//        users = new User[n];
//        for (i = 0; i < n; i++) {
//            in.nextLine();
//            User user = new User(in.next(), this.luas);
//            user.moveData[0] = in.next();
//            user.moveData[1] = in.next();
//            user.moveData[2] = in.next();
//            user.moveData[3] = in.next();
//            findPath(user, awal.x, awal.y);
//            printResult(user);
//        }
//    }
//
//    public int[][] duplicateArena() {
//        int[][] loc1 = new int[arena.length][arena[0].length];
//
//        for (int i = 0; i < loc1.length; i++)
//        for (int j = 0; j < loc1.length; j++) 
//        loc1[i][j] = arena[i][j];
//        return loc1;
//    }
//
//    public void printArena() {
//        for (int i = 0; i < arena.length; i++) {
//            for (int j = 0; j < arena.length; j++) {
//                int m = arena[j][i];
//                if (m == 0) System.out.print("[xx]");
//                else if (m == 1) System.out.print("[  ]");
//            }
//            System.out.println();
//        }
//    }
//
//    public void printResult(User user) {
//        int i, j, k, m, n;
//        Point path[] = user.path;
//        int[][] tracingArena = duplicateArena();
//
//        for (i = 0; i < path.length; i++) {
//            if (path[i] != null) tracingArena[path[i].x][path[i].y] = 2 + i;
//        }
//
//        for (i = tracingArena.length - 1; i >= 0; i--) {
//            for (j = 0; j < tracingArena[i].length; j++) {
//                m = tracingArena[j][i];
//                if (m == 0) System.out.print("[xx]");
//                else if (m == 1) System.out.print("[  ]");
//                else {
//                    m -= 1;
//                    System.out.print("[" + (m < 10 ? "0" + m : m) + "]");
//                } 
//            }
//
//            System.out.println();
//        }
//    }
//
//    public boolean findPath(User user, int x, int y) {
//        return findPath(user, x, y, "another");
//    }
//
//    public boolean findPath(User user, int x, int y, String before) {
//        int i, j, k, x1, y1;
//        String []md = user.moveData;
//
//        user.addPath(x, y);
//        if (x == this.akhir.x && y == this.akhir.y) return true;
//
//        for (i = 0; i < md.length; i++) {
//            if (md[i].equalsIgnoreCase("UP")) {
//                if (y != arena.length - 1) {
//                    x1 = x;
//                    y1 = y + 1;
//                    if (arena[x1][y1] == 1 && !before.equalsIgnoreCase("DOWN")) 
//                    if (findPath(user, x1, y1, "UP")) return true;
//                }
//            } else if (md[i].equalsIgnoreCase("RIGHT")) {
//                if (x != arena.length - 1) {
//                    x1 = x + 1;
//                    y1 = y;
//                    if (arena[x1][y1] == 1 && !before.equalsIgnoreCase("LEFT")) 
//                    if (findPath(user, x1, y1, "RIGHT")) return true;
//                }
//            } else if (md[i].equalsIgnoreCase("DOWN")) {
//                if (y != 0) {
//                    x1 = x;
//                    y1 = y - 1;
//                    if (arena[x1][y1] == 1 && !before.equalsIgnoreCase("UP")) 
//                    if (findPath(user, x1, y1, "DOWN")) return true;
//                }
//            } else if (md[i].equalsIgnoreCase("LEFT")) {
//                if (x != 0) {
//                    x1 = x - 1;
//                    y1 = y;
//                    if (arena[x1][y1] == 1 && !before.equalsIgnoreCase("RIGHT")) 
//                    if (findPath(user, x1, y1, "LEFT")) return true;
//                }
//            }
//        }
//
//        return false;
//    }
//}
//
//public class Main2 {
//    public static void main(String[] args) {   
//        Scanner in = new Scanner(System.in);
//        Triwizard triwizard = new Triwizard();
//        System.out.println("=========== TRIWIZARD GAME ===========");
//        System.out.print("Masukkan luas arena (n): ");
//        int luas = in.nextInt(); in.nextLine();
//        System.out.print("Masukkan path arena: ");
//        triwizard.makeArena(luas, in.nextLine());
//        triwizard.printArena();
//
//        triwizard.play();
//    }
//
//    public static int getPath() {
//        return 0;
//    }
//}