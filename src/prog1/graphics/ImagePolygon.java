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
 * A polygon in front of a background image.
 * @author michaelrohs
 */
class ImagePolygon extends Group {

	public ImagePolygon(Image image, double[] points, Color color, Pen pen) {
		// todo: change to Rect r = Util.boundingBoxXY(points);
		// bounding rectangle of polygon
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
		// bounding rectangle of polygon and image
		double minX = Math.min(0, x1);
		double minY = Math.min(0, y1);
		double maxX = Math.max(image.width, x2);
		double maxY = Math.max(image.height, y2);
		width = maxX - minX;
		height = maxY - minY;
		add(image, -minX, -minY);
		add(new Polygon(points, color, pen), x1 - minX, y1 - minY);
	}
	
}
