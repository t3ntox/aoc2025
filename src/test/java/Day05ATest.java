import org.junit.Test;
import software.aoc.day05.RangeUnifier;
import software.aoc.day05.a.IdLoader;
import software.aoc.day05.IdRange;
import software.aoc.day05.RangeLoader;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day05ATest {

    @Test
    public void should_allow_create_new_IdRange() {
        assertThat(new IdRange(5,0).isValid(3L)).isTrue();
    }

    @Test
    public void should_load_ranges_and_ids_correctly() {
        String path = "/Day05BasicTest.txt";
        List<IdRange> ranges = new RangeUnifier(new RangeLoader(path)).unifiedRanges().toList();
        assertThat(ranges).isNotEmpty();
        List<Long> ids = new IdLoader(path).loadAll()
                .filter(id -> ranges.stream().anyMatch(r -> r.isValid(id)))
                .toList();
        assertThat(ids).isNotEmpty();
    }

    @Test
    public void should_find_valid_ids_for_example_input() {
        String path = "/Day05BasicTest.txt";
        List<IdRange> ranges = new RangeUnifier(new RangeLoader(path)).unifiedRanges().toList();
        List<Long> ids = new IdLoader(path).loadAll()
                .filter(id -> ranges.stream().anyMatch(r -> r.isValid(id)))
                .toList();
        assertThat(ids.size()).isEqualTo(3);
    }


    @Test
    public void should_find_valid_ids_for_puzzle_input() {
        String path = "/Day05Range&Id.txt";
        List<IdRange> ranges = new RangeUnifier(new RangeLoader(path)).unifiedRanges().toList();
        List<Long> ids = new IdLoader(path).loadAll()
                .filter(id -> ranges.stream().anyMatch(r -> r.isValid(id)))
                .toList();
        assertThat(ids.size()).isEqualTo(525);
    }
}
