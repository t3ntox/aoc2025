package software.aoc.day08;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Stream;

public class CircuitLoader implements Loader {
    private String positions;

    public CircuitLoader(String positions) {
        this.positions = positions;
    }

    @Override
    public Stream<Circuit> loadAll() {
        return toCircuit(getClass().getResourceAsStream(positions));
    }

    private Stream<Circuit> toCircuit(InputStream resourceAsStream) {
        return toCircuit(new InputStreamReader(resourceAsStream));
    }

    private Stream<Circuit> toCircuit(InputStreamReader inputStreamReader) {
        return toCircuit(new BufferedReader(inputStreamReader));
    }

    private Stream<Circuit> toCircuit(BufferedReader bufferedReader) {
        return bufferedReader.lines()
                .map(l -> {
                    String[] coords = l.split(",");
                    return new Circuit(Set.of(new Position(toInt(coords[0]),
                            toInt(coords[1]),
                            toInt(coords[2])
                    )));
                });
    }

    private int toInt(String coord) {
        return Integer.parseInt(coord);
    }
}
