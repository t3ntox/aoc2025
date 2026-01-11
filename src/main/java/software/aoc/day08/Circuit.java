package software.aoc.day08;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Circuit(Set<Position> junctionBoxes){
    public Circuit add(Position p1) {
        return new Circuit(Stream.concat(
                junctionBoxes.stream(),
                Stream.of(p1)
        ).collect(Collectors.toSet()));
    }

    public int size() {
        return junctionBoxes.size();
    }
}
