package software.aoc.day08;

public class PairBox {
    private final double euclideanDistance;
    private final Position p1;
    private final Position p2;

    public PairBox(Position p1, Position p2) {
        this.euclideanDistance = solve(p1,p2);
        this.p1 = p1;
        this.p2 = p2;
    }

    public static PairBox of(Position p1, Position p2) {
        return new PairBox(p1, p2);
    }

    private double solve(Position p1, Position p2) {
        return Math.sqrt(Math.pow(p1.x() - p2.x(), 2) + Math.pow(p1.y() - p2.y(), 2) + Math.pow(p1.z() - p2.z(), 2));
    }

    public double euclideanDistance() {
        return euclideanDistance;
    }

    public Position p1() {
        return p1;
    }

    public Position p2() {
        return p2;
    }

    @Override
    public String toString() {
        return "PairBox{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", euclideanDistance=" + euclideanDistance +
                '}';
    }

}
