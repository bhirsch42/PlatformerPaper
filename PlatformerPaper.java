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
		// level 1 platforms
		Vec2[] p1_0 = {new Vec2(49.0f, 558.0f), new Vec2(850.0f, 558.0f), new Vec2(868.0f, 664.0f), new Vec2(32.0f, 659.0f)};
		level1.createBody(new StdBoxPlatform(p1_0));

		Vec2[] p1_1 = {new Vec2(53.0f, 648.0f), new Vec2(56.0f, 25.0f), new Vec2(28.0f, 31.0f), new Vec2(22.0f, 638.0f)};
		level1.createBody(new StdBoxPlatform(p1_1));

		Vec2[] p1_2 = {new Vec2(849.0f, 652.0f), new Vec2(819.0f, 20.0f), new Vec2(845.0f, 26.0f), new Vec2(870.0f, 651.0f)};
		level1.createBody(new StdBoxPlatform(p1_2));

		Vec2[] p1_3 = {new Vec2(23.0f, 11.0f), new Vec2(29.0f, 35.0f), new Vec2(831.0f, 41.0f), new Vec2(809.0f, 6.0f)};
		level1.createBody(new StdBoxPlatform(p1_3));
		// level 1 stars
		level1.addStar(new Vec2(691.0f, 473.0f), "level_1_1.png");
		level1.addStar(new Vec2(302.0f, 340.0f), "level_1_2.png");

		// level 1 colors
		level1.setBackgroundColor(StdDraw.GRAY);
		// level1.setShowPlatforms(true);
		levels.add(level1);

		// ##       ######## ##     ## ######## ##           #######  
		// ##       ##       ##     ## ##       ##          ##     ## 
		// ##       ##       ##     ## ##       ##                 ## 
		// ##       ######   ##     ## ######   ##           #######  
		// ##       ##        ##   ##  ##       ##          ##        
		// ##       ##         ## ##   ##       ##          ##        
		// ######## ########    ###    ######## ########    ######### 

		// level 2 player
		Vec2[] player2Points = {new Vec2(76.0f, 592.0f), new Vec2(105.0f, 592.0f), new Vec2(105.0f, 542.0f), new Vec2(76.0f, 542.0f)};
		Player player2 = new Player(player2Points);
		Level level2 = new Level(player2);
		player2.setJumpForce(100000000.0f);
		player2.setGroundForce(100000.0f);
		player2.setAirForce(30000.0f);

		// level 2 platforms
		Vec2[] p2_0 = {new Vec2(49.0f, 607.0f), new Vec2(850.0f, 608.0f), new Vec2(863.0f, 659.0f), new Vec2(43.0f, 658.0f)};
		level2.createBody(new StdBoxPlatform(p2_0));

		Vec2[] p2_1 = {new Vec2(51.0f, 607.0f), new Vec2(47.0f, 22.0f), new Vec2(22.0f, 25.0f), new Vec2(23.0f, 640.0f)};
		level2.createBody(new StdBoxPlatform(p2_1));

		Vec2[] p2_2 = {new Vec2(849.0f, 65.0f), new Vec2(848.0f, 610.0f), new Vec2(868.0f, 645.0f), new Vec2(876.0f, 43.0f)};
		level2.createBody(new StdBoxPlatform(p2_2));

		Vec2[] p2_3 = {new Vec2(854.0f, 69.0f), new Vec2(43.0f, 46.0f), new Vec2(50.0f, 8.0f), new Vec2(858.0f, 27.0f)};
		level2.createBody(new StdBoxPlatform(p2_3));

		Vec2[] p2_4 = {new Vec2(174.0f, 511.0f), new Vec2(311.0f, 512.0f), new Vec2(310.0f, 548.0f), new Vec2(174.0f, 548.0f)};
		level2.createBody(new StdBoxPlatform(p2_4));

		Vec2[] p2_5 = {new Vec2(379.0f, 438.0f), new Vec2(503.0f, 438.0f), new Vec2(502.0f, 475.0f), new Vec2(378.0f, 474.0f)};
		level2.createBody(new StdBoxPlatform(p2_5));

		Vec2[] p2_6 = {new Vec2(580.0f, 360.0f), new Vec2(710.0f, 360.0f), new Vec2(710.0f, 394.0f), new Vec2(579.0f, 394.0f)};
		level2.createBody(new StdBoxPlatform(p2_6));

		Vec2[] p2_7 = {new Vec2(736.0f, 288.0f), new Vec2(849.0f, 289.0f), new Vec2(849.0f, 322.0f), new Vec2(735.0f, 320.0f)};
		level2.createBody(new StdBoxPlatform(p2_7));

		// level 2 stars
		level2.addStar(new Vec2(788.0f, 240.0f), "level_2_1.png");

		// level 2 colors
		level2.setBackgroundColor(StdDraw.GRAY);
		// level2.setShowPlatforms(true);
		levels.add(level2);

		// ##       ######## ##     ## ######## ##           #######  
		// ##       ##       ##     ## ##       ##          ##     ## 
		// ##       ##       ##     ## ##       ##                 ## 
		// ##       ######   ##     ## ######   ##           #######  
		// ##       ##        ##   ##  ##       ##                 ## 
		// ##       ##         ## ##   ##       ##          ##     ## 
		// ######## ########    ###    ######## ########     #######  
		// level 3 player
		Vec2[] player3Points = {new Vec2(336.0f, 621.0f), new Vec2(346.0f, 621.0f), new Vec2(346.0f, 597.0f), new Vec2(336.0f, 597.0f)};
		Player player3 = new Player(player3Points);
		Level level3 = new Level(player3);
		player3.setJumpForce(1500000.0f);
		player3.setGroundForce(3000.0f);
		player3.setAirForce(6000.0f);
		player3.setMaxSpeed(100.0f);
		// level 3 platforms
		Vec2[] p3_0 = {new Vec2(187.0f, 45.0f), new Vec2(186.0f, 659.0f), new Vec2(149.0f, 655.0f), new Vec2(148.0f, 40.0f)};
		level3.createBody(new StdBoxPlatform(p3_0));

		Vec2[] p3_1 = {new Vec2(185.0f, 631.0f), new Vec2(449.0f, 632.0f), new Vec2(450.0f, 649.0f), new Vec2(183.0f, 655.0f)};
		level3.createBody(new StdBoxPlatform(p3_1));

		Vec2[] p3_2 = {new Vec2(449.0f, 631.0f), new Vec2(712.0f, 615.0f), new Vec2(712.0f, 632.0f), new Vec2(450.0f, 647.0f)};
		level3.createBody(new StdBoxPlatform(p3_2));

		Vec2[] p3_3 = {new Vec2(674.0f, 567.0f), new Vec2(176.0f, 536.0f), new Vec2(179.0f, 553.0f), new Vec2(675.0f, 584.0f)};
		level3.createBody(new StdBoxPlatform(p3_3));

		Vec2[] p3_4 = {new Vec2(224.0f, 489.0f), new Vec2(711.0f, 461.0f), new Vec2(712.0f, 478.0f), new Vec2(225.0f, 506.0f)};
		level3.createBody(new StdBoxPlatform(p3_4));

		Vec2[] p3_5 = {new Vec2(674.0f, 412.0f), new Vec2(187.0f, 384.0f), new Vec2(185.0f, 399.0f), new Vec2(674.0f, 429.0f)};
		level3.createBody(new StdBoxPlatform(p3_5));

		Vec2[] p3_6 = {new Vec2(225.0f, 333.0f), new Vec2(710.0f, 306.0f), new Vec2(713.0f, 322.0f), new Vec2(225.0f, 350.0f)};
		level3.createBody(new StdBoxPlatform(p3_6));

		Vec2[] p3_7 = {new Vec2(524.0f, 250.0f), new Vec2(674.0f, 259.0f), new Vec2(673.0f, 272.0f), new Vec2(525.0f, 263.0f)};
		level3.createBody(new StdBoxPlatform(p3_7));

		Vec2[] p3_8 = {new Vec2(524.0f, 249.0f), new Vec2(178.0f, 247.0f), new Vec2(179.0f, 261.0f), new Vec2(525.0f, 262.0f)};
		level3.createBody(new StdBoxPlatform(p3_8));

		Vec2[] p3_9 = {new Vec2(506.0f, 181.0f), new Vec2(393.0f, 182.0f), new Vec2(394.0f, 198.0f), new Vec2(506.0f, 199.0f)};
		level3.createBody(new StdBoxPlatform(p3_9));

		Vec2[] p3_10 = {new Vec2(186.0f, 173.0f), new Vec2(236.0f, 173.0f), new Vec2(235.0f, 249.0f), new Vec2(173.0f, 250.0f)};
		level3.createBody(new StdBoxPlatform(p3_10));

		Vec2[] p3_11 = {new Vec2(341.0f, 321.0f), new Vec2(348.0f, 315.0f), new Vec2(369.0f, 314.0f), new Vec2(380.0f, 328.0f), new Vec2(339.0f, 334.0f)};
		level3.createBody(new StdBoxPlatform(p3_11));

		Vec2[] p3_12 = {new Vec2(274.0f, 447.0f), new Vec2(274.0f, 467.0f), new Vec2(307.0f, 466.0f), new Vec2(304.0f, 450.0f)};
		level3.createBody(new StdBoxPlatform(p3_12));

		Vec2[] p3_13 = {new Vec2(426.0f, 479.0f), new Vec2(428.0f, 459.0f), new Vec2(440.0f, 451.0f), new Vec2(454.0f, 460.0f), new Vec2(456.0f, 478.0f)};
		level3.createBody(new StdBoxPlatform(p3_13));

		Vec2[] p3_14 = {new Vec2(529.0f, 559.0f), new Vec2(530.0f, 542.0f), new Vec2(543.0f, 534.0f), new Vec2(556.0f, 542.0f), new Vec2(559.0f, 558.0f), new Vec2(550.0f, 565.0f)};
		level3.createBody(new StdBoxPlatform(p3_14));

		Vec2[] p3_15 = {new Vec2(230.0f, 601.0f), new Vec2(257.0f, 600.0f), new Vec2(258.0f, 635.0f), new Vec2(227.0f, 643.0f)};
		level3.createBody(new StdBoxPlatform(p3_15));

		Vec2[] p3_19 = {new Vec2(712.0f, 38.0f), new Vec2(712.0f, 655.0f), new Vec2(758.0f, 655.0f), new Vec2(758.0f, 43.0f)};
		level3.createBody(new StdBoxPlatform(p3_19));

		Vec2[] p3_20 = {new Vec2(140.0f, 58.0f), new Vec2(771.0f, 60.0f), new Vec2(770.0f, 18.0f), new Vec2(133.0f, 18.0f)};
		level3.createBody(new StdBoxPlatform(p3_20));


		// level 3 stars
		level3.addStar(new Vec2(517.0f, 450.0f), "level_3_1.png");
		level3.addStar(new Vec2(419.0f, 139.0f), "level_3_2.png");
		// level3.addStar()

		// level 3 colors
		level3.setBackgroundColor(StdDraw.GRAY);
		// level3.setShowPlatforms(true);
		level3.setPlayerColor(StdDraw.WHITE);
		levels.add(level3);

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
		currentLevel = Integer.parseInt(args[0]);
		running = true;
		Stopwatch stopwatch = new Stopwatch();
		while (running) {
			update(stopwatch.elapsedTime());
			stopwatch = new Stopwatch();
			render();
		}


	}

}