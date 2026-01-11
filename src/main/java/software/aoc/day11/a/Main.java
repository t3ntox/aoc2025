package software.aoc.day11.a;

import software.aoc.day11.PathCounter;
import software.aoc.day11.TagLoader;

public class Main {
    static void main() {
        System.out.println(new PathCounter(new TagLoader("/Day11Tags.txt").loadAll()).countAllPathsFrom("you"));
    }
}
