package software.aoc.day06;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class OperationLoader implements Loader {
    private final String operation;
    private final OperationParser parser;

    public OperationLoader(String operation, OperationParser parser) {
        this.operation = operation;
        this.parser = parser;
    }

    @Override
    public Stream<Operation> loadAll() {
        return toOperation(getClass().getResourceAsStream(operation));
    }

    private Stream<Operation> toOperation(InputStream resourceAsStream) {
        return toOperation(new InputStreamReader(resourceAsStream));
    }

    private Stream<Operation> toOperation(InputStreamReader inputStreamReader) {
        return toOperation(new BufferedReader(inputStreamReader));
    }

    private Stream<Operation> toOperation(BufferedReader bufferedReader) {
        return parser.parse(bufferedReader.lines().toList());
    }
}


