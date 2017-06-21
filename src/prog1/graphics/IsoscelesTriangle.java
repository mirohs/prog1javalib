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
 * A triangle with two sides of equal length.
 *
 * @author michaelrohs
 */
class IsoscelesTriangle extends Shape {

    public IsoscelesTriangle(ApplicationBase app, double length, double alpha, Color color, Pen pen) {
		// 180 - 90 - a2
        // height = Math.sin((90 - alpha / 2) * Math.PI / 180)
        // width = 2 * Math.cos((90 - alpha / 2) * Math.PI / 180)
        super(app, 0, 0, color, pen);
        double a = (90 - alpha / 2) * Math.PI / 180;
        this.width = 2 * length * Math.cos(a);
        this.height = length * Math.sin(a);
    }

    @Override
    protected javafx.scene.Node render() {
        javafx.scene.shape.Polygon polygon = new javafx.scene.shape.Polygon();
        polygon.getPoints().addAll(new Double[]{
            0.0, height,
            width, height,
            width / 2.0, 0.0});
        return render(polygon);
    }

}
