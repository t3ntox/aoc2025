import org.junit.Test;
import software.aoc.day08.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day08ATest {

    @Test
    public void should_allow_create_new_position() {
        Position testPosition = new Position(1,1,1);
        assertThat(testPosition.x()).isEqualTo(1);
        assertThat(testPosition.y()).isEqualTo(1);
        assertThat(testPosition.z()).isEqualTo(1);
    }

    @Test
    public void should_load_circuits() {
        assertThat(new CircuitLoader("/Day08BasicTest.txt").loadAll().toList().getFirst())
                .isInstanceOf(Circuit.class);
    }

    @Test
    public void should_make_circuit_correctly_for_example_input() {
        List<Circuit> circuits = new CircuitLoader("/Day08BasicTest.txt").loadAll().toList();
        assertThat(new CircuitConnector(new BoxConnector(circuits.stream()).connect(10), circuits).toCircuit().stream().limit(3).mapToLong(Circuit::size)
                .reduce(1L, (acc, s) -> acc*s))
                .isEqualTo(40);
    }

    @Test
    public void should_make_circuit_correctly_for_puzzle_input() {
        List<Circuit> circuits = new CircuitLoader("/Day08Boxes.txt").loadAll().toList();
        assertThat(new CircuitConnector(new BoxConnector(circuits.stream())
                .connect(1000), circuits)
                .toCircuit().stream().limit(3)
                .mapToLong(Circuit::size).reduce(1L, (acc, s) -> acc*s))
                .isEqualTo(181584);
    }
}
