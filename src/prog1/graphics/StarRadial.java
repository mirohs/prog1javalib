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
 * A radial star.
 *
 * @author michaelrohs
 */
class StarRadial extends Shape {

    private final Double[] points;

    public StarRadial(ApplicationBase app, int spikes, double innerRadius, double outerRadius, Color color, Pen pen) {
        super(app, 0, 0, color, pen);
        points = new Double[4 * spikes];
        final double alphaStep = Math.PI / spikes;
        double alpha = -Math.PI / 2;
        double x1 = Double.POSITIVE_INFINITY; // todo: use Util.boundingBoxXY with +1
        double y1 = Double.POSITIVE_INFINITY;
        double x2 = Double.NEGATIVE_INFINITY;
        double y2 = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < points.length;) {
            double x = innerRadius * Math.cos(alpha);
            double y = innerRadius * Math.sin(alpha);
            x1 = Math.min(x1, x);
            y1 = Math.min(y1, y);
            x2 = Math.max(x2, x);
            y2 = Math.max(y2, y);
            points[i++] = x;
            points[i++] = y;
            alpha += alphaStep;
            x = outerRadius * Math.cos(alpha);
            y = outerRadius * Math.sin(alpha);
            x1 = Math.min(x1, x);
            y1 = Math.min(y1, y);
            x2 = Math.max(x2, x);
            y2 = Math.max(y2, y);
            points[i++] = x;
            points[i++] = y;
            alpha += alphaStep;
        }
        for (int i = 0; i < points.length;) {
            points[i++] -= x1;
            points[i++] -= y1;
        }
        this.width = x2 - x1;
        this.height = y2 - y1;
    }

    @Override
    protected javafx.scene.Node render() {
        javafx.scene.shape.Polygon polygon = new javafx.scene.shape.Polygon();
        polygon.getPoints().setAll(points);
        return render(polygon);
    }

}
