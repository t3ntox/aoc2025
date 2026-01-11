package software.aoc.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TachyonManifold {
    private final List<List<Character>> manifold;

    private TachyonManifold(List<List<Character>> add) {
        this.manifold = add;
    }

    public static TachyonManifold empty() {
        return new TachyonManifold(new ArrayList<>());
    }


    public TachyonManifold with(List<Character> level) {
        return new TachyonManifold(Stream.concat(manifold.stream(), Stream.<List<Character>>of(level)).toList());
    }

    public List<List<Character>> manifold() {
        return new ArrayList<>(manifold);
    }
}
