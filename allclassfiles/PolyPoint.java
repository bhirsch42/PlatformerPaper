import java.util.ArrayList;

public class PolyPoint {
	
	private ArrayList<Float> xList;
	private ArrayList<Float> yList;

	public PolyPoint() {
		xList = new ArrayList<Float>();
		yList = new ArrayList<Float>();
	}

	public int size() {
		return xList.size();
	}

	public void removeLast() {
		if (xList.size() == 0) {
			return;
		}
		xList.remove(xList.size()-1);
		yList.remove(yList.size()-1);
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
			System.out.println("Vec2[] p" + (i+20) + " = " + polyPoint);
			System.out.println("this.createBody(new StdBoxPlatform(p" + (i+20) + "));");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String pic = args[0];
		int width = 900;
		int height = 700;
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(height, 0);

		ArrayList<PolyPoint> polyPoints = new ArrayList<PolyPoint>();

		boolean mouseWasPressed = false;
		boolean keySpaceWasTyped = false;
		boolean keyZWasPressed = false;
		PolyPoint polyPoint = new PolyPoint();
		StdDraw.setPenColor(StdDraw.GREEN);
		while(true) {
			// render
			StdDraw.show(30);
			StdDraw.clear();
			StdDraw.picture(width/2, height/2, pic);//, width, height);
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
			if (StdDraw.isKeyPressed(32) && !keySpaceWasTyped) {
				keySpaceWasTyped = true;
				// pressed space key
				polyPoints.add(polyPoint);
				polyPoint = new PolyPoint();
				printAllPoints(polyPoints);
			}
			if (!StdDraw.isKeyPressed(32)) {
				keySpaceWasTyped = false;
			}
			if (StdDraw.isKeyPressed(90) && !keyZWasPressed) {
				keyZWasPressed = true;
				// pressed Z key
				if (polyPoint.size() > 0) {
					polyPoint.removeLast();
				} else if (polyPoints.size() > 0) {
					polyPoints.remove(polyPoints.size()-1);
				}
			}
			if (!StdDraw.isKeyPressed(90)) {
				keyZWasPressed = false;
			}
		}

	}

}