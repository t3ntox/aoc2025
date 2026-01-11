package software.aoc.day10.b;

import software.aoc.day10.MachineLoader;

public class Main {
    static void main() {
        System.out.println(new MachineLoader("/Day10Lights.txt").loadAll()
                .map( m -> new JoltageTester(m).solve())
                .mapToLong(Long::longValue)
                .sum());
    }
}
