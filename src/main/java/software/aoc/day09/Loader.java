package software.aoc.day09;



import java.util.stream.Stream;

public interface Loader {
    Stream<Point> loadAll();
}
