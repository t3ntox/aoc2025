package software.aoc.day03;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class BankLoader implements Loader{
    private final String batteries;

    public BankLoader(String batteries) {
        this.batteries = batteries;
    }

    @Override
    public Stream<Bank> loadAll() {
        return toBank(getClass().getResourceAsStream(batteries));
    }

    private Stream<Bank> toBank(InputStream resourceAsStream) {
        return toBank(new InputStreamReader(resourceAsStream));
    }

    private Stream<Bank> toBank(InputStreamReader inputStreamReader) {
        return toBank(new BufferedReader(inputStreamReader));
    }

    private Stream<Bank> toBank(BufferedReader bufferedReader) {
        return bufferedReader.lines().map(Bank::new);
    }
}
