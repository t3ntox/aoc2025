package software.aoc.day05;

public record IdRange (long top, long bottom) {

    public boolean isValid(long id) {
        return isBetween(id);
    }

    private boolean isBetween(long id) {
        return top >= id && bottom <= id;
    }
}