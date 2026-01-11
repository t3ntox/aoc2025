package software.aoc.day09;


import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class AreaCalculator {
    private final RectangleProvider rectangleProvider;
    private final List<Point> points;
    private final int pointCount;

    public AreaCalculator(RectangleProvider rectangleProvider, List<Point> points) {
        this.rectangleProvider = rectangleProvider;
        this.points = points;
        this.pointCount = points.size();
    }

    public long maxAreaFromPoints() {
        return rectangleProvider.rectangles().max(Comparator.comparingLong(Rectangle::area))
                .orElse(new Rectangle(new Point(0,0), new Point(0,0)))
                .area();
    }

    public long findLargestValidRectangleArea() {
        return rectangleProvider.rectangles()
                .filter(r -> r.width() != 1)
                .filter(r -> r.height() != 1)
                .filter(this::isValidRectangle)
                .map(Rectangle::area)
                .mapToLong(Long::longValue)
                .max()
                .orElse(0L);
    }

    private boolean isValidRectangle(Rectangle r) {
        return !(boundaryCrossesInterior(r) ||
                !isPointInPolygon(r.center()));
    }

    private boolean boundaryCrossesInterior(Rectangle r) {
        return IntStream.range(0, pointCount)
                .anyMatch(i -> isCrossingRectangleY(points.get(i), points.get((i + 1) % pointCount), r) ||
                        isCrossingRectangleX(points.get(i), points.get((i + 1) % pointCount), r));
    }

    private boolean isCrossingRectangleY(Point p1, Point p2, Rectangle r) {
        if (p1.y() != p2.y()) return false;
        if (p1.y() <= r.minY() || p1.y() >= r.maxY()) return false;
        return Math.max(Math.min(p1.x(), p2.x()), r.minX()) < Math.min(Math.max(p1.x(), p2.x()), r.maxX());
    }

    private boolean isCrossingRectangleX(Point p1, Point p2, Rectangle r) {
        if (p1.x() != p2.x()) return false;
        if (p1.x() <= r.minX() || p1.x() >= r.maxX()) return false;
        return Math.max(Math.min(p1.y(), p2.y()), r.minY()) < Math.min(Math.max(p1.y(), p2.y()), r.maxY());

    }

    private boolean isPointInPolygon(Point center) {
        boolean inside = false;
        for (int i = 0, j = pointCount - 1; i < pointCount; j = i++) {
            Point pi = points.get(i);
            Point pj = points.get(j);

            if ((pi.y() > center.y()) != (pj.y() > center.y()) &&
                    (center.x() < (pj.x() - pi.x()) * (center.y() - pi.y()) / (double)(pj.y() - pi.y()) + pi.x())) {
                inside = !inside;
            }
        }
        return inside;
    }
}
