package software.aoc.day02;

import java.util.stream.Stream;

public interface Loader {
    Stream<Range> loadAll();
}
