package software.aoc.day12;


import java.util.*;

public class PresentRotator {
    private final List<List<Character>> shape;

    public PresentRotator(List<List<Character>> shape) {
        this.shape = shape;
    }

    public List<List<List<Character>>> rotations() {
        Set<List<List<Character>>> variants = new HashSet<>();

        List<List<Character>> current = shape;

        for (int i = 0; i < 4; i++) {
            variants.add(current);
            variants.add(flipHorizontal(current));
            current = rotate90(current);
        }

        return List.copyOf(variants);
    }

    private List<List<Character>> flipHorizontal(List<List<Character>> matrix) {
        return matrix.stream()
                .map(row -> {
                    List<Character> copy = new ArrayList<>(row);
                    Collections.reverse(copy);
                    return List.copyOf(copy);
                })
                .toList();
    }

    private List<List<Character>> reverse() {
        return shape.stream().map(List::reversed).toList();
    }

    private static List<List<Character>> rotate90(List<List<Character>> matrix) {
        int rows = matrix.size();
        int cols = matrix.getFirst().size();

        List<List<Character>> rotated = new ArrayList<>();

        for (int c = 0; c < cols; c++) {
            List<Character> newRow = new ArrayList<>();
            for (int r = rows - 1; r >= 0; r--) {
                newRow.add(matrix.get(r).get(c));
            }
            rotated.add(newRow);
        }

        return rotated;
    }
}
