package software.aoc.day06;

import java.util.Arrays;
import java.util.stream.Stream;

public class Operator {
    private final Stream<Operation> operations;

    public Operator(Stream<Operation> operation) {
        this.operations = operation;
    }

    public long solve() {
        return operations.mapToLong(this::result).sum();
    }

    private long result(Operation o) {
        return o.operator().trim().equals("+") ? add(o.operands()) : multiply(o.operands());
    }

    private long multiply(String[] problem) {
        return Arrays.stream(problem).mapToLong(n -> Long.parseLong(n.trim()))
                .reduce(1L, (mult, n) -> mult * n);
    }

    private long add(String[] problem) {
        return Arrays.stream(problem).mapToLong(n -> Long.parseLong(n.trim()))
                .sum();
    }
}

