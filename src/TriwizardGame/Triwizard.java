package TriwizardGame;

import java.util.Scanner;

class Triwizard {
    public int luas, arena[][];
    public User users[];
    public Point awal, akhir;

    public void makeArena(int luas) { this.luas = luas; this.arena = new int[luas][luas]; }
    public void makeArena(int luas, String arenaCoordinate) {
        makeArena(this.luas = luas);
        String[] arr = arenaCoordinate.split(" ");

        for (int i = 0; i < arr.length; i++) 
        arena[arr[i].charAt(0) - 48][arr[i].charAt(2) - 48] = 1;
        awal = new Point(arr[0].charAt(0) - 48, arr[0].charAt(2) - 48);
        akhir = new Point(arr[arr.length - 1].charAt(0) - 48, arr[arr.length - 1].charAt(2) - 48);
    }

    public void play() {
        Scanner in = new Scanner(System.in);
        int i, j, k, m, n;
            
        System.out.println("\n\n=============== GAME PLAY ===============");
        System.out.print("Masukkan banyak peserta: ");
        n = in.nextInt();
        users = new User[n];
        for (i = 0; i < n; i++) {
            in.nextLine();
            System.out.print("Masukkan nama user ke-" + i + ": ");
            User user = new User(in.nextLine(), this.luas);

            System.out.print("Masukkan pergerakan user ke-" + i + ": ");
            user.moveData[0] = in.next();
            user.moveData[1] = in.next();
            user.moveData[2] = in.next();
            user.moveData[3] = in.next();
            findPath(user, new Point(awal.x, awal.y));
            printResult(user);
        }
    }

    public int[][] duplicateArena() {
        int[][] loc1 = new int[arena.length][arena[0].length];

        for (int i = 0; i < loc1.length; i++)
        for (int j = 0; j < loc1.length; j++) 
        loc1[i][j] = arena[i][j];
        return loc1;
    }

    public void printArena() {
        for (int i = 0; i < arena.length; i++) {
            for (int j = 0; j < arena.length; j++) {
                int m = arena[j][i];
                if (m == 0) System.out.print("[xx]");
                else if (m == 1) System.out.print("[  ]");
            }
            System.out.println();
        }
    }

    public void printResult(User user) {
        int i, j, k, m, n;
        DoublyNode<Point> p = user.path.list.getHead();
        int[][] tracingArena = duplicateArena();
        
        i = 0;
        while (p != null) {
            tracingArena[p.data.x][p.data.y] = 2 + i++;
            p = p.next;
        }

        for (i = tracingArena.length - 1; i >= 0; i--) {
            for (j = 0; j < tracingArena[i].length; j++) {
                m = tracingArena[j][i];
                if (m == 0) System.out.print("[xx]");
                else if (m == 1) System.out.print("[  ]");
                else {
                    m -= 1;
                    System.out.print("[" + (m < 10 ? "0" + m : m) + "]");
                } 
            }

            System.out.println();
        }
    }
    
    public Point findPath(User user, Point p) {
        return findPath(user, p, new Point(-1, -1));
    }

    public Point findPath(User user, Point p, Point prev) {
        int i, j, k, x1, y1, x = p.x, y = p.y;
        String []md = user.moveData;
        Point p2;

        user.addPath(p);
        user.addWalkPath(p);
        if (x == this.akhir.x && y == this.akhir.y)  return p;

        for (i = 0; i < md.length; i++) {
            if (md[i].equalsIgnoreCase("UP")) {
                if (y != arena.length - 1) {
                    p2 = new Point(x, y + 1);
                    if (arena[p2.x][p2.y] == 1 && !equalsPoint(prev, p2))
                    if (!equalsPoint(p, findPath(user, p2, p))) return p;
                }
            } else if (md[i].equalsIgnoreCase("RIGHT")) {
                if (x != arena.length - 1) {
                    x1 = x + 1;
                    y1 = y;
                    p2 = new Point(x + 1, y);
                    if (arena[p2.x][p2.y] == 1 && !equalsPoint(prev, p2))
                    if (!equalsPoint(p, findPath(user, p2, p))) return p;
                }
            } else if (md[i].equalsIgnoreCase("DOWN")) {
                if (y != 0) {
                    p2 = new Point(x, y - 1);
                    if (arena[p2.x][p2.y] == 1 && !equalsPoint(prev, p2))
                    if (!equalsPoint(p, findPath(user, p2, p))) return p;
                }
            } else if (md[i].equalsIgnoreCase("LEFT")) {
                if (x != 0) {
                    p2 = new Point(x - 1, y);
                    if (arena[p2.x][p2.y] == 1 && !equalsPoint(prev, p2))
                    if (!equalsPoint(p, findPath(user, p2, p))) return p;
                }
            }
        }
        
        user.walkPath.pop();
        return user.walkPath.top();
    }
    
    public boolean equalsPoint(Point a, Point b) {
        return a.x == b.x && a.y == b.y;
    }
}