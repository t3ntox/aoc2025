package software.aoc.day11;

import java.util.*;

public class PathCounter {
    private final Graph graph;

    public PathCounter(Graph g) {
        this.graph = g;
    }

    public long countAllPathsFrom(String start){
        return count(PathState.startAllowingAll(start), new HashMap<>());
    }

    public long countWithDacAndFftFrom(String start) {
        return count(PathState.startRequiringDacFft(start), new HashMap<>());
    }

    private long count(PathState state, Map<PathState, Long> memo) {
        Long cached = memo.get(state);
        if (cached != null) return cached;

        long total = 0;
        for (String child : graph.childrenOf(state.node())) {
            PathState next = state.next(child);

            if (isValidEnd(next, child)) {
                total++;
            } else {
                total += count(next, memo);
            }
        }

        memo.put(state, total);
        return total;
    }

    private boolean isValidEnd(PathState state, String node) {
        return node.equals("out") && state.isDacVisited() && state.isFftVisited();
    }
}

