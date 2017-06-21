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
 * A circle.
 *
 * @author michaelrohs
 */
class Circle extends Shape {

    public Circle(ApplicationBase app, double radius, Color color, Pen pen) {
        super(app, 2.0 * radius, 2.0 * radius, color, pen);
    }

    @Override
    protected javafx.scene.Node render() {
        double r = width / 2.0;
        return render(new javafx.scene.shape.Circle(r, r, r));
    }

}
