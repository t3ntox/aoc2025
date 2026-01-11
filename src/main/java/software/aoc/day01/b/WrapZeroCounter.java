package software.aoc.day01.b;

import software.aoc.day01.Order;
import software.aoc.day01.ZeroCounter;

public class WrapZeroCounter implements ZeroCounter {
    @Override
    public int countZeros(int start, Order order, int end) {
        return checkFullWraps(order.value()) + checkRemainWrap(start, order.getSteps(), end);
    }

    private int checkFullWraps(int order) {
        return order / 100;
    }

    private int checkRemainWrap(int start, int order, int endPosition) {
        int move = (order % 100);
        if (move == 0 || start == 0) return 0;
        if (move > 0 && start > endPosition) return 1;
        if (move < 0 && endPosition > start) return 1;
        if (endPosition == 0) return 1;
        return 0;
    }
}
