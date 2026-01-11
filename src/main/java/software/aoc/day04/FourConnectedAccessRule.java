package software.aoc.day04;

import java.util.List;

public class FourConnectedAccessRule implements AccessRule {

    @Override
    public boolean isAccessible(List<char[]> grid, int r, int c) {
        int adjacentPaperRolls = 0;
        for (int i=r-1; i < r+2; i++) {
            for (int j=c-1; j < c+2; j++) {
                if (i > (grid.size()-1) || j > (grid.getFirst().length-1)) continue;
                if (i < 0 || j < 0) continue;
                if ((grid.get(i)[j] == '@')) adjacentPaperRolls += 1;
            }
        }
        return adjacentPaperRolls <= 4;
    }
}
