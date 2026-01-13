import org.junit.Test;
import software.aoc.day10.Button;
import software.aoc.day10.Machine;
import software.aoc.day10.MachineLoader;
import software.aoc.day10.a.LightTester;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day10ATest {

    @Test
    public void should_allow_create_new_Button() {
        assertThat(new Button(List.of(1,3)).affectedLights())
                .contains(1,3);
    }

    @Test
    public void should_load_machines() {
        assertThat(new MachineLoader("/Day10BasicTest.txt").loadAll().toList().getFirst())
                .isInstanceOf(Machine.class);
    }

    @Test
    public void should_affect_lights_correctly_for_example_input() {
        assertThat(new MachineLoader("/Day10BasicTest.txt").loadAll()
                .map( m -> new LightTester(m).buttonSequence())
                .mapToLong(Long::longValue)
                .sum()
        ).isEqualTo(7L);
    }

    @Test
    public void should_affect_lights_correctly_for_puzzle_input() {
        assertThat(new MachineLoader("/Day10Lights.txt").loadAll()
                .map( m -> new LightTester(m).buttonSequence())
                .mapToLong(Long::longValue)
                .sum()
        ).isEqualTo(436L);
    }
}
