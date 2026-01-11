package software.aoc.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SituationLoader implements Loader {
    private final String situation;

    public SituationLoader(String situation) {
        this.situation = situation;
    }

    @Override
    public Situation loadAll() {
        try {
            return toSituation(getClass().getResourceAsStream(situation));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Situation toSituation(InputStream resourceAsStream) throws IOException {
        return toSituation(new InputStreamReader(resourceAsStream));
    }

    private Situation toSituation(InputStreamReader inputStreamReader) throws IOException {
        return toSituation(new BufferedReader(inputStreamReader));
    }

    private Situation toSituation(BufferedReader bufferedReader) throws IOException {
        String line = bufferedReader.readLine();
        List<Present> presents = new ArrayList<>();
        List<Region> regions = new ArrayList<>();
        while (line != null) {
            if(line.matches("\\d+:")) {
                int indx = toInt(line.trim().substring(0, line.length()-1));
                List<List<Character>> shape = new ArrayList<>();
                for (int i=0; i<3; i++) {
                    shape.add(bufferedReader.readLine().trim().chars()
                            .mapToObj(c -> (char) c)
                            .toList());
                }
                presents.add(new Present(indx, shape));
            } else if (line.matches("\\d+x\\d+:.*")){
                String[] regionAttr = line.split(" ");
                List<Integer> dims = toDim(regionAttr[0]);
                regions.add(new Region(dims.get(0), dims.get(1), Arrays.stream(regionAttr, 1, regionAttr.length)
                        .map(Integer::parseInt)
                        .toList()));
            }

            line = bufferedReader.readLine();
        }

        return new Situation(presents, regions);
    }

    private List<Integer> toDim(String s) {
        String[] wh = s.substring(0, s.length() - 1).split("x");

        return List.of(Integer.parseInt(wh[0]), Integer.parseInt(wh[1]));
    }

    private int toInt(String substring) {
        return Integer.parseInt(substring);
    }
}
