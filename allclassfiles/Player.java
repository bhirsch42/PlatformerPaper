import org.jbox2d.callbacks.*;
import org.jbox2d.collision.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.pooling.*;
import org.jbox2d.profile.*;

public class Player extends StdBoxPolygon {


	private boolean wWasPressed = false;;
	private float jumpForce;
	private float groundForce;
	private float airForce;
	private float maxSpeed;


	public Player(Vec2[] points) {
		super(points);
		this.jumpForce = 80000.0f;
		this.groundForce = 5000.0f;
		this.airForce = 1000.0f;
		this.maxSpeed = Float.MAX_VALUE;
	}

	public void setDensity(float f) {
		getBody().getFixtureList().setDensity(f);
	}

	public void setJumpForce(float f) {
		this.jumpForce = f;
	}

	public void setGroundForce(float f) {
		this.groundForce = f;
	}

	public void setAirForce(float f) {
		this.airForce = f;
	}

	public void setMaxSpeed(float f) {
		this.maxSpeed = f;
	}

	public boolean isTouchingGround() {
		Vec2[] points = this.getPoints();
		float lowest = points[0].y;
		float rightest = points[0].x;
		float leftest = points[0].x;

		for (Vec2 p : points) {
			if (p.y > lowest) {
				lowest = p.y;
			}
			if (p.x > rightest) {
				rightest = p.x;
			}
			if (p.x < leftest) {
				leftest = p.x;
			}
		}

		Vec2 center = getBody().getWorldCenter();
		Body body = getBody();
		StdBoxWorld world = (StdBoxWorld)(body.getWorld());

		Vec2 groundPointCenter = new Vec2(center.x, lowest + 2.0f);
		Vec2 groundPointLeft = new Vec2(leftest, lowest + 2.0f);
		Vec2 groundPointRight = new Vec2(rightest, lowest + 2.0f);

		// StdDraw.setPenColor(StdDraw.RED);
		// StdDraw.circle(groundPointCenter.x, groundPointCenter.y, 1.0);
		// StdDraw.setPenColor(StdDraw.BLACK);

		return world.pointIsInsideBody(groundPointCenter) ||
		world.pointIsInsideBody(groundPointLeft) ||
		world.pointIsInsideBody(groundPointRight);
	}

	public void setBody(Body body) {
		body.setFixedRotation(true);
		super.setBody(body);
	}

	@Override
	public void update(double delta) {
		// get user input
		Body body = this.getBody();
		Vec2 linVel = body.getLinearVelocity();
		boolean canMove = true;
		float force = airForce;
		if (isTouchingGround()) {
			force = groundForce;
		}
		float jump = jumpForce;
		if (canMove) {
			if (StdDraw.isKeyPressed(65)) {								// A
				if (linVel.x > -maxSpeed) {
					body.applyForceToCenter(new Vec2(-force, 0.0f));
				}
			}
			if (StdDraw.isKeyPressed(87) && !wWasPressed) {				// W
				if (linVel.y > -maxSpeed && isTouchingGround()) {
					body.applyForceToCenter(new Vec2(0.0f, -jump));
				}
				wWasPressed = true;
			}
			if (!StdDraw.isKeyPressed(87)) {
				wWasPressed = false;
			}
			if (StdDraw.isKeyPressed(68)) {								//D
				if (linVel.x < maxSpeed) {
					body.applyForceToCenter(new Vec2(force, 0.0f));
				}
			}
		}

		super.update(delta);

	}

}