import org.jbox2d.callbacks.*;
import org.jbox2d.collision.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.pooling.*;
import org.jbox2d.profile.*;

public class StdBoxPlatform extends StdBoxPolygon {

	public StdBoxPlatform(Vec2[] points) {
		super(points);
	}

	public BodyType getType() {
		return BodyType.STATIC;
	}

	// @Override
	// public void setBody(Body body) {
	// 	body.m_userData = this;
	// 	body.setType(this.getType());

	// 	// create fixture
	// 	ChainShape poly = new ChainShape();
	// 	Vec2[] p = super.getPoints();
	// 	poly.createLoop(p, p.length);

	// 	FixtureDef fixDef = new FixtureDef();
	// 	fixDef.shape = poly;
	// 	fixDef.density = 1.0f;

	// 	body.createFixture(fixDef);
	// 	super.setBody(body);
	// }

	// public Vec2[] getPoints() {
	// 	Body body = this.getBody();
	// 	ChainShape shape = (ChainShape)(body.getFixtureList().getShape());
	// 	Vec2[] ans = new Vec2[shape.getChildCount()];
	// 	for (int i = 0; i < shape.getChildCount(); i++) {
	// 		ans[i] = body.getWorldPoint(super.getPoints()[i]);
	// 	}
	// 	return ans;
	// }

	// public void render() {
	// 	double[][] p = this.getStdPoints();
	// 	StdDraw.filledPolygon(p[0], p[1]);
	// }

	public void update(double delta) {
		super.update(delta);
	}

}