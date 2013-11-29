
public class Level1 extends StdBoxWorld {

	private Player player;

	public Level1(Vec2 gravity) {
		super(gravity);

		// player
		Vec2[] p = {new Vec2(389.0f, 380.0f), new Vec2(409.0f, 380.0f), new Vec2(409.0f, 421.0f), new Vec2(389.0f, 421.0f)};
		player = new Player(p) {
			public void render() {
				Vec2 pos = getBody().getWorldCenter();
				StdDraw.picture(pos.x, pos.y, "DK_mario_small.png");
			}
		};
		player.setAirForce(10000.0f);
		player.setGroundForce(40000.0f);
		player.setJumpForce(1000000000.0f);
		this.createBody(player);

		// platforms
		Vec2[] p0 = {new Vec2(135.0f, 104.0f), new Vec2(138.0f, 700.0f), new Vec2(102.0f, 700.0f), new Vec2(100.0f, 103.0f)};
		this.createBody(new StdBoxPlatform(p0));

		Vec2[] p1 = {new Vec2(102.0f, 103.0f), new Vec2(700.0f, 104.0f), new Vec2(700.0f, 121.0f), new Vec2(101.0f, 117.0f)};
		this.createBody(new StdBoxPlatform(p1));

		Vec2[] p2 = {new Vec2(664.0f, 700.0f), new Vec2(657.0f, 103.0f), new Vec2(697.0f, 105.0f), new Vec2(698.0f, 703.0f)};
		this.createBody(new StdBoxPlatform(p2));

		Vec2[] p3 = {new Vec2(139.0f, 684.0f), new Vec2(401.0f, 683.0f), new Vec2(401.0f, 703.0f), new Vec2(134.0f, 705.0f)};
		this.createBody(new StdBoxPlatform(p3));

		Vec2[] p4 = {new Vec2(661.0f, 669.0f), new Vec2(396.0f, 685.0f), new Vec2(398.0f, 707.0f), new Vec2(667.0f, 698.0f)};
		this.createBody(new StdBoxPlatform(p4));

		Vec2[] p5 = {new Vec2(625.0f, 620.0f), new Vec2(139.0f, 592.0f), new Vec2(140.0f, 606.0f), new Vec2(623.0f, 635.0f)};
		this.createBody(new StdBoxPlatform(p5));

		Vec2[] p6 = {new Vec2(177.0f, 542.0f), new Vec2(661.0f, 513.0f), new Vec2(661.0f, 529.0f), new Vec2(176.0f, 558.0f)};
		this.createBody(new StdBoxPlatform(p6));

		Vec2[] p7 = {new Vec2(624.0f, 465.0f), new Vec2(139.0f, 436.0f), new Vec2(139.0f, 451.0f), new Vec2(625.0f, 480.0f)};
		this.createBody(new StdBoxPlatform(p7));

		Vec2[] p8 = {new Vec2(178.0f, 388.0f), new Vec2(662.0f, 359.0f), new Vec2(662.0f, 374.0f), new Vec2(176.0f, 402.0f)};
		this.createBody(new StdBoxPlatform(p8));

		Vec2[] p9 = {new Vec2(623.0f, 311.0f), new Vec2(474.0f, 301.0f), new Vec2(474.0f, 317.0f), new Vec2(624.0f, 325.0f)};
		this.createBody(new StdBoxPlatform(p9));

		Vec2[] p10 = {new Vec2(473.0f, 302.0f), new Vec2(133.0f, 301.0f), new Vec2(132.0f, 313.0f), new Vec2(478.0f, 315.0f)};
		this.createBody(new StdBoxPlatform(p10));

		Vec2[] p11 = {new Vec2(345.0f, 236.0f), new Vec2(456.0f, 236.0f), new Vec2(456.0f, 249.0f), new Vec2(345.0f, 249.0f)};
		this.createBody(new StdBoxPlatform(p11));

		Vec2[] p12 = {new Vec2(137.0f, 225.0f), new Vec2(182.0f, 226.0f), new Vec2(184.0f, 299.0f), new Vec2(138.0f, 300.0f)};
		this.createBody(new StdBoxPlatform(p12));

		Vec2[] p13 = {new Vec2(292.0f, 390.0f), new Vec2(292.0f, 370.0f), new Vec2(324.0f, 370.0f), new Vec2(326.0f, 390.0f)};
		this.createBody(new StdBoxPlatform(p13));

		Vec2[] p14 = {new Vec2(222.0f, 500.0f), new Vec2(222.0f, 522.0f), new Vec2(261.0f, 522.0f), new Vec2(260.0f, 500.0f)};
		this.createBody(new StdBoxPlatform(p14));

		Vec2[] p15 = {new Vec2(377.0f, 508.0f), new Vec2(377.0f, 531.0f), new Vec2(409.0f, 529.0f), new Vec2(406.0f, 509.0f), new Vec2(391.0f, 505.0f)};
		this.createBody(new StdBoxPlatform(p15));

		Vec2[] p16 = {new Vec2(480.0f, 617.0f), new Vec2(480.0f, 596.0f), new Vec2(494.0f, 588.0f), new Vec2(506.0f, 595.0f), new Vec2(509.0f, 612.0f), new Vec2(509.0f, 619.0f)};
		this.createBody(new StdBoxPlatform(p16));

		Vec2[] p17 = {new Vec2(227.0f, 688.0f), new Vec2(229.0f, 669.0f), new Vec2(236.0f, 661.0f), new Vec2(249.0f, 665.0f), new Vec2(255.0f, 677.0f), new Vec2(253.0f, 687.0f)};
		this.createBody(new StdBoxPlatform(p17));

		Vec2[] p18 = {new Vec2(181.0f, 686.0f), new Vec2(181.0f, 655.0f), new Vec2(208.0f, 656.0f), new Vec2(207.0f, 688.0f)};
		this.createBody(new StdBoxPlatform(p18));
	}
	public void render() {
		StdDraw.picture(400, 400, "donkey-kong-cross-tensions_171.jpg");
		StdDraw.setPenColor(StdDraw.GREEN);
		player.render();
		// super.render();
	}

}