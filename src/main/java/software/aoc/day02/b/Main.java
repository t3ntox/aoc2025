package software.aoc.day02.b;

import software.aoc.day02.RangeChecker;
import software.aoc.day02.RangeLoader;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        long invalidIDs = new RangeLoader("/Day02Ranges.txt").loadAll()
                .mapToLong(r -> new RangeChecker(r, new ArrayList<>()).check(Main::isMadeByPattern).addInvalidIDs())
                .sum();
        System.out.println(invalidIDs);
    }

    public static boolean isMadeByPattern(String n) {
        return n.matches("^(\\d+)\\1+$");
    }
}
