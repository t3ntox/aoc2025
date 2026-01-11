package software.aoc.day10.a;


import software.aoc.day10.Button;
import software.aoc.day10.Machine;

import java.util.*;


public class LightTester {
    private final Machine machine;
    private final Map<String, Long> mem = new HashMap<>();

    public LightTester(Machine machine) {
        this.machine = machine;
    }

    public long buttonSequence() {
        char[] finalLights = machine.lightDiagram();
        return buttonSequence(0, finalLights, machine.buttons(), startLights(finalLights));
    }

    private char[] startLights(char[] l) {
        char[] res = new char[l.length];
        Arrays.fill(res, '.');
        return res;
    }

    public long buttonSequence(int start, char[] goal, List<Button> buttons, char[] startLight) {
        String key = start + "|" + Arrays.toString(startLight);
        if (Arrays.equals(startLight, goal)) return 0L;
        if (start == buttons.size()) return 10_000_000;
        if (mem.containsKey(key)) return mem.get(key);

        mem.put(key, Math.min(
                buttonSequence(start + 1, goal, buttons, startLight),
                pressBtn(goal, buttons, start, startLight))
        );

        return mem.get(key);
    }

    private long pressBtn(char[] goal, List<Button> buttons, int pointer, char[] startLight) {
        return 1L + buttonSequence(pointer + 1, goal, buttons, buttons.get(pointer).pressLight(startLight));
    }
}
