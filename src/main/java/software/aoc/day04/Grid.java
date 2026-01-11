package software.aoc.day04;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private final List<char[]> paperRolls;

    public Grid(List<char[]> paperRolls) {
        this.paperRolls = paperRolls.stream()
                .map(char[]::clone)
                .toList();
    }

    public Grid add(char[] line) {
        List<char[]> newPapers = new ArrayList<>(paperRolls);
        newPapers.add(line);
        return new Grid(newPapers);
    }

    public ArrayList<char[]> paperRolls() {
        return new ArrayList<>(paperRolls);
    }

    public Grid removeAt(int r, int c) {
        List<char[]> newGrid = paperRolls.stream()
                .map(char[]::clone)
                .toList();

        newGrid.get(r)[c] = '.';
        return new Grid(newGrid);
    }
}
