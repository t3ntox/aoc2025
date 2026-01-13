import org.junit.Test;
import software.aoc.day09.AreaCalculator;
import software.aoc.day09.Point;
import software.aoc.day09.PointLoader;
import software.aoc.day09.RectangleProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class Day09ATest {

    @Test
    public void should_allow_create_new_Point() {
        Point testPoint = new Point(5,5);
        assertThat(testPoint.x()).isEqualTo(5);
        assertThat(testPoint.y()).isEqualTo(5);
    }

    @Test
    public void should_load_points() {
        assertThat(new PointLoader("/Day09BasicTest.txt").loadAll().toList().getFirst())
                .isInstanceOf(Point.class);
    }

    @Test
    public void should_find_biggest_rectangle_for_example_input() {
        List<Point> list = new PointLoader("/Day09BasicTest.txt").loadAll().toList();
        assertThat(new AreaCalculator(new RectangleProvider(list), list).maxAreaFromPoints())
                .isEqualTo(50L);
    }

    @Test
    public void should_find_biggest_rectangle_for_puzzle_input() {
        List<Point> list = new PointLoader("/Day09Points.txt").loadAll().toList();
        assertThat(new AreaCalculator(new RectangleProvider(list), list).maxAreaFromPoints())
                .isEqualTo(4763932976L);
    }
}
