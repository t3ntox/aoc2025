import org.junit.Test;
import software.aoc.day02.RangeChecker;
import software.aoc.day02.RangeLoader;
import software.aoc.day02.b.Main;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class Day02BTest {

    @Test
    public void should_check_invalid_ids() {
        long invalidIDs = new RangeLoader("/Day02BasicTest.txt").loadAll()
                .mapToLong(r -> new RangeChecker(r, new ArrayList<>()).check(Main::isMadeByPattern).addInvalidIDs())
                .sum();
        assertThat(invalidIDs).isEqualTo(4174379265L);
    }

    @Test
    public void should_add_correctly_all_invalid_ids() {
        long invalidIDs = new RangeLoader("/Day02Ranges.txt").loadAll()
                .mapToLong(r -> new RangeChecker(r, new ArrayList<>()).check(Main::isMadeByPattern).addInvalidIDs())
                .sum();
        assertThat(invalidIDs).isEqualTo(27180728081L);
    }
}