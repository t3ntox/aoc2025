package software.aoc.day07;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TachyonLoader implements Loader {
    private final String tachyons;

    public TachyonLoader(String tachyons) {
        this.tachyons = tachyons;
    }

    @Override
    public TachyonManifold loadAll() {
        return toManifold(getClass().getResourceAsStream(tachyons));
    }

    private TachyonManifold toManifold(InputStream resourceAsStream) {
        return toManifold(new InputStreamReader(resourceAsStream));
    }

    private TachyonManifold toManifold(InputStreamReader inputStreamReader) {
        return toManifold(new BufferedReader(inputStreamReader));
    }

    private TachyonManifold toManifold(BufferedReader bufferedReader) {
        return bufferedReader.lines()
                .map(l -> l.chars()
                        .mapToObj(c -> (char) c)
                        .toList())
                .reduce(TachyonManifold.empty(),
                        TachyonManifold::with,
                        (d1, d2) -> d1
                );
    }
}
