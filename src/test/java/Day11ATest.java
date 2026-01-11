import org.junit.Test;
import software.aoc.day11.PathCounter;
import software.aoc.day11.TagLoader;

import static org.assertj.core.api.Assertions.assertThat;

public class Day11ATest {
    @Test
    public void should_solve_correctly() {
        assertThat(new PathCounter(new TagLoader("/Day11ABasicTest.txt").loadAll()).countAllPathsFrom("you"))
                .isEqualTo(5L);
    }

    @Test
    public void should_solve_final_test() {
        assertThat(new PathCounter(new TagLoader("/Day11Tags.txt").loadAll()).countAllPathsFrom("you"))
                .isEqualTo(431L);
    }
}
