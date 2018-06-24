import java.util.HashMap;

public class Conductor {

    private long startMillis;

    private long sixteenthIntervalMillis;

    private HashMap<BeatInterval, Integer> acknowledgedIntervalCounts;

    public Conductor() {
        this(120f);
    }

    public Conductor(final float bpm) {
        setBpm(bpm);
    }

    public void setBpm(final float bpm) {
        resetTimer();
        sixteenthIntervalMillis = (long) ((60f / bpm / 4f) * 1000f);
        System.out.println("Conductor: setBpm(): " + bpm + "BPM, " + sixteenthIntervalMillis + "ms");
    }

    public void resetTimer() {
        startMillis = System.currentTimeMillis();
        acknowledgedIntervalCounts = new HashMap<>();
    }

    public int getIntervalCount(final BeatInterval interval) {
        return (int) (millis() / sixteenthIntervalMillis / interval.getSixteenthMultiplier());
    }

    public boolean getIntervalIsDue(final BeatInterval interval) {
        final Integer count = getIntervalCount(interval);
        final Integer acknowledgedCount = acknowledgedIntervalCounts.get(interval);
        if (!count.equals(acknowledgedCount)) {
            acknowledgedIntervalCounts.put(interval, count);
            return true;
        } else {
            return false;
        }
    }

    private long millis() {
        return System.currentTimeMillis() - startMillis;
    }

}
