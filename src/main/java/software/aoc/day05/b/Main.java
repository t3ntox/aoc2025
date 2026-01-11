package software.aoc.day05.b;


import software.aoc.day05.RangeLoader;
import software.aoc.day05.RangeUnifier;

public class Main {
    public static void main(String[] args) {
        String path = "/Day05Range&Id.txt";
        Long nIds = new RangeUnifier(new RangeLoader(path)).unifiedRanges()
                .mapToLong(r -> r.top() - r.bottom() + 1).sum();
        System.out.println(nIds);

    }
}
