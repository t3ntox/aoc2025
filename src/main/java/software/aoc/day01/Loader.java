package software.aoc.day01;

import java.util.stream.Stream;

public interface Loader {
    Stream<Order> loadAll();
}
