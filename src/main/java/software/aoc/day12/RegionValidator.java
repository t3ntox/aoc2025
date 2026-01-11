package software.aoc.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RegionValidator {
    private final List<Present> presents;
    private final Region region;

    public RegionValidator(List<Present> presents, Region region) {
        this.presents = presents;
        this.region = region;
    }

    public boolean isValid() {
        if (region.area() < expectedArea()) return false;
        return canFillRegion();
    }

    private int expectedArea() {
        return IntStream.range(0, region.presentAmount().size())
                .map(i -> region.presentAmount().get(i) * presents.get(i).area())
                .sum();
    }

    private boolean canFillRegion() {
        List<Present> pieces = buildPiecesList();
        pieces.sort((a, b) -> Integer.compare(countCells(b), countCells(a)));

        List<List<List<Cell>>> shapesPerPiece = pieces.stream()
                .map(Present::allShapesAsOffsets)
                .toList();

        PiecePlacer placer = new PiecePlacer(region.width(), region.height(), shapesPerPiece);
        return placer.canPlace();
    }

    private List<Present> buildPiecesList() {
        List<Present> pieces = new ArrayList<>();
        for (int i = 0; i < region.presentAmount().size(); i++) {
            int amount = region.presentAmount().get(i);
            if (amount > 0) {
                for (int j = 0; j < amount; j++) {
                    pieces.add(presents.get(i));
                }
            }
        }
        return pieces;
    }

    private int countCells(Present present) {
        return (int) present.shape().stream()
                .flatMap(List::stream)
                .filter(c -> c == '#')
                .count();
    }
}