import org.jbox2d.callbacks.*;
import org.jbox2d.collision.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.pooling.*;
import org.jbox2d.profile.*;

public abstract class StdBoxBody {

	private Vec2[] points;
	private Body body;

	public StdBoxBody(Vec2[] points) {
		this.points = points;
	}

	public void setBody(Body body) {
		this.body = body;
	}	

	public Body getBody() {
		return body;
	}

	public Vec2[] getPoints() {
		return points;
	}

	public double[][] getStdPoints() {
		Vec2[] pnts = getPoints();
		double[] x = new double[pnts.length];
		double[] y = new double[pnts.length];
		for (int i = 0; i < pnts.length; i++) {
			x[i] = (double)pnts[i].x;
			y[i] = (double)pnts[i].y;
		}
		double[][] p = {x,y};
		return p;
	}

	public void update(double delta) {

	}

	public void render() {

	}

}