package software.aoc.day06.a;

import software.aoc.day06.OperationLoader;
import software.aoc.day06.Operator;

public class Main {
    public static void main() {
        System.out.println(new Operator(new OperationLoader("/Day06Operations.txt", new StandardOperationParser()).loadAll()).solve());
    }
}
