package software.aoc.day01.a;

import software.aoc.day01.Order;
import software.aoc.day01.ZeroCounter;

public class SimpleZeroCounter implements ZeroCounter {
    @Override
    public int countZeros(int start, Order order, int end) {
        return end == 0 ? 1 : 0;
    }
}
