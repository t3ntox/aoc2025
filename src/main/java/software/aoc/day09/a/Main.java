package software.aoc.day09.a;

import software.aoc.day09.AreaCalculator;
import software.aoc.day09.Point;
import software.aoc.day09.PointLoader;
import software.aoc.day09.RectangleProvider;

import java.util.List;

public class Main {
    static void main() {
        List<Point> list =  new PointLoader("/Day09Points.txt").loadAll().toList();
        System.out.println(new AreaCalculator(new RectangleProvider(list), list).maxAreaFromPoints());
    }
}
