package software.aoc.day01;

import java.io.*;
import java.util.stream.Stream;


public class OrdersLoader implements Loader {
    private final String orders;

    public OrdersLoader(String path) {
        this.orders = path;
    }

    @Override
    public Stream<Order> loadAll() {
        return toOrder(getClass().getResourceAsStream(orders));
    }

    private Stream<Order> toOrder(InputStream resourceAsStream) {
        return toOrder(new InputStreamReader(resourceAsStream));
    }

    private Stream<Order> toOrder(InputStreamReader inputStreamReader) {
        return toOrder(new BufferedReader(inputStreamReader));
    }

    private Stream<Order> toOrder(BufferedReader bufferedReader) {
        return bufferedReader.lines().map(Order::new);
    }

}
