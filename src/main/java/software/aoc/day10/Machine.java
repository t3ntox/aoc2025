package software.aoc.day10;

import java.util.Arrays;
import java.util.List;

public record Machine(char[] lightDiagram, List<Button> buttons, List<Integer> joltages) {

    @Override
    public char[] lightDiagram() {
        return Arrays.copyOf(lightDiagram, lightDiagram.length);
    }
}
