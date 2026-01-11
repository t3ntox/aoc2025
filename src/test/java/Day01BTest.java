import org.junit.Test;
import software.aoc.day01.Dial;
import software.aoc.day01.Order;
import software.aoc.day01.OrdersLoader;
import software.aoc.day01.b.WrapZeroCounter;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01BTest {

    @Test
    public void count_zeros_correctly() {
        Dial dial0 = new OrdersLoader("/Day01CountZeroTest.txt").loadAll().reduce(
                new Dial(50, new WrapZeroCounter(), 0),
                Dial::rotate,
                (d1, d2) -> d1
        );
        assertThat(dial0.zeroTimes()).isEqualTo(6);
        Dial dial96 = new Dial(50, new WrapZeroCounter(),0)
                .rotate(new Order("L50"));
        assertThat(dial96.zeroTimes()).isEqualTo(1);
    }

    @Test
    public void count_zeros_correctly_with_big_rotation() {
        Dial dial95 = new Dial(50, new WrapZeroCounter(),0)
                .rotate(new Order("L1050"));
        assertThat(dial95.zeroTimes()).isEqualTo(11);
    }

    @Test
    public void final_test() {
        Dial finalDial = new OrdersLoader("/Day01Orders.txt").loadAll().reduce(
                new Dial(50, new WrapZeroCounter(),0),
                Dial::rotate,
                (d1, d2) -> d2
        );
        assertThat(finalDial.zeroTimes()).isEqualTo(5820);
    }
}
