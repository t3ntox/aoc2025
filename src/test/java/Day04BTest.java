import org.junit.Test;
import software.aoc.day04.FourConnectedAccessRule;
import software.aoc.day04.Grid;
import software.aoc.day04.PaperLoader;
import software.aoc.day04.b.RemoveChecker;

import static org.assertj.core.api.Assertions.assertThat;

public class Day04BTest {

    @Test
    public void should_find_available_rolls_of_paper() {
        Grid grid = new PaperLoader("/Day04BasicTest.txt").loadAll();
        assertThat(new RemoveChecker(grid, new FourConnectedAccessRule()).removablePaperRolls()).isEqualTo(43);
    }

    @Test
    public void should_find_all_available_rolls_of_paper() {
        Grid grid = new PaperLoader("/Day04PaperRolls.txt").loadAll();
        assertThat(new RemoveChecker(grid, new FourConnectedAccessRule()).removablePaperRolls()).isEqualTo(8587);
    }
}
