import org.junit.Test;
import software.aoc.day09.AreaCalculator;
import software.aoc.day09.Point;
import software.aoc.day09.PointLoader;
import software.aoc.day09.RectangleProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day09BTest {
    @Test
    public void should_solve_correctly() {
        List<Point> list = new PointLoader("/Day09BasicTest.txt").loadAll().toList();
        assertThat(new AreaCalculator(new RectangleProvider(list), list).findLargestValidRectangleArea())
                .isEqualTo(24L);
    }

    @Test
    public void should_solve_final_test() {
        List<Point> list = new PointLoader("/Day09Points.txt").loadAll().toList();
        assertThat(new AreaCalculator(new RectangleProvider(list), list).findLargestValidRectangleArea())
                .isEqualTo(1501292304L);
    }
}
