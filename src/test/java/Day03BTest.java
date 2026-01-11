import org.junit.Test;
import software.aoc.day03.Bank;
import software.aoc.day03.BankLoader;

import static org.assertj.core.api.Assertions.assertThat;

public class Day03BTest {
    @Test
    public void should_find_best_pair() {
        Bank bank = new Bank("234234234234278");
        assertThat(bank.getPair(12)).isEqualTo(434234234278L);
    }

    @Test
    public void should_find_and_add_best_dozens() {
        Long addedPairs = new BankLoader("/Day03BasicTest.txt").loadAll()
                .map(b -> b.getPair(12))
                .mapToLong(Long::longValue).sum();
        assertThat(addedPairs).isEqualTo(3121910778619L);
    }

    @Test
    public void should_find_and_add_all_best_dozens() {
        Long addedPairs = new BankLoader("/Day03Banks.txt").loadAll()
                .map(b -> b.getPair(12))
                .mapToLong(Long::longValue).sum();
        assertThat(addedPairs).isEqualTo(176582889354075L);
    }
}
