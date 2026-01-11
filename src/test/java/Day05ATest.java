import org.junit.Test;
import software.aoc.day05.RangeUnifier;
import software.aoc.day05.a.IdLoader;
import software.aoc.day05.IdRange;
import software.aoc.day05.RangeLoader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Day05ATest {

    @Test
    public void should_find_valid_ids() {
        String path = "/Day05BasicTest.txt";
        List<IdRange> ranges = new RangeUnifier(new RangeLoader(path)).unifiedRanges().toList();
        List<Long> ids = new IdLoader(path).loadAll()
                .filter(id -> ranges.stream().anyMatch(r -> r.isValid(id)))
                .toList();
        assertThat(ids.size()).isEqualTo(3);
    }


    @Test
    public void should_find_all_valids_ids() {
        String path = "/Day05Range&Id.txt";
        List<IdRange> ranges = new RangeUnifier(new RangeLoader(path)).unifiedRanges().toList();
        List<Long> ids = new IdLoader(path).loadAll()
                .filter(id -> ranges.stream().anyMatch(r -> r.isValid(id)))
                .toList();
        assertThat(ids.size()).isEqualTo(525);
    }
}
