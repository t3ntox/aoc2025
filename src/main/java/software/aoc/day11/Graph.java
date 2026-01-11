package software.aoc.day11;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Graph {

    private final Map<String, List<String>> adjacency;

    public Graph(Map<String, List<String>> adjacency) {
        this.adjacency = adjacency.entrySet().stream()
                .collect(Collectors.toUnmodifiableMap(
                        Map.Entry::getKey,
                        e -> List.copyOf(e.getValue())
                ));
    }

    public List<String> childrenOf(String node) {
        return adjacency.getOrDefault(node, List.of());
    }
}
