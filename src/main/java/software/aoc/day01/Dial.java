package software.aoc.day01;

public record Dial(int pointedValue, ZeroCounter counter, int zeroTimes) {

    public Dial rotate(Order rotation) {
        int newPointedValue = (((pointedValue + rotation.getSteps()) % 100) + 100) % 100;
        return new Dial(newPointedValue, counter, zeroTimes + counter.countZeros(pointedValue,rotation,newPointedValue));
    }
}
