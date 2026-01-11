package software.aoc.day01;

public record Order(int dir, int value) {

    public Order(String order) {
        this(parseDirection(order), parseValue(order));
    }

    private static int parseDirection(String order) {
        return (order.startsWith("L")) ? -1 : 1;
    }

    private static int parseValue(String order) {
        return Integer.parseInt(order.substring(1));
    }

    public int getSteps() {
        return dir*value;
    }
}
