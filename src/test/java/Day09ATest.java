import org.junit.Test;
import software.aoc.day09.AreaCalculator;
import software.aoc.day09.Point;
import software.aoc.day09.PointLoader;
import software.aoc.day09.RectangleProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day09ATest {
    @Test
    public void should_solve_correctly() {
        List<Point> list = new PointLoader("/Day09BasicTest.txt").loadAll().toList();
        assertThat(new AreaCalculator(new RectangleProvider(list), list).maxAreaFromPoints())
                .isEqualTo(50L);
    }

    @Test
    public void should_solve_final_test() {
        List<Point> list = new PointLoader("/Day09Points.txt").loadAll().toList();
        assertThat(new AreaCalculator(new RectangleProvider(list), list).maxAreaFromPoints())
                .isEqualTo(4763932976L);
    }
}
