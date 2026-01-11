package software.aoc.day08.a;

import software.aoc.day08.BoxConnector;
import software.aoc.day08.Circuit;
import software.aoc.day08.CircuitConnector;
import software.aoc.day08.CircuitLoader;

import java.util.List;

public class Main {
    static void main() {
        List<Circuit> circuits = new CircuitLoader("/Day08Boxes.txt").loadAll().toList();
        System.out.println(new CircuitConnector(new BoxConnector(circuits.stream())
                .connect(1000), circuits)
                .toCircuit().stream().limit(3)
                .mapToLong(Circuit::size).reduce(1L, (acc, s) -> acc*s));
    }
}
