import org.junit.Test;
import software.aoc.day07.TachyonLoader;
import software.aoc.day07.b.DPBeamStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class Day07BTest {
    @Test
    public void should_find_paths_correctly_for_example_input() {
        assertThat(new DPBeamStrategy(new TachyonLoader("/Day07BasicTest.txt").loadAll()).goAhead())
                .isEqualTo(40);
    }

    @Test
    public void should_find_paths_correctly_for_puzzle_input() {
        assertThat(new DPBeamStrategy(new TachyonLoader("/Day07Taychons.txt").loadAll()).goAhead())
                .isEqualTo(47857642990160L);
    }
}
