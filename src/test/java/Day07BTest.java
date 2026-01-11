import org.junit.Test;
import software.aoc.day07.TachyonLoader;
import software.aoc.day07.b.DPBeamStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class Day07BTest {
    @Test
    public void should_solve_correctly() {
        assertThat(new DPBeamStrategy(new TachyonLoader("/Day07BasicTest.txt").loadAll()).goAhead())
                .isEqualTo(40);
    }

    @Test
    public void should_solve_final_test() {
        assertThat(new DPBeamStrategy(new TachyonLoader("/Day07Taychons.txt").loadAll()).goAhead())
                .isEqualTo(47857642990160L);
    }
}
