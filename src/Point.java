public class Point extends java.awt.Point {

    public Point(Point point) {
        super(point);
    }

    public Point(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "("+ x +","+ y +")";
    }
}
