import org.junit.Test;
import software.aoc.day05.RangeLoader;
import software.aoc.day05.RangeUnifier;


import static org.assertj.core.api.Assertions.assertThat;

public class Day05BTest {
    @Test
    public void should_find_possible_ids_for_example_input() {
        Long nIds = new RangeUnifier(new RangeLoader("/Day05BasicTest.txt")).unifiedRanges()
                .mapToLong(r -> r.top() - r.bottom() + 1).sum();
        assertThat(nIds).isEqualTo(14L);
    }


    @Test
    public void should_find_possible_ids_for_puzzle_input() {
        Long nIds = new RangeUnifier(new RangeLoader("/Day05Range&Id.txt")).unifiedRanges()
                .mapToLong(r -> r.top() - r.bottom() + 1).sum();
        assertThat(nIds).isEqualTo(333892124923577L);
    }
}
