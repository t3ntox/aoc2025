package software.aoc.day04;

import java.util.ArrayList;
import java.util.List;

public class AccessChecker {
    private final List<char[]> grid;
    private final AccessRule accessRule;

    public AccessChecker(Grid grid, AccessRule accessRule) {
        this.grid = grid.paperRolls();
        this.accessRule = accessRule;
    }

    public int countAvailablePaperRolls() {
        return availablePaperRolls().size();
    }

    public List<int[]> availablePaperRolls() {
        List<int[]> availableRolls = new ArrayList<>();
        for (int r = 0; r < grid.size(); r++) {
            for (int c = 0; c < grid.getFirst().length; c++) {
                if (grid.get(r)[c] == '@' && accessRule.isAccessible(grid, r, c)) {
                    availableRolls.add(new int[]{r, c});
                }
            }
        }
        return availableRolls;
    }
}
