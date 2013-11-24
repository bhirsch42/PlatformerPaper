import org.jbox2d.callbacks.*;
import org.jbox2d.collision.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.pooling.*;
import org.jbox2d.profile.*;

public class StdBoxPolygon extends StdBoxBody {

	public StdBoxPolygon(Vec2[] points) {
		super(points);
	}

	public BodyType getType() {
		return BodyType.DYNAMIC;
	}

	@Override
	public void setBody(Body body) {
		body.m_userData = this;
		body.setType(this.getType());

		// create fixture
		PolygonShape poly = new PolygonShape();
		Vec2[] p = super.getPoints();
		poly.set(p, p.length);

		FixtureDef fixDef = new FixtureDef();
		fixDef.shape = poly;
		fixDef.density = 1.0f;

		body.createFixture(fixDef);
		super.setBody(body);
	}

	public Vec2[] getPoints() {
		Body body = this.getBody();
		PolygonShape shape = (PolygonShape)(body.getFixtureList().getShape());
		Vec2[] ans = new Vec2[shape.getVertexCount()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = body.getWorldPoint(shape.getVertices()[i]);
		}
		// System.out.println(ans[0].x + ", " + ans[1].y);
		// System.out.println(ans[2] + "\t" + super.getPoints()[0]);
		// System.out.println(body.getAngle());
		return ans;
	}

	public void update(double delta) {
		super.update(delta);
	}

	public void render() {
		double[][] p = this.getStdPoints();
		StdDraw.filledPolygon(p[0], p[1]);
	}

}