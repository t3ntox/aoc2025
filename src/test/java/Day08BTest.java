import org.junit.Test;
import software.aoc.day08.BoxConnector;
import software.aoc.day08.Circuit;
import software.aoc.day08.CircuitConnector;
import software.aoc.day08.CircuitLoader;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day08BTest {
    @Test
    public void should_solve_correctly() {
        List<Circuit> circuits = new CircuitLoader("/Day08BasicTest.txt").loadAll().toList();
        assertThat(new CircuitConnector(new BoxConnector(circuits.stream()).connectAll(), circuits).toCableExtension())
                .isEqualTo(25272L);
    }

    @Test
    public void should_solve_final_test() {
        List<Circuit> circuits = new CircuitLoader("/Day08Boxes.txt").loadAll().toList();
        assertThat(new CircuitConnector(new BoxConnector(circuits.stream())
                .connectAll(), circuits)
                .toCableExtension())
                .isEqualTo(8465902405L);
    }
}
