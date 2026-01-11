package software.aoc.day06;

import java.util.List;
import java.util.stream.Stream;

public interface OperationParser {
    Stream<Operation> parse(List<String> lines);
}
