import org.junit.Test;
import software.aoc.day10.MachineLoader;
import software.aoc.day10.a.LightTester;

import static org.assertj.core.api.Assertions.assertThat;

public class Day10ATest {
    @Test
    public void should_solve_correctly() {
        assertThat(new MachineLoader("/Day10BasicTest.txt").loadAll()
                .map( m -> new LightTester(m).buttonSequence())
                .mapToLong(Long::longValue)
                .sum()
        ).isEqualTo(7L);
    }

    @Test
    public void should_solve_final_test() {
        assertThat(new MachineLoader("/Day10Lights.txt").loadAll()
                .map( m -> new LightTester(m).buttonSequence())
                .mapToLong(Long::longValue)
                .sum()
        ).isEqualTo(436L);
    }
}
