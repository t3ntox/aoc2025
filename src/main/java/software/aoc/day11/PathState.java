package software.aoc.day11;

import java.util.Objects;

public final class PathState {
    private final String node;
    private final boolean dacVisited;
    private final boolean fftVisited;

    public static PathState startRequiringDacFft(String node){
        return new PathState(node, false, false);
    }

    public static PathState startAllowingAll(String node){
        return new PathState(node, true, true);
    }

    private PathState(String node, boolean dacVisited, boolean fftVisited) {
        this.node = node;
        this.dacVisited = dacVisited;
        this.fftVisited = fftVisited;
    }

    public PathState next(String nextNode) {
        return new PathState(
                nextNode,
                dacVisited || nextNode.equals("dac"),
                fftVisited || nextNode.equals("fft")
        );
    }

    public String node() {
        return node;
    }

    public boolean isDacVisited() {
        return dacVisited;
    }

    public boolean isFftVisited() {
        return fftVisited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PathState other)) return false;
        return dacVisited == other.dacVisited
                && fftVisited == other.fftVisited
                && node.equals(other.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, dacVisited, fftVisited);
    }
}