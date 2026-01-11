package software.aoc.day12;

import java.util.ArrayList;
import java.util.List;

public class OffsetConverter {
    public static List<Cell> toOffsets(List<List<Character>> orientation) {
        List<Cell> cells = new ArrayList<>();
        for (int y = 0; y < orientation.size(); y++) {
            List<Character> row = orientation.get(y);
            for (int x = 0; x < row.size(); x++) {
                if (row.get(x) == '#') {
                    cells.add(new Cell(x, y));
                }
            }
        }
        return cells;
    }
}
