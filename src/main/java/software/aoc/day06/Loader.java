package software.aoc.day06;

import java.util.stream.Stream;

public interface Loader {
    Stream<Operation> loadAll();
}
