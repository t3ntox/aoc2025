package software.aoc.day07.a;

import software.aoc.day07.TachyonLoader;

public class Main {
    public static void main() {
        System.out.println(new BFSBeamStrategy(new TachyonLoader("/Day07Taychons.txt").loadAll()).goAhead());
    }
}
