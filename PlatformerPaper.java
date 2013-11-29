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

		// ##       ######## ##     ## ######## ##          ##        
		// ##       ##       ##     ## ##       ##          ##    ##  
		// ##       ##       ##     ## ##       ##          ##    ##  
		// ##       ######   ##     ## ######   ##          ##    ##  
		// ##       ##        ##   ##  ##       ##          ######### 
		// ##       ##         ## ##   ##       ##                ##  
		// ######## ########    ###    ######## ########          ##  
		// level 4 player
		Vec2[] player4Points = {new Vec2(64.0f, 473.0f), new Vec2(64.0f, 447.0f), new Vec2(76.0f, 447.0f), new Vec2(76.0f, 473.0f)};
		Player player4 = new Player(player4Points);
		Level level4 = new Level(player4);
		player4.setJumpForce(3000000.0f);
		player4.setGroundForce(6000.0f);
		player4.setAirForce(6000.0f);
		player4.setMaxSpeed(100.0f);
		// level 4 platforms
		Vec2[] p4_0 = {new Vec2(48.0f, 478.0f), new Vec2(849.0f, 478.0f), new Vec2(866.0f, 510.0f), new Vec2(37.0f, 508.0f)};
		level4.createBody(new StdBoxPlatform(p4_0));

		Vec2[] p4_1 = {new Vec2(50.0f, 481.0f), new Vec2(51.0f, 43.0f), new Vec2(36.0f, 46.0f), new Vec2(44.0f, 501.0f)};
		level4.createBody(new StdBoxPlatform(p4_1));

		Vec2[] p4_2 = {new Vec2(850.0f, 504.0f), new Vec2(848.0f, 34.0f), new Vec2(865.0f, 35.0f), new Vec2(860.0f, 504.0f)};
		level4.createBody(new StdBoxPlatform(p4_2));

		Vec2[] p4_3 = {new Vec2(48.0f, 49.0f), new Vec2(851.0f, 40.0f), new Vec2(821.0f, 16.0f), new Vec2(61.0f, 22.0f)};
		level4.createBody(new StdBoxPlatform(p4_3));

		Vec2[] p4_4 = {new Vec2(96.0f, 485.0f), new Vec2(97.0f, 452.0f), new Vec2(135.0f, 451.0f), new Vec2(136.0f, 486.0f)};
		level4.createBody(new StdBoxPlatform(p4_4));

		Vec2[] p4_5 = {new Vec2(94.0f, 432.0f), new Vec2(139.0f, 432.0f), new Vec2(139.0f, 450.0f), new Vec2(94.0f, 451.0f)};
		level4.createBody(new StdBoxPlatform(p4_5));

		Vec2[] p4_6 = {new Vec2(140.0f, 454.0f), new Vec2(162.0f, 454.0f), new Vec2(163.0f, 430.0f), new Vec2(185.0f, 430.0f), new Vec2(185.0f, 482.0f), new Vec2(139.0f, 479.0f)};
		level4.createBody(new StdBoxPlatform(p4_6));

		Vec2[] p4_7 = {new Vec2(185.0f, 480.0f), new Vec2(185.0f, 407.0f), new Vec2(209.0f, 407.0f), new Vec2(209.0f, 384.0f), new Vec2(232.0f, 384.0f), new Vec2(232.0f, 497.0f)};
		level4.createBody(new StdBoxPlatform(p4_7));

		Vec2[] p4_8 = {new Vec2(232.0f, 480.0f), new Vec2(232.0f, 360.0f), new Vec2(255.0f, 360.0f), new Vec2(255.0f, 337.0f), new Vec2(278.0f, 337.0f), new Vec2(280.0f, 489.0f)};
		level4.createBody(new StdBoxPlatform(p4_8));

		Vec2[] p4_9 = {new Vec2(278.0f, 477.0f), new Vec2(278.0f, 313.0f), new Vec2(302.0f, 313.0f), new Vec2(301.0f, 290.0f), new Vec2(349.0f, 290.0f), new Vec2(349.0f, 493.0f)};
		level4.createBody(new StdBoxPlatform(p4_9));

		Vec2[] p4_10 = {new Vec2(536.0f, 483.0f), new Vec2(535.0f, 453.0f), new Vec2(559.0f, 453.0f), new Vec2(559.0f, 483.0f)};
		level4.createBody(new StdBoxPlatform(p4_10));

		Vec2[] p4_11 = {new Vec2(651.0f, 409.0f), new Vec2(651.0f, 360.0f), new Vec2(722.0f, 360.0f), new Vec2(721.0f, 415.0f)};
		level4.createBody(new StdBoxPlatform(p4_11));

		Vec2[] p4_12 = {new Vec2(628.0f, 407.0f), new Vec2(744.0f, 407.0f), new Vec2(744.0f, 428.0f), new Vec2(629.0f, 427.0f)};
		level4.createBody(new StdBoxPlatform(p4_12));


		// level 4 stars
		level4.addStar(new Vec2(336.0f, 272.0f), "level_4_1.png");
		level4.addStar(new Vec2(685.0f, 454.0f), "level_4_2.png");
		// level4.addStar()

		// level 4 colors
		level4.setBackgroundColor(StdDraw.GRAY);
		// level4.setShowPlatforms(true);
		level4.setPlayerColor(StdDraw.RED);
		levels.add(level4);

		// ##       ######## ##     ## ######## ##          ######## 
		// ##       ##       ##     ## ##       ##          ##       
		// ##       ##       ##     ## ##       ##          ##       
		// ##       ######   ##     ## ######   ##          #######  
		// ##       ##        ##   ##  ##       ##                ## 
		// ##       ##         ## ##   ##       ##          ##    ## 
		// ######## ########    ###    ######## ########     ######  
		// level 5 player
		Vec2[] player5Points = {new Vec2(70.0f, 590.0f), new Vec2(70.0f, 558.0f), new Vec2(86.0f, 558.0f), new Vec2(86.0f, 590.0f)};
		Player player5 = new Player(player5Points);
		Level level5 = new Level(player5);
		player5.setJumpForce(3000000.0f);
		player5.setGroundForce(30000.0f);
		player5.setAirForce(8000.0f);
		player5.setMaxSpeed(1000.0f);
		// level 5 platforms
		Vec2[] p5_0 = {new Vec2(7.0f, 0.0f), new Vec2(11.0f, 699.0f), new Vec2(0.0f, 697.0f), new Vec2(0.0f, 1.0f)};
		level5.createBody(new StdBoxPlatform(p5_0));

		Vec2[] p5_1 = {new Vec2(889.0f, 696.0f), new Vec2(892.0f, 2.0f), new Vec2(896.0f, 1.0f), new Vec2(897.0f, 695.0f)};
		level5.createBody(new StdBoxPlatform(p5_1));

		Vec2[] p5_2 = {new Vec2(6.0f, 8.0f), new Vec2(893.0f, 12.0f), new Vec2(895.0f, 1.0f), new Vec2(5.0f, 0.0f)};
		level5.createBody(new StdBoxPlatform(p5_2));

		Vec2[] p5_3 = {new Vec2(9.0f, 694.0f), new Vec2(890.0f, 691.0f), new Vec2(890.0f, 680.0f), new Vec2(8.0f, 683.0f)};
		level5.createBody(new StdBoxPlatform(p5_3));

		Vec2[] p5_20 = {new Vec2(0.0f, 638.0f), new Vec2(6.0f, 647.0f), new Vec2(10.0f, 634.0f)};
		level5.createBody(new StdBoxPlatform(p5_20));

		Vec2[] p5_21 = {new Vec2(10.0f, 634.0f), new Vec2(30.0f, 660.0f), new Vec2(64.0f, 644.0f)};
		level5.createBody(new StdBoxPlatform(p5_21));

		Vec2[] p5_22 = {new Vec2(64.0f, 644.0f), new Vec2(86.0f, 663.0f), new Vec2(91.0f, 638.0f)};
		level5.createBody(new StdBoxPlatform(p5_22));

		Vec2[] p5_23 = {new Vec2(91.0f, 638.0f), new Vec2(165.0f, 670.0f), new Vec2(261.0f, 637.0f)};
		level5.createBody(new StdBoxPlatform(p5_23));

		Vec2[] p5_24 = {new Vec2(261.0f, 637.0f), new Vec2(281.0f, 661.0f), new Vec2(318.0f, 645.0f)};
		level5.createBody(new StdBoxPlatform(p5_24));

		Vec2[] p5_25 = {new Vec2(322.0f, 646.0f), new Vec2(356.0f, 677.0f), new Vec2(359.0f, 637.0f)};
		level5.createBody(new StdBoxPlatform(p5_25));

		Vec2[] p5_26 = {new Vec2(359.0f, 637.0f), new Vec2(434.0f, 676.0f), new Vec2(552.0f, 637.0f)};
		level5.createBody(new StdBoxPlatform(p5_26));

		Vec2[] p5_27 = {new Vec2(552.0f, 637.0f), new Vec2(582.0f, 662.0f), new Vec2(617.0f, 645.0f)};
		level5.createBody(new StdBoxPlatform(p5_27));

		Vec2[] p5_28 = {new Vec2(617.0f, 645.0f), new Vec2(641.0f, 668.0f), new Vec2(658.0f, 645.0f)};
		level5.createBody(new StdBoxPlatform(p5_28));

		Vec2[] p5_29 = {new Vec2(658.0f, 645.0f), new Vec2(719.0f, 663.0f), new Vec2(720.0f, 637.0f)};
		level5.createBody(new StdBoxPlatform(p5_29));

		Vec2[] p5_30 = {new Vec2(720.0f, 637.0f), new Vec2(753.0f, 659.0f), new Vec2(776.0f, 636.0f)};
		level5.createBody(new StdBoxPlatform(p5_30));

		Vec2[] p5_31 = {new Vec2(776.0f, 636.0f), new Vec2(807.0f, 667.0f), new Vec2(819.0f, 644.0f)};
		level5.createBody(new StdBoxPlatform(p5_31));

		Vec2[] p5_32 = {new Vec2(819.0f, 644.0f), new Vec2(827.0f, 660.0f), new Vec2(832.0f, 644.0f)};
		level5.createBody(new StdBoxPlatform(p5_32));

		Vec2[] p5_33 = {new Vec2(832.0f, 644.0f), new Vec2(885.0f, 662.0f), new Vec2(861.0f, 637.0f)};
		level5.createBody(new StdBoxPlatform(p5_33));

		Vec2[] p5_34 = {new Vec2(861.0f, 637.0f), new Vec2(891.0f, 647.0f), new Vec2(898.0f, 617.0f)};
		level5.createBody(new StdBoxPlatform(p5_34));

		Vec2[] p5_8 = {new Vec2(542.0f, 547.0f), new Vec2(548.0f, 539.0f), new Vec2(729.0f, 539.0f), new Vec2(733.0f, 546.0f), new Vec2(729.0f, 556.0f), new Vec2(549.0f, 556.0f)};
		level5.createBody(new StdBoxPlatform(p5_8));

		Vec2[] p5_9 = {new Vec2(43.0f, 483.0f), new Vec2(58.0f, 483.0f), new Vec2(56.0f, 495.0f), new Vec2(42.0f, 497.0f)};
		level5.createBody(new StdBoxPlatform(p5_9));

		Vec2[] p5_10 = {new Vec2(123.0f, 517.0f), new Vec2(136.0f, 516.0f), new Vec2(136.0f, 526.0f), new Vec2(123.0f, 530.0f)};
		level5.createBody(new StdBoxPlatform(p5_10));

		Vec2[] p5_11 = {new Vec2(202.0f, 483.0f), new Vec2(214.0f, 485.0f), new Vec2(214.0f, 495.0f), new Vec2(204.0f, 496.0f)};
		level5.createBody(new StdBoxPlatform(p5_11));

		Vec2[] p5_12 = {new Vec2(299.0f, 483.0f), new Vec2(310.0f, 484.0f), new Vec2(311.0f, 497.0f), new Vec2(300.0f, 496.0f)};
		level5.createBody(new StdBoxPlatform(p5_12));

		Vec2[] p5_13 = {new Vec2(380.0f, 517.0f), new Vec2(390.0f, 516.0f), new Vec2(391.0f, 528.0f), new Vec2(381.0f, 529.0f)};
		level5.createBody(new StdBoxPlatform(p5_13));

		Vec2[] p5_14 = {new Vec2(458.0f, 484.0f), new Vec2(472.0f, 485.0f), new Vec2(472.0f, 497.0f), new Vec2(459.0f, 496.0f)};
		level5.createBody(new StdBoxPlatform(p5_14));

		Vec2[] p5_15 = {new Vec2(541.0f, 484.0f), new Vec2(549.0f, 483.0f), new Vec2(549.0f, 498.0f), new Vec2(538.0f, 497.0f)};
		level5.createBody(new StdBoxPlatform(p5_15));

		Vec2[] p5_16 = {new Vec2(811.0f, 499.0f), new Vec2(810.0f, 512.0f), new Vec2(826.0f, 511.0f), new Vec2(826.0f, 498.0f)};
		level5.createBody(new StdBoxPlatform(p5_16));

		Vec2[] p5_17 = {new Vec2(817.0f, 607.0f), new Vec2(830.0f, 601.0f), new Vec2(846.0f, 612.0f), new Vec2(838.0f, 625.0f), new Vec2(818.0f, 625.0f), new Vec2(814.0f, 617.0f)};
		level5.createBody(new StdBoxPlatform(p5_17));

		Vec2[] p5_18 = {new Vec2(596.0f, 511.0f), new Vec2(568.0f, 512.0f), new Vec2(568.0f, 543.0f), new Vec2(598.0f, 544.0f)};
		level5.createBody(new StdBoxPlatform(p5_18));


		// level 5 stars
		level5.addStar(new Vec2(677.0f, 467.0f), "level_5_1.png");

		// level 5 colors
		level5.setBackgroundColor(StdDraw.GRAY);
		// level5.setShowPlatforms(true);
		level5.setPlayerColor(StdDraw.RED);
		levels.add(level5);

		// ##       ######## ##     ## ######## ##           #######  
		// ##       ##       ##     ## ##       ##          ##     ## 
		// ##       ##       ##     ## ##       ##          ##        
		// ##       ######   ##     ## ######   ##          ########  
		// ##       ##        ##   ##  ##       ##          ##     ## 
		// ##       ##         ## ##   ##       ##          ##     ## 
		// ######## ########    ###    ######## ########     #######  
		Vec2[] player6Points = {new Vec2(82.0f, 283.0f), new Vec2(101.0f, 283.0f), new Vec2(101.0f, 248.0f), new Vec2(82.0f, 248.0f)};
		Player player6 = new Player(player6Points);
		Level level6 = new Level(player6);
		player6.setJumpForce(3000000.0f);
		player6.setGroundForce(30000.0f);
		player6.setAirForce(6000.0f);
		player6.setMaxSpeed(100.0f);
		// level 6 platforms
		Vec2[] p6_20 = {new Vec2(73.0f, 85.0f), new Vec2(74.0f, 626.0f), new Vec2(54.0f, 665.0f), new Vec2(49.0f, 42.0f)};
		level6.createBody(new StdBoxPlatform(p6_20));

		Vec2[] p6_21 = {new Vec2(73.0f, 289.0f), new Vec2(99.0f, 305.0f), new Vec2(125.0f, 290.0f)};
		level6.createBody(new StdBoxPlatform(p6_21));

		Vec2[] p6_22 = {new Vec2(125.0f, 290.0f), new Vec2(135.0f, 300.0f), new Vec2(145.0f, 289.0f)};
		level6.createBody(new StdBoxPlatform(p6_22));

		Vec2[] p6_23 = {new Vec2(145.0f, 289.0f), new Vec2(146.0f, 300.0f), new Vec2(164.0f, 298.0f)};
		level6.createBody(new StdBoxPlatform(p6_23));

		Vec2[] p6_24 = {new Vec2(164.0f, 298.0f), new Vec2(178.0f, 314.0f), new Vec2(188.0f, 300.0f)};
		level6.createBody(new StdBoxPlatform(p6_24));

		Vec2[] p6_25 = {new Vec2(188.0f, 300.0f), new Vec2(194.0f, 314.0f), new Vec2(212.0f, 307.0f)};
		level6.createBody(new StdBoxPlatform(p6_25));

		Vec2[] p6_26 = {new Vec2(213.0f, 306.0f), new Vec2(222.0f, 313.0f), new Vec2(220.0f, 302.0f)};
		level6.createBody(new StdBoxPlatform(p6_26));

		Vec2[] p6_27 = {new Vec2(220.0f, 302.0f), new Vec2(231.0f, 308.0f), new Vec2(229.0f, 296.0f)};
		level6.createBody(new StdBoxPlatform(p6_27));

		Vec2[] p6_28 = {new Vec2(229.0f, 296.0f), new Vec2(234.0f, 306.0f), new Vec2(242.0f, 299.0f)};
		level6.createBody(new StdBoxPlatform(p6_28));

		Vec2[] p6_29 = {new Vec2(242.0f, 299.0f), new Vec2(241.0f, 309.0f), new Vec2(250.0f, 311.0f)};
		level6.createBody(new StdBoxPlatform(p6_29));

		Vec2[] p6_30 = {new Vec2(250.0f, 310.0f), new Vec2(248.0f, 326.0f), new Vec2(254.0f, 316.0f)};
		level6.createBody(new StdBoxPlatform(p6_30));

		Vec2[] p6_31 = {new Vec2(254.0f, 316.0f), new Vec2(285.0f, 344.0f), new Vec2(316.0f, 333.0f)};
		level6.createBody(new StdBoxPlatform(p6_31));

		Vec2[] p6_32 = {new Vec2(317.0f, 333.0f), new Vec2(339.0f, 305.0f), new Vec2(317.0f, 284.0f)};
		level6.createBody(new StdBoxPlatform(p6_32));

		Vec2[] p6_33 = {new Vec2(317.0f, 284.0f), new Vec2(359.0f, 259.0f), new Vec2(360.0f, 211.0f)};
		level6.createBody(new StdBoxPlatform(p6_33));

		Vec2[] p6_34 = {new Vec2(360.0f, 211.0f), new Vec2(361.0f, 185.0f), new Vec2(408.0f, 194.0f)};
		level6.createBody(new StdBoxPlatform(p6_34));

		Vec2[] p6_35 = {new Vec2(360.0f, 212.0f), new Vec2(363.0f, 247.0f), new Vec2(396.0f, 262.0f)};
		level6.createBody(new StdBoxPlatform(p6_35));

		Vec2[] p6_36 = {new Vec2(396.0f, 262.0f), new Vec2(448.0f, 260.0f), new Vec2(464.0f, 232.0f)};
		level6.createBody(new StdBoxPlatform(p6_36));

		Vec2[] p6_37 = {new Vec2(464.0f, 232.0f), new Vec2(497.0f, 247.0f), new Vec2(528.0f, 230.0f)};
		level6.createBody(new StdBoxPlatform(p6_37));

		Vec2[] p6_38 = {new Vec2(528.0f, 230.0f), new Vec2(546.0f, 180.0f), new Vec2(528.0f, 131.0f)};
		level6.createBody(new StdBoxPlatform(p6_38));

		Vec2[] p6_39 = {new Vec2(528.0f, 131.0f), new Vec2(553.0f, 131.0f), new Vec2(551.0f, 109.0f)};
		level6.createBody(new StdBoxPlatform(p6_39));

		Vec2[] p6_40 = {new Vec2(551.0f, 109.0f), new Vec2(600.0f, 64.0f), new Vec2(559.0f, 17.0f)};
		level6.createBody(new StdBoxPlatform(p6_40));


		// level 6 stars
		level6.addStar(new Vec2(510.0f, 216.0f), "level_6_1.png");
		level6.addStar(new Vec2(85.0f, 273.0f), "level_6_2.png");
		// level6.addStar()

		// level 6 colors
		level6.setBackgroundColor(StdDraw.GRAY);
		// level6.setShowPlatforms(true);
		level6.setPlayerColor(StdDraw.RED);
		levels.add(level6);

		// ##       ######## ##     ## ######## ##          ######## 
		// ##       ##       ##     ## ##       ##          ##    ## 
		// ##       ##       ##     ## ##       ##              ##   
		// ##       ######   ##     ## ######   ##             ##    
		// ##       ##        ##   ##  ##       ##            ##     
		// ##       ##         ## ##   ##       ##            ##     
		// ######## ########    ###    ######## ########      ##     
		Vec2[] player7Points = {new Vec2(136.0f, 128.0f), new Vec2(136.0f, 156.0f), new Vec2(148.0f, 156.0f), new Vec2(148.0f, 128.0f)};
		Player player7 = new Player(player7Points);
		Level level7 = new Level(player7);
		player7.setJumpForce(3000000.0f);
		player7.setGroundForce(30000.0f);
		player7.setAirForce(7000.0f);
		player7.setMaxSpeed(100.0f);
		// level 7 platforms
		Vec2[] p7_20 = {new Vec2(125.0f, 94.0f), new Vec2(103.0f, 49.0f), new Vec2(90.0f, 670.0f), new Vec2(126.0f, 632.0f)};
		level7.createBody(new StdBoxPlatform(p7_20));

		Vec2[] p7_21 = {new Vec2(100.0f, 615.0f), new Vec2(58.0f, 658.0f), new Vec2(779.0f, 656.0f), new Vec2(760.0f, 614.0f)};
		level7.createBody(new StdBoxPlatform(p7_21));

		Vec2[] p7_22 = {new Vec2(121.0f, 92.0f), new Vec2(805.0f, 98.0f), new Vec2(848.0f, 56.0f), new Vec2(107.0f, 66.0f)};
		level7.createBody(new StdBoxPlatform(p7_22));

		Vec2[] p7_23 = {new Vec2(751.0f, 623.0f), new Vec2(758.0f, 89.0f), new Vec2(794.0f, 74.0f), new Vec2(773.0f, 643.0f)};
		level7.createBody(new StdBoxPlatform(p7_23));

		Vec2[] p7_24 = {new Vec2(127.0f, 163.0f), new Vec2(159.0f, 323.0f), new Vec2(296.0f, 382.0f)};
		level7.createBody(new StdBoxPlatform(p7_24));

		Vec2[] p7_25 = {new Vec2(296.0f, 382.0f), new Vec2(375.0f, 361.0f), new Vec2(394.0f, 305.0f)};
		level7.createBody(new StdBoxPlatform(p7_25));

		Vec2[] p7_26 = {new Vec2(394.0f, 304.0f), new Vec2(409.0f, 443.0f), new Vec2(539.0f, 503.0f)};
		level7.createBody(new StdBoxPlatform(p7_26));

		Vec2[] p7_27 = {new Vec2(539.0f, 503.0f), new Vec2(571.0f, 505.0f), new Vec2(570.0f, 473.0f)};
		level7.createBody(new StdBoxPlatform(p7_27));

		Vec2[] p7_28 = {new Vec2(570.0f, 473.0f), new Vec2(603.0f, 572.0f), new Vec2(697.0f, 613.0f)};
		level7.createBody(new StdBoxPlatform(p7_28));

		// level 7 stars
		level7.addStar(new Vec2(709.0f, 601.0f), "level_7_1.png");
		// level7.addStar()

		// level 7 colors
		level7.setBackgroundColor(StdDraw.GRAY);
		// level7.setShowPlatforms(true);
		level7.setPlayerColor(StdDraw.RED);
		levels.add(level7);

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
		levels.get(currentLevel).render();
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.text(20, 15, frc.getFPS()+"");
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