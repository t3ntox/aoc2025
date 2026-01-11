package software.aoc.day07.a;


import software.aoc.day07.BeamStrategy;
import software.aoc.day07.TachyonManifold;

import java.util.*;

public class BFSBeamStrategy implements BeamStrategy {
    private int split;
    private final List<List<Character>> manifold;

    public BFSBeamStrategy(TachyonManifold tachyonManifold) {
        this.split = 0;
        this.manifold = tachyonManifold.manifold();
    }

    @Override
    public long goAhead() {
        List<Integer> pos = new ArrayList<>();
        pos.add(manifold.getFirst().indexOf('S'));

        for (List<Character> level: manifold) {
            Set<Integer> next = new HashSet<>();
            for (int p: pos) {
                if (level.get(p).equals('^')) {
                    split++;
                    next.add(p+1);
                    next.add(p-1);
                } else {
                    next.add(p);
                }
            }
            pos = next.stream().toList();
        }

        return split;
    }
}
