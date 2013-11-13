import org.jbox2d.callbacks.*;
import org.jbox2d.collision.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.pooling.*;
import org.jbox2d.profile.*;

public class StdBoxWorld extends World {

	public Body createPolygon(Vec2[] points, StdBoxPolygon userData) {
		BodyDef bd = new BodyDef();
		Body body = new Body(bd, this);

		// define body
		bd.active = true;
		bd.angle = 0.0f;
		bd.angularDamping = 0.0f;
		bd.angularVelocity = 0.0f;
		bd.fixedRotation = false;
		bd.linearDamping = 0.0f;
		bd.linearVelocity = new Vec2(0.0f, 0.0f);
		bd.position = new Vec2(0.0f, 0.0f);
		bd.type = BodyType.DYNAMIC;

		// fixture
		PolygonShape poly = new PolygonShape();
		poly.m_vertices = points;
		body.createFixture(poly, 1.0f);
		body.m_userData = userData.setBody(body);

		return body;

	}


	public void update() {

	}

	public void render() {

	}
}