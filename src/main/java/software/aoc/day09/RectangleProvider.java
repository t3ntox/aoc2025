package software.aoc.day09;


import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RectangleProvider {
    private final List<Point> points;
    private final int pointCount;

    public RectangleProvider(List<Point> points) {
        this.points = points;
        this.pointCount = points.size();
    }

    public Stream<Rectangle> rectangles() {
        return IntStream.range(0, pointCount)
                .mapToObj(i -> IntStream.range(i + 1, pointCount)
                        .mapToObj(j -> new Rectangle(points.get(i), points.get(j))))
                .flatMap(r -> r);
    }
}
