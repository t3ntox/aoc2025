import org.junit.Test;
import software.aoc.day06.OperationLoader;
import software.aoc.day06.Operator;
import software.aoc.day06.a.StandardOperationParser;

import static org.assertj.core.api.Assertions.assertThat;

public class Day06ATest {
    @Test
    public void should_solve_correctly() {
        assertThat(new Operator(new OperationLoader("/Day06BasicTest.txt", new StandardOperationParser()).loadAll()).solve())
                .isEqualTo(4277556L);
    }

    @Test
    public void should_pass_final_test() {
        assertThat(new Operator(new OperationLoader("/Day06Operations.txt", new StandardOperationParser()).loadAll()).solve())
                .isEqualTo(5060053676136L);
    }
}
