import org.junit.Test;
import software.aoc.day03.Bank;
import software.aoc.day03.BankLoader;
import software.aoc.day04.AccessChecker;
import software.aoc.day04.FourConnectedAccessRule;
import software.aoc.day04.Grid;
import software.aoc.day04.PaperLoader;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class Day04ATest {
    @Test
    public void should_allow_create_new_Grid() {
        Grid grid = new PaperLoader("/Day04BasicTest.txt").loadAll();
        assertThat(!grid.paperRolls().isEmpty());
    }

    @Test
    public void should_find_available_rolls_of_paper_for_example_input() {
        Grid grid = new PaperLoader("/Day04BasicTest.txt").loadAll();
        assertThat(new AccessChecker(grid, new FourConnectedAccessRule()).countAvailablePaperRolls()).isEqualTo(13);
    }

    @Test
    public void should_find_available_rolls_of_paper_for_puzzle_input() {
        Grid grid = new PaperLoader("/Day04PaperRolls.txt").loadAll();
        assertThat(new AccessChecker(grid, new FourConnectedAccessRule()).countAvailablePaperRolls()).isEqualTo(1376);
    }
}
