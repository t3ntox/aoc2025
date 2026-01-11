package software.aoc.day03;


public record Bank(String line) {

    public Long getPair(int amount) {
        StringBuilder pair = new StringBuilder();
        int start = 0;
        int end = line.length() - amount + 1;

        for (int i = 0; i < amount; i++) {
            int max = maxValueInRange(start, end);
            pair.append((char) max);
            start = line.indexOf(max, start) + 1;
            end++;
        }
        return Long.parseLong(pair.toString());
    }

    private int maxValueInRange(int from, int to) {
        return line.substring(from, to).chars().max().orElse('0');
    }
}
