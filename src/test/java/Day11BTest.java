import org.junit.Test;
import software.aoc.day11.GraphLoader;
import software.aoc.day11.PathCounter;

import static org.assertj.core.api.Assertions.assertThat;

public class Day11BTest {
    @Test
    public void should_find_specific_path_for_example_input() {
        assertThat(new PathCounter(new GraphLoader("/Day11BBasicTest.txt").loadAll()).countWithDacAndFftFrom("svr"))
                .isEqualTo(2L);
    }

    @Test
    public void should_find_specific_path_for_puzzle_input() {
        assertThat(new PathCounter(new GraphLoader("/Day11Tags.txt").loadAll()).countWithDacAndFftFrom("svr"))
                .isEqualTo(358458157650450L);
    }
}
