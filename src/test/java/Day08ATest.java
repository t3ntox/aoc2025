import org.junit.Test;
import software.aoc.day08.BoxConnector;
import software.aoc.day08.Circuit;
import software.aoc.day08.CircuitConnector;
import software.aoc.day08.CircuitLoader;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day08ATest {
    @Test
    public void should_solve_correctly() {
        List<Circuit> circuits = new CircuitLoader("/Day08BasicTest.txt").loadAll().toList();
        assertThat(new CircuitConnector(new BoxConnector(circuits.stream()).connect(10), circuits).toCircuit().stream().limit(3).mapToLong(Circuit::size)
                .reduce(1L, (acc, s) -> acc*s))
                .isEqualTo(40);
    }

    @Test
    public void should_solve_final_test() {
        List<Circuit> circuits = new CircuitLoader("/Day08Boxes.txt").loadAll().toList();
        assertThat(new CircuitConnector(new BoxConnector(circuits.stream())
                .connect(1000), circuits)
                .toCircuit().stream().limit(3)
                .mapToLong(Circuit::size).reduce(1L, (acc, s) -> acc*s))
                .isEqualTo(181584);
    }
}
