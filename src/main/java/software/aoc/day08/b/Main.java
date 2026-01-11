package software.aoc.day08.b;

import software.aoc.day08.BoxConnector;
import software.aoc.day08.Circuit;
import software.aoc.day08.CircuitConnector;
import software.aoc.day08.CircuitLoader;

import java.util.List;

public class Main {
    static void main() {
        List<Circuit> circuits = new CircuitLoader("/Day08Boxes.txt").loadAll().toList();
        System.out.println(new CircuitConnector(new BoxConnector(circuits.stream())
                .connectAll(), circuits)
                .toCableExtension());
    }
}
