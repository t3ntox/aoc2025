import org.junit.Test;
import software.aoc.day03.Bank;
import software.aoc.day03.BankLoader;

import static org.assertj.core.api.Assertions.assertThat;

public class Day03ATest {
    @Test
    public void should_allow_create_new_Bank() {
        Bank bank = new Bank("987654321111111");
        assertThat(bank.line()).isEqualTo("987654321111111");
    }

    @Test
    public void should_find_best_pair() {
        Bank bank = new Bank("987654321111111");
        assertThat(bank.getPair(2)).isEqualTo(98);
    }

    @Test
    public void should_find_and_add_best_pairs() {
        Long addedPairs = new BankLoader("/Day03BasicTest.txt").loadAll()
                .map(b -> b.getPair(2))
                .mapToLong(Long::longValue).sum();
        assertThat(addedPairs).isEqualTo(357);
    }
}
