package software.aoc.day12;


import java.util.List;

public record Present(int indx, List<List<Character>> shape) {


    public List<List<Cell>> allShapesAsOffsets() {
        return new PresentRotator(shape).rotations().stream()
                .map(OffsetConverter::toOffsets)
                .toList();
    }

    public int area() {
        return shape.stream().mapToInt(l -> (int) l.stream().filter(c -> c.equals('#')).count()).sum();
    }
}
