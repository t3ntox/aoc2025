import org.junit.Test;
import software.aoc.day01.Dial;
import software.aoc.day01.Order;
import software.aoc.day01.OrdersLoader;
import software.aoc.day01.a.SimpleZeroCounter;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01ATest {
    @Test
    public void should_allow_create_new_dial() {
        Dial dial = new Dial(11, new SimpleZeroCounter(),0);
        assertThat(dial.pointedValue()).isEqualTo(11);
    }

    @Test
    public void should_allow_move_dial_given_a_rotation() {
        Dial dial = new Dial(11, new SimpleZeroCounter(),0)
                .rotate(new Order("R8"))
                .rotate(new Order("L19"));
        assertThat(dial.pointedValue()).isEqualTo(0);
    }

    @Test
    public void should_move_correctly_in_edges() {
        Dial dial95 = new Dial(5, new SimpleZeroCounter(),0)
                .rotate(new Order("L10"));
        assertThat(dial95.pointedValue()).isEqualTo(95);
        assertThat(dial95.rotate(new Order("R5")).pointedValue()).isEqualTo(0);
    }

    @Test
    public void should_count_result_zero_correctly_for_example_input() {
        Dial dial0 = new OrdersLoader("/Day01CountZeroTest.txt").loadAll().reduce(
                new Dial(50, new SimpleZeroCounter(),0),
                Dial::rotate,
                (d1, d2) -> d1
        );
        assertThat(dial0.zeroTimes()).isEqualTo(3);
    }

    @Test
    public void should_count_result_zero_correctly_for_puzzle_input() {
        Dial finalDial = new OrdersLoader("/Day01Orders.txt").loadAll().reduce(
                new Dial(50, new SimpleZeroCounter(),0),
                Dial::rotate,
                (d1, d2) -> d1
        );
        assertThat(finalDial.zeroTimes()).isEqualTo(1007);
    }
}
