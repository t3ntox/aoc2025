package software.aoc.day02.a;

import software.aoc.day02.RangeChecker;
import software.aoc.day02.RangeLoader;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        long invalidIDs = new RangeLoader("/Day02Ranges.txt").loadAll()
                .mapToLong(r -> new RangeChecker(r, new ArrayList<>()).check(Main::isMadeByRepetition).addInvalidIDs())
                .sum();
        System.out.println(invalidIDs);
    }

    public static boolean isMadeByRepetition(String n) {
        int len = n.length() / 2;
        return n.substring(0, len).equals(n.substring(len));
    }
}
