package software.aoc.day11.b;

import software.aoc.day11.GraphLoader;
import software.aoc.day11.PathCounter;

public class Main {
    static void main() {
        System.out.println(new PathCounter(new GraphLoader("/Day11Tags.txt").loadAll()).countWithDacAndFftFrom("svr"));
    }
}
