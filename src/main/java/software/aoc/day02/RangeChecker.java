package software.aoc.day02;

import java.util.List;
import java.util.function.Function;
import java.util.stream.LongStream;

public record RangeChecker(Range range, List<Long> invalidIDs) {

    public RangeChecker check(Function<String, Boolean> condition) {
        return new RangeChecker(range,
                LongStream.rangeClosed(range.bottom(), range.top())
                        .filter(n -> condition.apply(String.valueOf(n)))
                        .boxed().toList());
    }

    public long addInvalidIDs() {
        return invalidIDs.stream().mapToLong(Long::longValue).sum();
    }
}
