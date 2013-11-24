import java.util.ArrayList;

public class PolyPoint {
	
	private ArrayList<Float> xList;
	private ArrayList<Float> yList;

	public PolyPoint() {
		xList = new ArrayList<Float>();
		yList = new ArrayList<Float>();
	}

	public void addPoint(int x, int y) {
		xList.add((float)x);
		yList.add((float)y);
	}

	public void draw() {
		if (xList.size() < 2) {
			return;
		}
		double[] xs = new double[xList.size()];
		double[] ys = new double[yList.size()];
		for (int i = 0; i < xs.length; i++) {
			xs[i] = (double)xList.get(i);
			ys[i] = (double)yList.get(i);
		}
		StdDraw.polygon(xs, ys);
	}

	public String toString() {
		String s = "{";
		for (int i = 0; i < xList.size(); i++) {
			float x = xList.get(i);
			float y = yList.get(i);
			s += "new Vec2(" + x + "f" + ", " + y + "f" + ")";
			if (i == xList.size() - 1) {
				s += "};";
			} else {
				s += ", ";
			}
		}
		return s;
	}

	public static void printAllPoints(ArrayList<PolyPoint> polyPoints) {
		System.out.println("***");
		for (int i = 0; i < polyPoints.size(); i++) {
			PolyPoint polyPoint = polyPoints.get(i);
			System.out.println("Vec2[] p" + (i+8) + " = " + polyPoint);
			System.out.println("world.createBody(new StdBoxPlatform(p" + (i+8) + "));");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String pic = args[0];
		int width = 800;
		int height = 600;
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(height, 0);

		ArrayList<PolyPoint> polyPoints = new ArrayList<PolyPoint>();

		boolean mouseWasPressed = false;
		boolean keyWasTyped = false;
		PolyPoint polyPoint = new PolyPoint();

		while(true) {
			// render
			StdDraw.show(30);
			StdDraw.clear();
			StdDraw.picture(width/2, height/2, pic);
			for (PolyPoint p : polyPoints) {
				p.draw();
			}
			polyPoint.draw();
			// interact
			if (StdDraw.mousePressed() && !mouseWasPressed) {				
				mouseWasPressed = true;
				// clicked mouse
				polyPoint.addPoint((int)StdDraw.mouseX(), (int)StdDraw.mouseY());
			}
			if (!StdDraw.mousePressed()) {
				mouseWasPressed = false;
			}
			if (StdDraw.isKeyPressed(32) && !keyWasTyped) {
				keyWasTyped = true;
				// pressed a key
				polyPoints.add(polyPoint);
				polyPoint = new PolyPoint();
				printAllPoints(polyPoints);
			}
			if (!StdDraw.isKeyPressed(32)) {
				keyWasTyped = false;
			}
		}

	}

}