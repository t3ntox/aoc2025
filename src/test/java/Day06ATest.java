import org.junit.Test;
import software.aoc.day06.Operation;
import software.aoc.day06.OperationLoader;
import software.aoc.day06.Operator;
import software.aoc.day06.a.StandardOperationParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Day06ATest {

    @Test
    public void should_allow_create_new_Operation() {
        assertThat(new Operation(new String[]{"2", "2"}, "+").operands())
                .isEqualTo(new String[]{"2", "2"});
    }

    @Test
    public void should_allow_create_new_Operator() {
        assertThat(new Operator(Stream.of(new Operation(new String[]{"2", "2"}, "+"))).solve())
                .isEqualTo(4L);
    }

    @Test
    public void should_load_operations() {
        assertThat(new OperationLoader("/Day06BasicTest.txt", new StandardOperationParser()).loadAll().toList())
                .isNotEmpty();
    }

    @Test
    public void should_solve_correctly_for_example_input() {
        assertThat(new Operator(new OperationLoader("/Day06BasicTest.txt", new StandardOperationParser()).loadAll()).solve())
                .isEqualTo(4277556L);
    }

    @Test
    public void should_solve_correctly_for_puzzle_input() {
        assertThat(new Operator(new OperationLoader("/Day06Operations.txt", new StandardOperationParser()).loadAll()).solve())
                .isEqualTo(5060053676136L);
    }
}
