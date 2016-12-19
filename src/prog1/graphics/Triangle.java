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
 * An equilateral triangle.
 * @author michaelrohs
 */
class Triangle extends Shape {

	public Triangle(double length, Color color, Pen pen) {
		super(length, length * Math.sqrt(0.75), color, pen);
		// (length/2)^2 + height^2 = length^2
		// height^2 = length^2 - (length/2)^2
		// height^2 = length^2 - 0.25 * length^2
	}
	
	@Override
	protected javafx.scene.Node render() {
		javafx.scene.shape.Polygon polygon = new javafx.scene.shape.Polygon();
		polygon.getPoints().addAll(new Double[] {
			0.0, height,
			width, height,
			width / 2.0, 0.0});
		return render(polygon);
	}

}
