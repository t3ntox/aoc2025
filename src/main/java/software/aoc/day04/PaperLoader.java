package software.aoc.day04;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PaperLoader implements Loader {
    private String papers;

    public PaperLoader(String papers) {
        this.papers = papers;
    }

    @Override
        public Grid loadAll() {
        return toGrid(getClass().getResourceAsStream(papers));
    }

    private Grid toGrid(InputStream resourceAsStream) {
        return toGrid(new InputStreamReader(resourceAsStream));
    }

    private Grid toGrid(InputStreamReader inputStreamReader) {
        return toGrid(new BufferedReader(inputStreamReader));
    }

    private Grid toGrid(BufferedReader bufferedReader) {
        return toGrid(bufferedReader.lines().map(String::toCharArray).toList());
    }

    private Grid toGrid(List<char[]> list) {
        return new Grid(list);
    }
}
