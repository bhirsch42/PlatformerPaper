public class PlatformerPaper {

	private static StdBoxWorld world;
	public static boolean running;
	public static FrameRateCounter frc;

	public static void initialize() {
		// init canvas
		int width = 600;
		int height = 400;
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(height, 0);

		// init framerate
		frc = new FrameRateCounter();

		// init world
		world = new StdBoxWorld();
		Body body = world.createPolygon();
		body.m_userdata = new StdBoxPolygon(body);
	}

	public static void update(double delta) {
		frc.addFrame();
	}

	public static void render() {
		StdDraw.show(1);
		StdDraw.clear();
		StdDraw.text(20, 15, frc.getFPS()+"");
	}

	public static void main(String[] args) {
		initialize();
		running = true;
		Stopwatch stopwatch = new Stopwatch();
		while (running) {
			update(stopwatch.elapsedTime());
			render();
			stopwatch = new Stopwatch();
		}


	}

}