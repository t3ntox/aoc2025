package software.aoc.day06.a;

import software.aoc.day06.Operation;
import software.aoc.day06.OperationFinder;
import software.aoc.day06.OperationParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StandardOperationParser implements OperationParser {
    @Override
    public Stream<Operation> parse(List<String> lines) {
        return OperationFinder.toColumns(lines.stream()
                .map(l -> OperationFinder.findProblems(l, lines.getLast()))
                .toList()
        ).stream()
                .map(c -> new Operation(Arrays.copyOf(c, c.length - 1), c[c.length - 1]));
    }
}
