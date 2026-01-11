package software.aoc.day02;

public record Range(long bottom, long top) {

    public Range (String r) {
        this(Long.parseLong(r.split("-")[0]), Long.parseLong(r.split("-")[1]));
    }
}
