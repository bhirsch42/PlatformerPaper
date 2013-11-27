import org.jbox2d.callbacks.*;
import org.jbox2d.collision.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.pooling.*;
import org.jbox2d.profile.*;
import java.util.ArrayList;

public class PlatformerPaper {

	public static boolean running;
	public static FrameRateCounter frc;
	public static ArrayList<Level> levels;
	public static int currentLevel = 0;

	public static void initialize() {
		// init canvas
		int width = 900;
		int height = 700;
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(height, 0);

		// init framerate
		frc = new FrameRateCounter();

		// init levels
		levels = new ArrayList<Level>();

		// ##       ######## ##     ## ######## ##             ##   
		// ##       ##       ##     ## ##       ##           ####   
		// ##       ##       ##     ## ##       ##             ##   
		// ##       ######   ##     ## ######   ##             ##   
		// ##       ##        ##   ##  ##       ##             ##   
		// ##       ##         ## ##   ##       ##             ##   
		// ######## ########    ###    ######## ########     ###### 
		// level 1 player
		Vec2[] player1Points = {new Vec2(158.0f, 579.0f), new Vec2(104.0f, 579.0f), new Vec2(104.0f, 490.0f), new Vec2(154.0f, 489.0f)};
		Player player1 = new Player(player1Points);
		Level level1 = new Level(player1);
		player1.setJumpForce(100000000.0f);
		player1.setGroundForce(100000.0f);
		player1.setAirForce(30000.0f);
		// level 1 platfomrs
		Vec2[] p0 = {new Vec2(49.0f, 558.0f), new Vec2(850.0f, 558.0f), new Vec2(868.0f, 664.0f), new Vec2(32.0f, 659.0f)};
		level1.createBody(new StdBoxPlatform(p0));

		Vec2[] p1 = {new Vec2(53.0f, 648.0f), new Vec2(56.0f, 25.0f), new Vec2(28.0f, 31.0f), new Vec2(22.0f, 638.0f)};
		level1.createBody(new StdBoxPlatform(p1));

		Vec2[] p2 = {new Vec2(849.0f, 652.0f), new Vec2(819.0f, 20.0f), new Vec2(845.0f, 26.0f), new Vec2(870.0f, 651.0f)};
		level1.createBody(new StdBoxPlatform(p2));

		Vec2[] p3 = {new Vec2(23.0f, 11.0f), new Vec2(29.0f, 35.0f), new Vec2(831.0f, 41.0f), new Vec2(809.0f, 6.0f)};
		level1.createBody(new StdBoxPlatform(p3));
		// level 1 stars
		level1.addStar(new Vec2(691.0f, 473.0f), "level_1_1.png");
		level1.addStar(new Vec2(302.0f, 340.0f), "level_1_2.png");

		// level 1 colors
		level1.setBackgroundColor(StdDraw.GRAY);
		// level1.setShowPlatforms(true);
		levels.add(level1);



	}

	public static void update(double delta) {
		frc.addFrame();
		Level level = levels.get(currentLevel);
		level.update(delta);
		if (level.complete()) {
			currentLevel++;
		}
		if (currentLevel == levels.size()) {
			System.exit(0);
		}
	}

	public static void render() {
		StdDraw.show(1);
		// StdDraw.text(20, 15, frc.getFPS()+"");
		levels.get(currentLevel).render();
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