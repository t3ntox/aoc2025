package software.aoc.day07.b;

import software.aoc.day07.TachyonLoader;

public class Main {
    public static void main() {
        System.out.println(new DPBeamStrategy(new TachyonLoader("/Day07Taychons.txt").loadAll()).goAhead());
    }
}
