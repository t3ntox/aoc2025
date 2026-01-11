package software.aoc.day10;


import java.util.stream.Stream;

public interface Loader {
    Stream<Machine> loadAll();
}
