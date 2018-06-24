import processing.core.PApplet;

public class DebugInitiator extends PApplet {

    private Conductor conductor;

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        DebugInitiator mySketch = new DebugInitiator();
        PApplet.runSketch(processingArgs, mySketch);
    }

    @Override
    public void settings() {
        super.settings();
        size(640, 480);
    }

    @Override
    public void setup() {
        super.setup();
        frameRate(60f);
        loop();
        background(0);

        conductor = new Conductor();
    }

    @Override
    public void draw() {
//        super.draw();
//        noStroke();

        fill(0x10000000);
        rect(0f, 0f, width, height);

        fill(255, 255, 255);
        
        final float tileWidth = (width - (2f * 20f)) / 8f;
        final float tileHeight = height - (2f * 20f);

        if (conductor.getIntervalIsDue(BeatInterval.SIXTEENTH)) {
            rect(20f, 20f, tileWidth, tileHeight);
        }
        
        if (conductor.getIntervalIsDue(BeatInterval.EIGTH_BEAT)) {
            rect(20f + 1f * tileWidth, 20f, tileWidth, tileHeight);
        }

        if (conductor.getIntervalIsDue(BeatInterval.QUARTER_BEAT)) {
            rect(20f + 2f * tileWidth, 20f, tileWidth, tileHeight);
        }

        if (conductor.getIntervalIsDue(BeatInterval.HALF_BEAT)) {
            rect(20f + 3f * tileWidth, 20f, tileWidth, tileHeight);
        }

        if (conductor.getIntervalIsDue(BeatInterval.ONE_BEAT)) {
            rect(20f + 4f * tileWidth, 20f, tileWidth, tileHeight);
        }

        if (conductor.getIntervalIsDue(BeatInterval.TWO_BEATS)) {
            rect(20f + 5f * tileWidth, 20f, tileWidth, tileHeight);
        }

        if (conductor.getIntervalIsDue(BeatInterval.FOUR_BEATS)) {
            rect(20f + 6f * tileWidth, 20f, tileWidth, tileHeight);
        }

        if (conductor.getIntervalIsDue(BeatInterval.EIGHT_BEATS)) {
            rect(20f + 7f * tileWidth, 20f, tileWidth, tileHeight);
        }
    }

    @Override
    public void keyPressed() {
        super.keyPressed();

        switch (key) {
            case ' ':
                conductor.resetTimer();
        }
    }
}
