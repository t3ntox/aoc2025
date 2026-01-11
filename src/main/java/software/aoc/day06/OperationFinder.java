package software.aoc.day06;

import java.util.ArrayList;
import java.util.List;

public class OperationFinder {
    public static String[] findProblems(String l, String operator) {
        List<String> operators = List.of(operator.split("(?=[*+])"));
        int start = 0;
        int end = 0;
        List<String> row = new ArrayList<>();
        for (String el: operators){
            if (operators.getLast().equals(el)) {
                row.add(l.substring(start));
                continue;
            }
            end += el.length();
            row.add(l.substring(start, end));
            start = end;
        }
        return row.toArray(new String[0]);
    }

    public static List<String[]> toColumns(List<String[]> rows) {
        int rowCount = rows.size();
        int colCount = rows.getFirst().length;

        List<String[]> columns = new ArrayList<>();

        for (int c = 0; c < colCount; c++) {           // por cada “problema”
            String[] column = new String[rowCount];    // dígitos de arriba a abajo
            for (int r = 0; r < rowCount; r++) {
                column[r] = rows.get(r)[c];
            }
            columns.add(column);
        }
        return columns;
    }
}