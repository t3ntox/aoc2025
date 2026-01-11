package software.aoc.day12;

import java.util.List;

public class RegionFiller {
    private final List<Present> presents;
    private final Region region;

    public RegionFiller(List<Present> presents, Region region) {
        this.presents = presents;
        this.region = region;
    }

    public int canFill() {
        return new RegionValidator(presents, region).isValid() ? 1 : 0;
    }
}