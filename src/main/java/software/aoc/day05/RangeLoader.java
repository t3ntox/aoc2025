package software.aoc.day05;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class RangeLoader implements Loader<IdRange>{
    private final String ids;

    public RangeLoader(String ids) {
        this.ids = ids;
    }

    @Override
    public Stream<IdRange>loadAll() {
        return toRange(getClass().getResourceAsStream(ids));
    }

    private Stream<IdRange> toRange(InputStream resourceAsStream) {
        return toRange(new InputStreamReader(resourceAsStream));
    }

    private Stream<IdRange> toRange(InputStreamReader inputStreamReader) {
        return toRange(new BufferedReader(inputStreamReader));
    }

    private Stream<IdRange> toRange(BufferedReader bufferedReader) {
        return bufferedReader.lines().filter(l -> l.matches("^\\d+-\\d+$") && !(l.isEmpty()))
                .map(this::toRange);
    }

    private IdRange toRange(String l) {
        String[] limits = l.split("-");
        return new IdRange(Long.parseLong(limits[1]), Long.parseLong(limits[0]));
    }
}
