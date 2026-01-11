package software.aoc.day08;


import java.util.stream.Stream;

public interface Loader {
    Stream<Circuit> loadAll();
}
