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

	@Override
	public void setBody(Body body) {
		body.setType(BodyType.STATIC);
		super.setBody(body);
	}


}