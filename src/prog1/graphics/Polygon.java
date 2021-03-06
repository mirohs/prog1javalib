/*
 * Copyright 2016 michaelrohs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package prog1.graphics;

import javafx.scene.paint.Color;

/**
 * A polygon.
 * @author michaelrohs
 */
class Polygon extends Shape {
	private final Double[] points;

	public Polygon(double[] points, Color color, Pen pen) {
		super(0, 0, color, pen);
		if ((points.length & 1) == 1) {
			throw new IllegalArgumentException(
					"even number of coordinates required: points.length == " + points.length);
		}
		double x1 = Double.POSITIVE_INFINITY;
		double y1 = Double.POSITIVE_INFINITY;
		double x2 = Double.NEGATIVE_INFINITY;
		double y2 = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < points.length;) {
			double x = points[i++];
			double y = points[i++];
			x1 = Math.min(x1, x);
			y1 = Math.min(y1, y);
			x2 = Math.max(x2, x);
			y2 = Math.max(y2, y);
		}
		this.width = x2 - x1;
		this.height = y2 - y1;
		this.points = new Double[points.length];
		for (int i = 0; i < points.length; ) {
			this.points[i] = points[i] - x1;
			i++;
			this.points[i] = points[i] - y1;
			i++;
		}
	}
	
	@Override
	protected javafx.scene.Node render() {
		javafx.scene.shape.Polygon polygon = new javafx.scene.shape.Polygon();
		polygon.getPoints().setAll(points);
		return render(polygon);
	}

}
