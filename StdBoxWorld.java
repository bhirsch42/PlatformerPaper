import org.jbox2d.callbacks.*;
import org.jbox2d.collision.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.pooling.*;
import org.jbox2d.profile.*;

public class StdBoxWorld extends World {

	public StdBoxWorld(Vec2 gravity) {
		super(gravity);
	}

	public Body createBody(StdBoxBody stdBoxBody) {
		BodyDef bd = new BodyDef();
		bd.userData = stdBoxBody;
		bd.active = true;

		Body body = this.createBody(bd);
		stdBoxBody.setBody(body);

		return body;
	}

	public boolean pointIsInsideBody(Vec2 point) {
		Body body = this.getBodyList();
		for (int i = 0; i < this.getBodyCount(); i++) {
			Shape shape = (body.getFixtureList().getShape());
			if (shape.testPoint(new Transform(body.getTransform()), new Vec2(point))) {
				return true;
			}
			body = body.getNext();
		}
		return false;
	}


	public void update(double delta) {
		this.step(1.0f/60.0f, 10, 10);
		Body body = this.getBodyList();
		for (int i = 0; i < this.getBodyCount(); i++) {
			((StdBoxBody)(body.getUserData())).update(delta);
			body = body.getNext();
		}
	}

	public void render() {
		Body body = this.getBodyList();
		for (int i = 0; i < this.getBodyCount(); i++) {
			((StdBoxBody)(body.getUserData())).render();
			body = body.getNext();
		}
	}
}