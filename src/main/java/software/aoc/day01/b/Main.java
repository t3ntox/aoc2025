package software.aoc.day01.b;

import software.aoc.day01.Dial;
import software.aoc.day01.OrdersLoader;

public class Main {
    static void main() {
        Dial finalDial = new OrdersLoader("/Day01Orders.txt").loadAll().reduce(
                new Dial(50, new WrapZeroCounter(), 0),
                Dial::rotate,
                (d1, d2) -> d1
        );
        System.out.println(finalDial.zeroTimes());
    }
}
