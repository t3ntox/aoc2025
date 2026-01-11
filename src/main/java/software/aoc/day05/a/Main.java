package software.aoc.day05.a;


import software.aoc.day05.IdRange;
import software.aoc.day05.RangeLoader;
import software.aoc.day05.RangeUnifier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String path = "/Day05Range&Id.txt";
        List<IdRange> ranges = new RangeUnifier(new RangeLoader(path)).unifiedRanges().toList();
        List<Long> ids = new IdLoader(path).loadAll()
                .filter(id -> ranges.stream().anyMatch(r -> r.isValid(id)))
                .toList();
        System.out.println(ids.size());
    }
}
