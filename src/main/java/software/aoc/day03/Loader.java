package software.aoc.day03;

import java.util.stream.Stream;

public interface Loader {
    Stream<Bank> loadAll();
}
