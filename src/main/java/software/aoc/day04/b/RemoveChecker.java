package software.aoc.day04.b;

import software.aoc.day04.AccessChecker;
import software.aoc.day04.AccessRule;
import software.aoc.day04.FourConnectedAccessRule;
import software.aoc.day04.Grid;

import java.util.ArrayList;
import java.util.List;

public class RemoveChecker {
    private final Grid grid;
    private final AccessRule accessRule;

    public RemoveChecker(Grid grid, AccessRule accessRule) {
        this.grid = grid;
        this.accessRule = accessRule;
    }

    public int removablePaperRolls() {
        int removableRolls = 0;

        AccessChecker accessChecker = new AccessChecker(grid, accessRule);

        Grid nGrid = new Grid(grid.paperRolls());
        List<int[]> available;
        while (!(available = accessChecker.availablePaperRolls()).isEmpty()) {
            removableRolls += available.size();
            for (int[] p : available) {
                nGrid = nGrid.removeAt(p[0], p[1]);
            }

            accessChecker = new AccessChecker(nGrid, accessRule);
        }

        return removableRolls;
    }
}
