import org.junit.Test;
import software.aoc.day12.*;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class Day12Test {

    @Test
    public void should_allow_create_new_Region() {
        assertThat(new Region(1,1, new ArrayList<>()).area())
                .isEqualTo(1);
    }

    @Test
    public void should_allow_create_new_Present() {
        assertThat(new Present(1, new ArrayList<>()).area())
                .isEqualTo(0);
    }

    @Test
    public void should_fill_region_correctly_for_example_input() {
        Situation situation = new SituationLoader("/Day12BasicTest.txt").loadAll();
        assertThat(situation.regions().stream()
                .mapToInt(r -> new RegionFiller(situation.presents(), r).canFill())
                .sum())
                .isEqualTo(2);
    }

    @Test
    public void should_fill_region_correctly_for_puzzle_input() {
        Situation situation = new SituationLoader("/Day12Regions.txt").loadAll();
        assertThat(situation.regions().stream()
                .mapToInt(r -> new RegionFiller(situation.presents(), r).canFill())
                .sum())
                .isEqualTo(569);
    }
}
