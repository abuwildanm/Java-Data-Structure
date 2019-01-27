/*  Nama : Abu Wildan Mucholladin
    NIM  : 165150200111002
*/

package Tugas;

import java.util.Scanner;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Player {
    String name, motion[] = new String[4];
    Point path[];
    int index = 0;
    
    public Player(String nm, int area) {
        name = nm;
        path = new Point[area*area];
    }
    
    public void addPath(int x, int y) {
        if (index >= path.length) return;
        path[index++] = new Point(x, y);
    }
}

class Triwizart {
    int area, maze[][];
    Player players[];
    Point start, end;
    int counterFront = 0;
    int counterBehind = 0;
    
    public void makeMaze(int luas, String mazeCoordinate) {
        area = luas;
        maze = new int[area][area];
        String[] coordinate = mazeCoordinate.split(" ");
        
        for (int i = 0; i < coordinate.length; i++) {
            int coordinateX = Integer.parseInt(Character.toString(coordinate[i].charAt(0)));
            int coordinateY = Integer.parseInt(Character.toString(coordinate[i].charAt(2)));
            maze[coordinateX][coordinateY] = 1;
        }
        int XAwal = Integer.parseInt(Character.toString(coordinate[0].charAt(0)));
        int YAwal = Integer.parseInt(Character.toString(coordinate[0].charAt(2)));
        start = new Point(XAwal, YAwal);
        int XAkhir = Integer.parseInt(Character.toString(coordinate[coordinate.length - 1].charAt(0)));
        int YAkhir = Integer.parseInt(Character.toString(coordinate[coordinate.length - 1].charAt(2)));
        end = new Point(XAkhir, YAkhir);
    }
    
    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                int m = maze[j][i];
                if (maze[j][i] == 0) {
                    System.out.print("[XX]");
                }
                else if (maze[j][i] == 1) {
                    System.out.print("[" + counterFront + counterBehind + "]");
                }
//                else {
//                    m -= 1;
//                    System.out.print("[" + (m < 10 ? "0" + m : m) + "]" + j + i);
//                }
            }
            System.out.println("");
        }
    }
    
    public void printMaze(Player player) {
        int m;
        Point path[] = player.path;

        for (int i = 0; i < path.length; i++) {
            if (path[i] != null) maze[path[i].x][path[i].y] = 2 + i;
        }

        for (int i = maze.length - 1; i >= 0; i--) {
            for (int j = 0; j < maze[i].length; j++) {
                m = maze[j][i];
                if (m == 0) System.out.print("[XX]");
                else if (m == 1) System.out.print("[00]");
                else {
                    m -= 1;
                    System.out.print("[" + (m < 10 ? "0" + m : m) + "]");
                } 
            }

            System.out.println();
        }
    }
    
    public void explore(Player player, int x, int y, StackDLL stack) {
        player.addPath(x, y);
        boolean finish = false;
        
        if (x == this.end.x && y == this.end.y) { finish = true; }
        
        if (finish == false) {
            if (stack.top.data.toString().equalsIgnoreCase("UP")) {
                if (y != maze.length - 1) {
                    y = y + 1;
                    if (maze[x][y] == 1) {
                        maze[x][y] = 9; //penanda maze sudah dilewati
                        if (counterBehind == 9) {
                            counterFront++;
                            counterBehind = 0;
                        }
                        stack.pop();
                        counterBehind++;
                        for (int j = player.motion.length - 1; j >= 0; j--) {
                            stack.push(player.motion[j]);
                        }
                        explore(player, x, y, stack);
                    }
                    else if (maze[x][y] == 0) {
                        for (int i = 0; i < x; i++) {
                            if (maze[i][y] == 1) {
                                x = i;
                                maze[x][y] = 9;
                            }
                        }
                        stack.pop();
                        for (int j = player.motion.length - 1; j >= 0; j--) {
                            stack.push(player.motion[j]);
                        }
                        explore(player, x, y, stack);
                    }
                    else if (maze[x][y] == 9) {
                        for (int i = 0; i < x; i++) {
                            if (maze[i][y] == 1) {
                                x = i;
                                maze[x][y] = 9;
                            }
                        }
                        stack.pop();
                        for (int j = player.motion.length - 1; j >= 0; j--) {
                            stack.push(player.motion[j]);
                        }
                        explore(player, x, y, stack);
                    }
//                    explore(player, x, y, stack);
                }
                else {
                    stack.pop();
//                    explore(player, x, y, stack);
                }
//                explore(player, x, y, stack);
            }
            else if (stack.top.data.toString().equalsIgnoreCase("DOWN")) {
                if (y != 0) {
                    y = y - 1;
                    if (maze[x][y] == 1) {
                        maze[x][y] = 9; 
                        if (counterBehind == 9) {
                            counterFront++;
                            counterBehind = 0;
                        }
                        stack.pop();
                        counterBehind++;
                        for (int j = player.motion.length - 1; j >= 0; j--) {
                            stack.push(player.motion[j]);
                        }
                        explore(player, x, y, stack);
                    }
                    else if (maze[x][y] == 0) {
                        for (int i = 0; i < x; i++) {
                            if (maze[i][y] == 1) {
                                x = i;
                                maze[x][y] = 9;
                            }
                        }
                        stack.pop();
                        for (int j = player.motion.length - 1; j >= 0; j--) {
                            stack.push(player.motion[j]);
                        }
                        explore(player, x, y, stack);
                    }
                    else if (maze[x][y] == 9) {
                        for (int i = 0; i < x; i++) {
                            if (maze[i][y] == 1) {
                                x = i;
                                maze[x][y] = 9;
                            }
                        }
                        stack.pop();
                        for (int j = player.motion.length - 1; j >= 0; j--) {
                            stack.push(player.motion[j]);
                        }
                        explore(player, x, y, stack);
                    }
//                    explore(player, x, y, stack);
                }
                else {
                    stack.pop();
//                    explore(player, x, y, stack);
                }
//                explore(player, x, y, stack);
            }
            else if (stack.top.data.toString().equalsIgnoreCase("RIGHT")) {
                if (x != maze.length - 1) {
                    x = x + 1;
                    if (maze[x][y] == 1) {
                        maze[x][y] = 9;
                        if (counterBehind == 9) {
                            counterFront++;
                            counterBehind = 0;
                        }
                        stack.pop();
                        counterBehind++;
                        for (int j = player.motion.length - 1; j >= 0; j--) {
                            stack.push(player.motion[j]);
                        }
                        explore(player, x, y, stack);
                    }
                    else if (maze[x][y] == 0) {
                        for (int i = 0; i < y; i++) {
                            if (maze[x][i] == 1) {
                                y = i;
                                maze[x][y] = 9;
                            }
                        }
                        stack.pop();
                        for (int j = player.motion.length - 1; j >= 0; j--) {
                            stack.push(player.motion[j]);
                        }
                        explore(player, x, y, stack);
                    }
                    else if (maze[x][y] == 9) {
                        for (int i = 0; i < y; i++) {
                            if (maze[x][i] == 1) {
                                y = i;
                                maze[x][y] = 9;
                            }
                        }
                        stack.pop();
                        for (int j = player.motion.length - 1; j >= 0; j--) {
                            stack.push(player.motion[j]);
                        }
                        explore(player, x, y, stack);
                    }
//                    explore(player, x, y, stack);
                }
                else {
                    stack.pop();
//                    explore(player, x, y, stack);
                }
//                explore(player, x, y, stack);
            }
            else if (stack.top.data.toString().equalsIgnoreCase("LEFT")) {
                if (x != 0) {
                    x = x - 1;
                    if (maze[x][y] == 1) {
                        maze[x][y] = 9;
                        if (counterBehind == 9) {
                            counterFront++;
                            counterBehind = 0;
                        }
                        stack.pop();
                        counterBehind++;
                        for (int j = player.motion.length - 1; j >= 0; j--) {
                            stack.push(player.motion[j]);
                        }
                        explore(player, x, y, stack);
                    }
                    else if (maze[x][y] == 0) {
                        for (int i = 0; i < y; i++) {
                            if (maze[x][i] == 1) {
                                y = i;
                                maze[x][y] = 9;
                            }
                        }
                        stack.pop();
                        for (int j = player.motion.length - 1; j >= 0; j--) {
                            stack.push(player.motion[j]);
                        }
                        explore(player, x, y, stack);
                    }
                    else if (maze[x][y] == 9) {
                        for (int i = 0; i < y; i++) {
                            if (maze[x][i] == 1) {
                                y = i;
                                maze[x][y] = 9;
                            }
                        }
                        stack.pop();
                        for (int j = player.motion.length - 1; j >= 0; j--) {
                            stack.push(player.motion[j]);
                        }
                        explore(player, x, y, stack);
                    }
//                    explore(player, x, y, stack);
                }
                else {
                    stack.pop();
//                    explore(player, x, y, stack);
                }
//                explore(player, x, y, stack);
            }
//            explore(player, x, y, stack);
        }
    }
    
    public void play() {
        Scanner masuk = new Scanner(System.in);
        int numberOfPlayer = masuk.nextInt();
        players = new Player[numberOfPlayer];
        StackDLL stack[] = new StackDLL[numberOfPlayer];
        for (int i = 0; i < players.length; i++) {
            masuk.nextLine();
            players[i] = new Player(masuk.next(), area);
            stack[i] = new StackDLL();
            for (int j = 0; j < players[i].motion.length; j++) {
                players[i].motion[j] = masuk.next();
            }
            for (int j = players[i].motion.length - 1; j >= 0; j--) {
                stack[i].push(players[i].motion[j]);
                
            }
            explore(players[i], start.x, start.y, stack[i]);
            printMaze(players[i]);
//            printMaze();
        }
    }
}

public class Tester {

    public static void main(String[] args) {
        Scanner masuk = new Scanner (System.in);
        Triwizart game = new Triwizart();
        int area = masuk.nextInt(); masuk.nextLine();
        game.makeMaze(area, masuk.nextLine());
        game.printMaze();
        System.out.println("=============");
        game.play();
//        System.out.println("=============");
//        game.printMaze();
    }
}
