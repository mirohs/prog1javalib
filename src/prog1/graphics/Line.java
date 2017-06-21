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
 * A line.
 *
 * @author michaelrohs
 */
class Line extends Shape {

    private final double x1, y1, x2, y2;

    public Line(ApplicationBase app, double x, double y, Pen pen) {
        super(app, Math.abs(x), Math.abs(y), null, pen);
//		          x>=0, y>=0	x>=0, y<0	x<0, y>=0	x<0, y<0
//		this.x1 = 0;			0			-x			-x
//		this.y1 = 0;			-y			0			-y
//		this.x2 = x;			x			0			0
//		this.y2 = y;			0			y			0
        if (x >= 0 && y >= 0) {
            x1 = 0;
            y1 = 0;
            x2 = x;
            y2 = y;
        } else if (x >= 0 && y < 0) {
            x1 = 0;
            y1 = -y;
            x2 = x;
            y2 = 0;
        } else if (x < 0 && y >= 0) {
            x1 = -x;
            y1 = 0;
            x2 = 0;
            y2 = y;
        } else if (x < 0 && y < 0) {
            x1 = -x;
            y1 = -y;
            x2 = 0;
            y2 = 0;
        } else {
            x1 = 0;
            y1 = 0;
            x2 = 0;
            y2 = 0;
        }
    }

    @Override
    protected javafx.scene.Node render() {
        return render(new javafx.scene.shape.Line(x1, y1, x2, y2));
    }

}
