package software.aoc.day03.a;

import software.aoc.day03.Bank;
import software.aoc.day03.BankLoader;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Long pairsSum = new BankLoader("/Day03Banks.txt").loadAll()
                .mapToLong(b -> b.getPair(2))
                .sum();
        System.out.println(pairsSum);
    }
}
