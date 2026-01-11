package software.aoc.day11.b;

import software.aoc.day11.PathCounter;
import software.aoc.day11.TagLoader;

public class Main {
    static void main() {
        System.out.println(new PathCounter(new TagLoader("/Day11Tags.txt").loadAll()).countWithDacAndFftFrom("svr"));
    }
}
