package software.aoc.day09;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class PointLoader implements Loader {
    private final String points;

    public PointLoader(String positions) {
        this.points = positions;
    }

    @Override
    public Stream<Point> loadAll() {
        return toPoint(getClass().getResourceAsStream(points));
    }

    private Stream<Point> toPoint(InputStream resourceAsStream) {
        return toPoint(new InputStreamReader(resourceAsStream));
    }

    private Stream<Point> toPoint(InputStreamReader inputStreamReader) {
        return toPoint(new BufferedReader(inputStreamReader));
    }

    private Stream<Point> toPoint(BufferedReader bufferedReader) {
        return bufferedReader.lines()
                .map(l -> {
                    String[] coords = l.split(",");
                    return new Point(toInt(coords[0]),
                            toInt(coords[1]));

                });
    }

    private int toInt(String coord) {
        return Integer.parseInt(coord);
    }
}
