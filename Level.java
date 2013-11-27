import org.jbox2d.callbacks.*;
import org.jbox2d.collision.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.pooling.*;
import org.jbox2d.profile.*;
import java.util.ArrayList;
import java.awt.Color;

public class Level extends StdBoxWorld {

	public static final int SCREEN_WIDTH = 900;
	public static final int SCREEN_HEIGHT = 700;

	private Player player;
	private ArrayList<Star> stars;
	private boolean showPlatforms;
	private Color playerColor;
	private Color platformColor;
	private Color backgroundColor;

	private class Star {
		private Vec2 pos;
		private String pic;

		public Star(Vec2 pos, String pic) {
			this.pos = pos;
			this.pic = pic;
		}

		public void render() {
			render(false);
		}

		public void render(boolean blue) {
			StdDraw.picture(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, pic);
			if (blue) {
				StdDraw.picture(pos.x, pos.y, "small_blue_star.png");
			} else {
				StdDraw.picture(pos.x, pos.y, "small_yellow_star.png");
			}

		}

		public boolean isTouching(Player player) {
			Body body = player.getBody();
			Shape shape = (body.getFixtureList().getShape());
			return shape.testPoint(new Transform(body.getTransform()), new Vec2(pos));
		}
	}

	public Level(Player player) {
		super(new Vec2(0.0f, 40.0f));
		this.createBody(player);
		this.player = player;
		this.stars = new ArrayList<Star>();
		this.playerColor = StdDraw.BLACK;
		this.platformColor = StdDraw.BLACK;
		this.backgroundColor = StdDraw.BLACK;
	}

	public Player getPlayer() {
		return player;
	}

	public void setShowPlatforms(boolean s) {
		this.showPlatforms = s;
	}

	public void addStar(Vec2 pos, String pic) {
		stars.add(new Star(pos, pic));
	}

	public boolean complete() {
		return stars.size() == 0;
	}

	public void setPlayerColor(Color color) {
		this.playerColor = color;
	}

	public void setPlatformColor(Color color) {
		this.platformColor = color;
	}

	public void setBackgroundColor(Color color) {
		this.backgroundColor = color;
	}

	public void update(double delta) {
		if (complete()) {
			return;
		}
		if (stars.get(0).isTouching(player)) {
			stars.remove(0);
		}
		super.update(delta);
	}

	public void render() {
		if (complete()) {
			return;
		}

		StdDraw.clear(backgroundColor);
		// render background and star, with the last star blue
		if (stars.size() == 1) {
			stars.get(0).render(true);
		} else {
			stars.get(0).render();
		}

		// render player
		player.render();

		// render platforms
		if (showPlatforms) {
			super.render();
		}
	}
}