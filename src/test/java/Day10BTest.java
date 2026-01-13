import org.junit.Test;
import software.aoc.day10.MachineLoader;
import software.aoc.day10.b.JoltageTester;

import static org.assertj.core.api.Assertions.assertThat;

public class Day10BTest {
    @Test
    public void should_affect_joltages_correctly_for_example_input() {
        assertThat(new MachineLoader("/Day10BasicTest.txt").loadAll()
                .map( m -> new JoltageTester(m).solve())
                .mapToLong(Long::longValue)
                .sum()
        ).isEqualTo(33L);
    }

    @Test
    public void should_affect_joltages_correctly_for_puzzle_input() {
        assertThat(new MachineLoader("/Day10Lights.txt").loadAll()
                .map( m -> new JoltageTester(m).solve())
                .mapToLong(Long::longValue)
                .sum()
        ).isEqualTo(14999L);
    }
}
