package software.aoc.day04;

import java.util.List;

public interface AccessRule {
    boolean isAccessible(List<char[]> grid, int r, int c);
}
