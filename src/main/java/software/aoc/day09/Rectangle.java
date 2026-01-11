package software.aoc.day09;

public record Rectangle(Point p1, Point p2){

    public long area(){
        return height() * width();
    }

    public long height() {
        return Math.abs(p1.y() - p2.y()) + 1;
    }

    public long width() {
        return Math.abs(p1.x() - p2.x()) + 1;
    }

    public int minX() {
        return Math.min(p1.x(), p2.x());
    }

    public int minY() {
        return Math.min(p1.y(), p2.y());
    }
    public int maxX() {
        return Math.max(p1.x(), p2.x());
    }
    public int maxY() {
        return Math.max(p1.y(), p2.y());
    }

    public Point center() {
        return new Point((int) ((minX() + maxX()) / 2.0), (int) ((minY() + maxY()) / 2.0));
    }
}
