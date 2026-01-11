package software.aoc.day08;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoxConnector {
    private Stream<Circuit> junctionBoxes;

    public BoxConnector(Stream<Circuit> junctionBoxes) {
        this.junctionBoxes = junctionBoxes;
    }

    public List<PairBox> connectAll() {
        return connect(Integer.MAX_VALUE);
    }

    public List<PairBox> connect(int amount) {
        return pairsOf(junctionBoxes.flatMap(c -> c.junctionBoxes().stream()).toList(), amount);
    }

    private List<PairBox> pairsOf(List<Position> pos, int amount) {
        return allPairsFrom(pos)
                .sorted(Comparator.comparingDouble(PairBox::euclideanDistance))
                .limit(amount)
                .toList();
    }

    private Stream<PairBox> allPairsFrom(List<Position> pos) {
        return IntStream.range(0, pos.size())
                .mapToObj(i -> IntStream.range(i + 1, pos.size())
                        .mapToObj(pos::get)
                        .map(box2 -> new PairBox(pos.get(i), box2))
                ).flatMap(p -> p);
    }
}
