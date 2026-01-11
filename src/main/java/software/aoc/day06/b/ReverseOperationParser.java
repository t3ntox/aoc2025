package software.aoc.day06.b;

import software.aoc.day06.Operation;
import software.aoc.day06.OperationFinder;
import software.aoc.day06.OperationParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseOperationParser implements OperationParser {

    @Override
    public Stream<Operation> parse(List<String> lines) {
        return OperationFinder.toColumns(lines.stream()
                        .map(l-> l.concat(" "))
                        .map(l -> OperationFinder.findProblems(l, lines.getLast()))
                        .toList()
                ).stream()
                .map(l -> readingSubcolumns(Arrays.stream(l).limit(l.length-1).toArray(String[]::new), l[l.length-1]));

    }

    public Operation readingSubcolumns(String[] numbers, String operation) {
        String[] problem = reBuildNumbers(Arrays.stream(numbers).mapToInt(String::length).max().orElse(0), numbers, operation);
        return new Operation(Arrays.copyOf(problem, problem.length - 1), problem[problem.length - 1]);
    }

    private String[] reBuildNumbers(int maxLen, String[] numbers, String operation) {
        return Stream.concat(
                        IntStream.range(0, maxLen)
                                .mapToObj(i -> {
                                    StringBuilder sb = new StringBuilder();
                                    for (String n : numbers) {
                                        int idx = n.length() - 1 - i;
                                        if (idx >= 0) {
                                            sb.append(n.charAt(idx));
                                        }
                                    }
                                    return sb.toString();
                                })
                                .filter(s -> !s.trim().isEmpty()),
                        Stream.of(operation))
                .toArray(String[]::new);
    }
}
