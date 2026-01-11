package software.aoc.day03.b;

import software.aoc.day03.BankLoader;

public class Main {
    public static void main(String[] args) {
        Long pairsSum = new BankLoader("/Day03Banks.txt").loadAll()
                .mapToLong(b -> b.getPair(12))
                .sum();
        System.out.println(pairsSum);
    }
}
