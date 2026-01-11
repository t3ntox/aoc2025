package software.aoc.day10;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MachineLoader implements Loader{
    private final String machines;

    public MachineLoader(String machines) {
        this.machines = machines;
    }

    @Override
    public Stream<Machine> loadAll() {
        return toMachine(getClass().getResourceAsStream(machines));
    }

    private Stream<Machine> toMachine(InputStream resourceAsStream) {
        return toMachine(new InputStreamReader(resourceAsStream));
    }

    private Stream<Machine> toMachine(InputStreamReader inputStreamReader) {
        return toMachine(new BufferedReader(inputStreamReader));
    }

    private Stream<Machine> toMachine(BufferedReader bufferedReader) {
        return bufferedReader.lines()
                .map(l -> {
                    String[] params = l.split(" ");
                    return new Machine(
                            toLightGoal(params[0]),
                            toButtonBlock(Arrays.copyOfRange(params, 1, params.length - 1)),
                            toJoltage(params[params.length-1])
                    );

                });
    }

    private List<Integer> toJoltage(String l) {
        return Arrays.stream(l.substring(1,l.length()-1).split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    private char[] toLightGoal(String l) {
        return l.substring(1,l.length()-1).toCharArray();
    }

    private List<Button> toButtonBlock(String[] s) {
        return Arrays.stream(s)
                .map(b -> new Button(Arrays.stream(b.substring(1, b.length() - 1).split(","))
                        .map(Integer::parseInt)
                        .toList())
                )
                .toList();
    }
}
