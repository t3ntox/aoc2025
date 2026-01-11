package software.aoc.day12;

import java.util.List;

public class PiecePlacer {
    private final boolean[][] board;
    private final List<List<List<Cell>>> shapesPerPiece;

    public PiecePlacer(int width, int height, List<List<List<Cell>>> shapesPerPiece) {
        this.board = new boolean[height][width];
        this.shapesPerPiece = shapesPerPiece;
    }

    public boolean canPlace() {
        return placePiece(0, shapesPerPiece.size());
    }

    private boolean placePiece(int idx, int totalPieces) {
        if (idx == totalPieces) return true;

        List<List<Cell>> shapes = shapesPerPiece.get(idx);
        int h = board.length;
        int w = board[0].length;

        for (List<Cell> shape : shapes) {
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (!canPlaceAt(shape, x, y)) continue;

                    place(shape, x, y, true);
                    if (placePiece(idx + 1, totalPieces)) return true;
                    place(shape, x, y, false);
                }
            }
        }
        return false;
    }

    private boolean canPlaceAt(List<Cell> shape, int offsetX, int offsetY) {
        int h = board.length;
        int w = board[0].length;
        for (Cell cell : shape) {
            int x = offsetX + cell.x();
            int y = offsetY + cell.y();
            if (x < 0 || x >= w || y < 0 || y >= h || board[y][x]) return false;
        }
        return true;
    }

    private void place(List<Cell> shape, int offsetX, int offsetY, boolean value) {
        for (Cell cell : shape) {
            board[offsetY + cell.y()][offsetX + cell.x()] = value;
        }
    }
}

