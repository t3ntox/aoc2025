package software.aoc.day05;

import java.util.stream.Stream;

public interface Loader<T> {
    Stream<T> loadAll();
}
