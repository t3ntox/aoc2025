import org.junit.Test;
import software.aoc.day11.PathCounter;
import software.aoc.day11.TagLoader;

import static org.assertj.core.api.Assertions.assertThat;

public class Day11BTest {
    @Test
    public void should_solve_correctly() {
        assertThat(new PathCounter(new TagLoader("/Day11BBasicTest.txt").loadAll()).countWithDacAndFftFrom("svr"))
                .isEqualTo(2L);
    }

    @Test
    public void should_solve_final_test() {
        assertThat(new PathCounter(new TagLoader("/Day11Tags.txt").loadAll()).countWithDacAndFftFrom("svr"))
                .isEqualTo(358458157650450L);
    }
}
