import org.junit.Test;
import software.aoc.day11.Graph;
import software.aoc.day11.GraphLoader;
import software.aoc.day11.PathCounter;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class Day11ATest {

    @Test
    public void should_allow_create_new_Graph() {
        assertThat(new Graph(new HashMap<>()).childrenOf("")).isEmpty();
    }

    @Test
    public void should_load_Graph() {
        assertThat(new GraphLoader("/Day11ABasicTest.txt").loadAll())
                .isInstanceOf(Graph.class);
    }

    @Test
    public void should_find_all_paths_for_example_input() {
        assertThat(new PathCounter(new GraphLoader("/Day11ABasicTest.txt").loadAll()).countAllPathsFrom("you"))
                .isEqualTo(5L);
    }

    @Test
    public void should_find_all_paths_for_puzzle_input() {
        assertThat(new PathCounter(new GraphLoader("/Day11Tags.txt").loadAll()).countAllPathsFrom("you"))
                .isEqualTo(431L);
    }
}
