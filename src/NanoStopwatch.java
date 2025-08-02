public class NanoStopwatch {

    private long startTime;

    public void reset() {
        startTime = System.nanoTime();
    }

    public long elapsedNanos() {
        return System.nanoTime() - startTime;
    }

    public double elapsedMillis() {
        return elapsedNanos() / 1_000_000.0;
    }

    public double elapsedSeconds() {
        return elapsedNanos() / 1_000_000_000.0;
    }
}
