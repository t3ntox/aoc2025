import org.junit.Test;
import software.aoc.day12.RegionFiller;
import software.aoc.day12.Situation;
import software.aoc.day12.SituationLoader;

import static org.assertj.core.api.Assertions.assertThat;

public class Day12Test {
    @Test
    public void should_solve_correctly() {
        Situation situation = new SituationLoader("/Day12BasicTest.txt").loadAll();
        assertThat(situation.regions().stream()
                .mapToInt(r -> new RegionFiller(situation.presents(), r).canFill())
                .sum())
                .isEqualTo(2);
    }

    @Test
    public void should_solve_final_test() {
        Situation situation = new SituationLoader("/Day12Regions.txt").loadAll();
        assertThat(situation.regions().stream()
                .mapToInt(r -> new RegionFiller(situation.presents(), r).canFill())
                .sum())
                .isEqualTo(569);
    }
}
