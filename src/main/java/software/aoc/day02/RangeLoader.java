package software.aoc.day02;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class RangeLoader implements Loader {
    private final String ranges;

    public RangeLoader(String path) {
        this.ranges = path;
    }

    @Override
    public Stream<Range> loadAll() {
        return toRange(getClass().getResourceAsStream(ranges));
    }

    private Stream<Range> toRange(InputStream resourceAsStream) {
        return toRange(new InputStreamReader(resourceAsStream));
    }

    private Stream<Range> toRange(InputStreamReader inputStreamReader) {
        return toRange(new BufferedReader(inputStreamReader));
    }

    private Stream<Range> toRange(BufferedReader bufferedReader) {
        return toRange(bufferedReader.lines().flatMap(line -> Arrays.stream(line.split(","))));
    }

    private Stream<Range> toRange(Stream<String> rList) {
        return rList.map(Range::new);
    }

}
