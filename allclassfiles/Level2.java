
public class Level2 extends StdBoxWorld {

	private Player player;

	public Level2(Vec2 gravity) {
		super(gravity);

		Vec2[] p = {new Vec2(50.0f, 50.0f+110.0f), new Vec2(50.0f, 60.0f+110.0f), new Vec2(40.0f, 60.0f+110.0f), new Vec2(40.0f, 50.0f+110.0f)};
		player = new Player(p);
		this.createBody(player);

Vec2[] p0 = {new Vec2(0.0f, 427.0f), new Vec2(797.0f, 427.0f), new Vec2(796.0f, 461.0f), new Vec2(0.0f, 460.0f)};
this.createBody(new StdBoxPlatform(p0));

Vec2[] p1 = {new Vec2(0.0f, 437.0f), new Vec2(0.0f, 127.0f), new Vec2(4.0f, 127.0f), new Vec2(2.0f, 439.0f)};
this.createBody(new StdBoxPlatform(p1));

Vec2[] p2 = {new Vec2(46.0f, 428.0f), new Vec2(47.0f, 395.0f), new Vec2(86.0f, 395.0f), new Vec2(86.0f, 429.0f)};
this.createBody(new StdBoxPlatform(p2));

Vec2[] p3 = {new Vec2(44.0f, 400.0f), new Vec2(44.0f, 381.0f), new Vec2(89.0f, 381.0f), new Vec2(88.0f, 400.0f)};
this.createBody(new StdBoxPlatform(p3));

Vec2[] p4 = {new Vec2(89.0f, 404.0f), new Vec2(88.0f, 431.0f), new Vec2(111.0f, 431.0f), new Vec2(115.0f, 404.0f)};
this.createBody(new StdBoxPlatform(p4));

Vec2[] p5 = {new Vec2(112.0f, 380.0f), new Vec2(113.0f, 433.0f), new Vec2(136.0f, 432.0f), new Vec2(135.0f, 380.0f)};
this.createBody(new StdBoxPlatform(p5));

Vec2[] p6 = {new Vec2(136.0f, 357.0f), new Vec2(167.0f, 356.0f), new Vec2(165.0f, 424.0f), new Vec2(136.0f, 431.0f)};
this.createBody(new StdBoxPlatform(p6));

Vec2[] p7 = {new Vec2(160.0f, 334.0f), new Vec2(183.0f, 333.0f), new Vec2(185.0f, 427.0f), new Vec2(158.0f, 430.0f)};
this.createBody(new StdBoxPlatform(p7));

Vec2[] p8 = {new Vec2(182.0f, 310.0f), new Vec2(215.0f, 311.0f), new Vec2(217.0f, 432.0f), new Vec2(183.0f, 437.0f)};
this.createBody(new StdBoxPlatform(p8));

Vec2[] p9 = {new Vec2(206.0f, 287.0f), new Vec2(236.0f, 287.0f), new Vec2(236.0f, 432.0f), new Vec2(202.0f, 439.0f)};
this.createBody(new StdBoxPlatform(p9));

Vec2[] p10 = {new Vec2(229.0f, 264.0f), new Vec2(255.0f, 263.0f), new Vec2(255.0f, 435.0f), new Vec2(231.0f, 441.0f)};
this.createBody(new StdBoxPlatform(p10));

Vec2[] p11 = {new Vec2(252.0f, 240.0f), new Vec2(298.0f, 240.0f), new Vec2(297.0f, 439.0f), new Vec2(250.0f, 446.0f)};
this.createBody(new StdBoxPlatform(p11));

Vec2[] p12 = {new Vec2(485.0f, 403.0f), new Vec2(508.0f, 403.0f), new Vec2(508.0f, 442.0f), new Vec2(485.0f, 447.0f)};
this.createBody(new StdBoxPlatform(p12));

Vec2[] p13 = {new Vec2(647.0f, 446.0f), new Vec2(649.0f, 126.0f), new Vec2(662.0f, 128.0f), new Vec2(661.0f, 445.0f)};
this.createBody(new StdBoxPlatform(p13));

Vec2[] p14 = {new Vec2(578.0f, 357.0f), new Vec2(695.0f, 358.0f), new Vec2(693.0f, 383.0f), new Vec2(577.0f, 381.0f)};
this.createBody(new StdBoxPlatform(p14));

Vec2[] p15 = {new Vec2(601.0f, 311.0f), new Vec2(672.0f, 310.0f), new Vec2(673.0f, 372.0f), new Vec2(602.0f, 374.0f)};
this.createBody(new StdBoxPlatform(p15));
	}

	public void render() {
		StdDraw.picture(400, 300, "mario-1-1-edit.gif");
		player.render();
		// super.render();
	}

}