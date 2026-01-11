package software.aoc.day10.a;

import software.aoc.day10.MachineLoader;

public class Main {
    static void main() {
        System.out.println(new MachineLoader("/Day10Lights.txt").loadAll()
                .map( m -> new LightTester(m).buttonSequence())
                .mapToLong(Long::longValue)
                .sum());
    }
}
