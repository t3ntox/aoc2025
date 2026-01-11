package software.aoc.day05.a;

import software.aoc.day05.Loader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class IdLoader implements Loader<Long> {
    private final String ids;

    public IdLoader(String ids) {
        this.ids = ids;
    }

    @Override
    public Stream<Long> loadAll() {
        return toIds(getClass().getResourceAsStream(ids));
    }

    private Stream<Long> toIds(InputStream resourceAsStream) {
        return toIds(new InputStreamReader(resourceAsStream));
    }

    private Stream<Long> toIds(InputStreamReader inputStreamReader) {
        return toIds(new BufferedReader(inputStreamReader));
    }

    private Stream<Long> toIds(BufferedReader bufferedReader) {
        return bufferedReader.lines().filter(l -> !(l.matches("^\\d+-\\d+$")) && !(l.isEmpty()))
                .map(Long::parseLong);
    }
}
