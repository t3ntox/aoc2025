package software.aoc.day04.b;

import software.aoc.day04.FourConnectedAccessRule;
import software.aoc.day04.Grid;
import software.aoc.day04.PaperLoader;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Grid grid = new PaperLoader("/Day04PaperRolls.txt").loadAll();
        System.out.println(new RemoveChecker(grid, new FourConnectedAccessRule()).removablePaperRolls());
    }
}
