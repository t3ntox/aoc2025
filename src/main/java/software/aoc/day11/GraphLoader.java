package software.aoc.day11;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class GraphLoader implements Loader{
    private String tags;

    public GraphLoader(String tags) {
        this.tags = tags;
    }

    @Override
    public Graph loadAll() {
        return toGraph(getClass().getResourceAsStream(tags));
    }

    private Graph toGraph(InputStream resourceAsStream) {
        return toGraph(new InputStreamReader(resourceAsStream));
    }

    private Graph toGraph(InputStreamReader inputStreamReader) {
        return toGraph(new BufferedReader(inputStreamReader));
    }

    private Graph toGraph(BufferedReader bufferedReader) {
        return new Graph(bufferedReader.lines()
                .map(String::trim)
                .filter(l -> !l.isEmpty())
                .collect(Collectors.toMap(
                        l -> l.split(":")[0].trim(),
                        l -> Arrays.stream(l.split(":")[1].trim().split("\\s+"))
                                .toList()
                )));
    }
}
