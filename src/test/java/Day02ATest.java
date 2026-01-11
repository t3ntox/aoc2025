import org.junit.Test;
import software.aoc.day02.Range;
import software.aoc.day02.RangeLoader;
import software.aoc.day02.RangeChecker;
import software.aoc.day02.a.Main;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class Day02ATest {
    @Test
    public void should_allow_create_new_rangeChecker() {
        RangeChecker checker = new RangeChecker(new Range("11-22"), new ArrayList<>());
        assertThat(checker.range().top()).isEqualTo(22);
        assertThat(checker.range().bottom()).isEqualTo(11);
        assertThat(checker.addInvalidIDs()).isEqualTo(0);
    }

    @Test
    public void should_check_invalid_ids() {
        long invalidIDs = new RangeLoader("/Day02BasicTest.txt").loadAll()
                .mapToLong(r -> new RangeChecker(r, new ArrayList<>()).check(Main::isMadeByRepetition).addInvalidIDs())
                .sum();
        assertThat(invalidIDs).isEqualTo(1227775554L);
    }

    @Test
    public void should_add_correctly_all_invalid_ids() {
        long invalidIDs = new RangeLoader("/Day02Ranges.txt").loadAll()
                .mapToLong(r -> new RangeChecker(r, new ArrayList<>()).check(Main::isMadeByRepetition).addInvalidIDs())
                .sum();
        assertThat(invalidIDs).isEqualTo(19219508902L);
    }
}
