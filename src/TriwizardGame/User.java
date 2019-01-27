package TriwizardGame;

class User {
    public Stack<Point> path;
    public String name, moveData[] = new String[4];
    public int index = 0;
    public Stack<Point> walkPath;

    public User(String arg, int luas) {
        name = arg;
        path = new Stack<Point>();
        walkPath = new Stack<Point>();
    }

    public void addPath(int x, int y) {
        addPath(new Point(x, y));
    }
    
    public void addPath(Point p) {
        path.push(p);
    }
    
    public void addWalkPath(int x, int y) {
        addWalkPath(new Point(x, y));
    }
    
    public void addWalkPath(Point p) {
        walkPath.push(p);
    }
}