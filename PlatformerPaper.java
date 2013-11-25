import org.jbox2d.callbacks.*;
import org.jbox2d.collision.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.pooling.*;
import org.jbox2d.profile.*;

public class PlatformerPaper {

	private static StdBoxWorld world;
	public static boolean running;
	public static FrameRateCounter frc;

	public static void initialize() {
		// init canvas
		int width = 800;
		int height = 800;
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(height, 0);

		// init framerate
		frc = new FrameRateCounter();

		// init world
		world = new Level2(new Vec2(0.0f, 40.0f));

	}

	public static void update(double delta) {
		frc.addFrame();
		world.update(delta);
		if (StdDraw.isKeyPressed(37)) { // <--
			world = new Level1(new Vec2(0.0f, 40.0f));
		}
		if (StdDraw.isKeyPressed(39)) { // <--
			world = new Level2(new Vec2(0.0f, 40.0f));
		}
	}

	public static void render() {
		StdDraw.show(1);
		StdDraw.clear();
		StdDraw.text(20, 15, frc.getFPS()+"");

		world.render();
	}

	public static void main(String[] args) {
		initialize();
		running = true;
		Stopwatch stopwatch = new Stopwatch();
		while (running) {
			update(stopwatch.elapsedTime());
			stopwatch = new Stopwatch();
			render();
		}


	}

}