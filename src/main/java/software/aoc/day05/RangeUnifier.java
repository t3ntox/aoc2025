package software.aoc.day05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class RangeUnifier {
    private final Loader<IdRange> loader;

    public RangeUnifier(Loader<IdRange> loader) {
        this.loader = loader;
    }

    public Stream<IdRange> unifiedRanges() {
        return rangesFrom(loader.loadAll().sorted(Comparator.comparingLong(IdRange::bottom)));
    }

    private Stream<IdRange> rangesFrom(Stream<IdRange> idRangeStream) {
        return rangesFrom(idRangeStream.toList());
    }

    private Stream<IdRange> rangesFrom(List<IdRange> list) {
        List<IdRange> newRanges = new ArrayList<>();

        IdRange current = list.getFirst();

        for (int i = 1; i < list.size(); i++) {
            IdRange next = list.get(i);
            if (next.bottom() <= current.top()) {
                // Solapan → fusionar ampliando el fin
                current = new IdRange(Math.max(current.top(), next.top()), current.bottom());
            } else {
                // No solapan → guardar el actual y empezar uno nuevo
                newRanges.add(current);
                current = next;
            }
        }
        newRanges.add(current);

        return newRanges.stream();
    }
}
