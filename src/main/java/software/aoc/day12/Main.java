package software.aoc.day12;

public class Main {
    static void main() {
        Situation situation = new SituationLoader("/Day12Regions.txt").loadAll();
        int count = situation.regions().stream()
                        .mapToInt(r -> new RegionFiller(situation.presents(), r).canFill())
                        .sum();
        System.out.println(count);
    }
}
