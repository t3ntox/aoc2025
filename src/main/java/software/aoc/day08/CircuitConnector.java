package software.aoc.day08;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CircuitConnector {
    private final List<PairBox> pairs;
    private final List<Circuit> circuits;

    public CircuitConnector(List<PairBox> pairs, List<Circuit> junctionBoxes) {
        this.pairs = pairs;
        this.circuits = junctionBoxes;
    }

    public List<Circuit> toCircuit() {
        List<Circuit> rCircuits = new ArrayList<>(circuits);
        pairs.forEach(pair -> tryConnect(pair, rCircuits));
        return rCircuits.stream().sorted(Comparator.comparingInt(Circuit::size).reversed()).toList();
    }

    private boolean tryConnect(PairBox pair, List<Circuit> circuits) {
        Circuit c1 = circuitFrom(pair.p1(), circuits);
        if (c1.junctionBoxes().contains(pair.p2())) return false;
        Circuit c2 = circuitFrom(pair.p2(), circuits);
        circuits.remove(c1);
        circuits.remove(c2);
        circuits.add(mergeCircuits(c1, c2));
        return true;
    }

    private Circuit mergeCircuits(Circuit c1, Circuit c2) {
        return new Circuit(
                Stream.concat(
                        c1.junctionBoxes().stream(),
                        c2.junctionBoxes().stream()
                ).collect(Collectors.toSet())
        );
    }

    public long toCableExtension() {
        PairBox lastPair = toLargeCircuit();
        return (long) lastPair.p1().x() * lastPair.p2().x();
    }

    private PairBox toLargeCircuit() {
        List<Circuit> rCircuits = new ArrayList<>(circuits);
        return pairs.stream()
                .filter(pair -> tryConnect(pair, rCircuits) && rCircuits.size() == 1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No se alcanzó un único circuito"));
    }

    private Circuit circuitFrom(Position position, List<Circuit> circuits) {
        return circuits.stream()
                .filter(c -> c.junctionBoxes().contains(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el circuito correspondiente."));
    }
}
