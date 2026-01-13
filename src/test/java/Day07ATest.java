import org.junit.Test;
import software.aoc.day07.TachyonManifold;
import software.aoc.day07.a.BFSBeamStrategy;
import software.aoc.day07.TachyonLoader;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class Day07ATest {

    @Test
    public void should_allow_create_new_TachyonManifold() {
        assertThat(TachyonManifold.empty().manifold())
                .isEmpty();
    }

    @Test
    public void should_load_manifold() {
        assertThat(new TachyonLoader("/Day07BasicTest.txt").loadAll().manifold())
                .isNotEmpty();
    }

    @Test
    public void should_split_light_correctly_for_example_input() {
        assertThat(new BFSBeamStrategy(new TachyonLoader("/Day07BasicTest.txt").loadAll()).goAhead())
                .isEqualTo(21);
    }

    @Test
    public void should_split_light_correctly_for_puzzle_input() {
        assertThat(new BFSBeamStrategy(new TachyonLoader("/Day07Taychons.txt").loadAll()).goAhead())
                .isEqualTo(1630);
    }
}
