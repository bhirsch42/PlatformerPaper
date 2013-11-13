public class FrameRateCounter {

	private Stopwatch stopwatch;
	private int frameCounter;
	private int frames;

	public FrameRateCounter() {
		stopwatch = new Stopwatch();
	}

	public void addFrame() {
		frameCounter++;
		if (stopwatch.elapsedTime() > 1.0) {
			frames = frameCounter;
			frameCounter = 0;
			stopwatch = new Stopwatch();
		}
	}

	public int getFPS() {
		return frames;
	}

}