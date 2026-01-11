package software.aoc.day07.b;

import software.aoc.day07.BeamStrategy;
import software.aoc.day07.TachyonManifold;

import java.util.*;

public class DPBeamStrategy implements BeamStrategy {
    private final List<List<Character>> manifold;

    public DPBeamStrategy(TachyonManifold tachyonManifold) {
        this.manifold = tachyonManifold.manifold();
    }

    @Override
    public long goAhead() {
        return dp(manifold);
    }

    private long dp(List<List<Character>> grid) {
        int rows = grid.size();
        int cols = grid.getFirst().size();
        long[][] ways = new long[rows + 1][cols];  // rows+1 para la “fila final”

        int startCol = grid.getFirst().indexOf('S');
        ways[0][startCol] = 1L;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                long w = ways[r][c];
                if (w == 0) continue;

                char cell = grid.get(r).get(c);
                if (cell == '^') {
                    if (c - 1 >= 0) ways[r + 1][c - 1] += w;
                    if (c + 1 < cols) ways[r + 1][c + 1] += w;
                } else {
                    ways[r + 1][c] += w;
                }
            }
        }

        long total = 0;
        for (int c = 0; c < cols; c++) {
            total += ways[rows][c];
        }
        return total;
    }

}
