import org.junit.Test;
import software.aoc.day06.OperationLoader;
import software.aoc.day06.Operator;
import software.aoc.day06.b.ReverseOperationParser;

import static org.assertj.core.api.Assertions.assertThat;

public class Day06BTest {
    @Test
    public void should_solve_correctly() {
        assertThat(new Operator(new OperationLoader("/Day06BasicTest.txt", new ReverseOperationParser()).loadAll()).solve())
                .isEqualTo(3263827L);
    }

    @Test
    public void should_pass_final_test() {
        assertThat(new Operator(new OperationLoader("/Day06Operations.txt", new ReverseOperationParser()).loadAll()).solve())
                .isEqualTo(9695042567249L);
    }
}
