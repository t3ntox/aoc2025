import org.junit.Test;
import software.aoc.day07.a.BFSBeamStrategy;
import software.aoc.day07.TachyonLoader;

import static org.assertj.core.api.Assertions.assertThat;

public class Day07ATest {
    @Test
    public void should_solve_correctly() {
        assertThat(new BFSBeamStrategy(new TachyonLoader("/Day07BasicTest.txt").loadAll()).goAhead())
                .isEqualTo(21);
    }

    @Test
    public void should_solve_final_test() {
        assertThat(new BFSBeamStrategy(new TachyonLoader("/Day07Taychons.txt").loadAll()).goAhead())
                .isEqualTo(1630);
    }
}
