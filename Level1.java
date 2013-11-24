import org.jbox2d.callbacks.*;
import org.jbox2d.collision.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.pooling.*;
import org.jbox2d.profile.*;

public class Level1 extends StdBoxWorld {

	private Player player;

	public Level1(Vec2 gravity) {
		super(gravity);

		Vec2[] p = {new Vec2(50.0f, 50.0f+110.0f), new Vec2(50.0f, 60.0f+110.0f), new Vec2(40.0f, 60.0f+110.0f), new Vec2(40.0f, 50.0f+110.0f)};
		player = new Player(p);
		this.createBody(player);

		Vec2[] p0 = {new Vec2(90.0f, 428.0f), new Vec2(90.0f, 406.0f), new Vec2(112.0f, 406.0f), new Vec2(112.0f, 427.0f)};
		this.createBody(new StdBoxPlatform(p0));

		Vec2[] p1 = {new Vec2(114.0f, 383.0f), new Vec2(135.0f, 383.0f), new Vec2(136.0f, 427.0f), new Vec2(112.0f, 427.0f)};
		this.createBody(new StdBoxPlatform(p1));

		Vec2[] p2 = {new Vec2(137.0f, 360.0f), new Vec2(159.0f, 359.0f), new Vec2(159.0f, 427.0f), new Vec2(136.0f, 427.0f)};
		this.createBody(new StdBoxPlatform(p2));

		Vec2[] p3 = {new Vec2(160.0f, 336.0f), new Vec2(182.0f, 336.0f), new Vec2(183.0f, 427.0f), new Vec2(159.0f, 427.0f)};
		this.createBody(new StdBoxPlatform(p3));

		Vec2[] p4 = {new Vec2(183.0f, 313.0f), new Vec2(205.0f, 313.0f), new Vec2(206.0f, 427.0f), new Vec2(184.0f, 427.0f)};
		this.createBody(new StdBoxPlatform(p4));

		Vec2[] p5 = {new Vec2(207.0f, 290.0f), new Vec2(229.0f, 290.0f), new Vec2(229.0f, 427.0f), new Vec2(207.0f, 427.0f)};
		this.createBody(new StdBoxPlatform(p5));

		Vec2[] p6 = {new Vec2(230.0f, 266.0f), new Vec2(252.0f, 266.0f), new Vec2(253.0f, 427.0f), new Vec2(230.0f, 428.0f)};
		this.createBody(new StdBoxPlatform(p6));

		Vec2[] p7 = {new Vec2(254.0f, 244.0f), new Vec2(299.0f, 244.0f), new Vec2(299.0f, 428.0f), new Vec2(254.0f, 428.0f)};
		this.createBody(new StdBoxPlatform(p7));

		Vec2[] p8 = {new Vec2(0.0f, 429.0f), new Vec2(0.0f, 463.0f), new Vec2(798.0f, 464.0f), new Vec2(798.0f, 429.0f)};
		this.createBody(new StdBoxPlatform(p8));

		Vec2[] p9 = {new Vec2(47.0f, 430.0f), new Vec2(48.0f, 405.0f), new Vec2(86.0f, 406.0f), new Vec2(86.0f, 427.0f)};
		this.createBody(new StdBoxPlatform(p9));

		Vec2[] p10 = {new Vec2(45.0f, 403.0f), new Vec2(45.0f, 384.0f), new Vec2(88.0f, 385.0f), new Vec2(88.0f, 403.0f)};
		this.createBody(new StdBoxPlatform(p10));

		Vec2[] p11 = {new Vec2(487.0f, 426.0f), new Vec2(487.0f, 406.0f), new Vec2(507.0f, 406.0f), new Vec2(507.0f, 426.0f)};
		this.createBody(new StdBoxPlatform(p11));

		Vec2[] p12 = {new Vec2(579.0f, 428.0f), new Vec2(579.0f, 360.0f), new Vec2(696.0f, 360.0f), new Vec2(695.0f, 428.0f)};
		this.createBody(new StdBoxPlatform(p12));

		Vec2[] p13 = {new Vec2(602.0f, 358.0f), new Vec2(602.0f, 314.0f), new Vec2(671.0f, 314.0f), new Vec2(671.0f, 359.0f)};
		this.createBody(new StdBoxPlatform(p13));

	}

	public void render() {
		StdDraw.picture(400, 300, "mario-1-1.gif");
		player.render();
		// super.render();
	}

}