public class BeatInterval {

    public static BeatInterval SIXTEENTH    = new BeatInterval(1L);

    public static BeatInterval EIGTH_BEAT   = new BeatInterval(2L);

    public static BeatInterval QUARTER_BEAT = new BeatInterval(4L);

    public static BeatInterval HALF_BEAT    = new BeatInterval(8L);

    public static BeatInterval ONE_BEAT     = new BeatInterval(16L);

    public static BeatInterval TWO_BEATS    = new BeatInterval(32L);

    public static BeatInterval FOUR_BEATS   = new BeatInterval(64L);

    public static BeatInterval EIGHT_BEATS = new BeatInterval(128L);

    private final long sixteenthMultiplier;

    private BeatInterval(final long multiplier) {
        this.sixteenthMultiplier = multiplier;
    }

    protected long getSixteenthMultiplier() {
        return sixteenthMultiplier;
    }
}
