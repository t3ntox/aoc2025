package software.aoc.day10;

import java.util.Arrays;
import java.util.List;

public record Button (List<Integer> affectedLights) {

    public char[] pressLight(char[] lights) {
        char[] result = Arrays.copyOf(lights, lights.length);
        for (int idx : affectedLights) {
            result[idx] = result[idx] == '#' ? '.' : '#';
        }
        return result;
    }

    public void pressJoltage(List<Integer> joltages) {
        for (int idx : affectedLights) {
            joltages.set(idx, joltages.get(idx) + 1);
        }
    }
}
