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

/**
 * A line in front of a background image.
 * @author michaelrohs
 */
class ImageLine extends Group {

	public ImageLine(Image image, double x1, double y1, double x2, double y2, Pen pen) {
		double minX = Math.min(0, Math.min(x1, x2));
		double minY = Math.min(0, Math.min(y1, y2));
		double maxX = Math.max(image.width, Math.max(x1, x2));
		double maxY = Math.max(image.height, Math.max(y1, y2));
		width = maxX - minX;
		height = maxY - minY;
		add(image, -minX, -minY);
		add(new Line(x2 - x1, y2 - y1, pen), Math.min(x1, x2) - minX, Math.min(y1, y2) - minY);
	}

	public ImageLine(double x1, double y1, double x2, double y2, Pen pen, Image image) {
		double minX = Math.min(0, Math.min(x1, x2));
		double minY = Math.min(0, Math.min(y1, y2));
		double maxX = Math.max(image.width, Math.max(x1, x2));
		double maxY = Math.max(image.height, Math.max(y1, y2));
		width = maxX - minX;
		height = maxY - minY;
		add(new Line(x2 - x1, y2 - y1, pen), Math.min(x1, x2) - minX, Math.min(y1, y2) - minY);
		add(image, -minX, -minY);
	}

}
