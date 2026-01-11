package software.aoc.day06.b;

import software.aoc.day06.OperationLoader;
import software.aoc.day06.Operator;

public class Main {
    public static void main() {
        System.out.println(new Operator(new OperationLoader("/Day06Operations.txt", new ReverseOperationParser()).loadAll()).solve());
    }
}
