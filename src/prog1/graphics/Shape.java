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
 * An abstract shape.
 *
 * @author michaelrohs
 */
abstract class Shape extends Image {

    private final Color color;
    private final Pen pen;
    private final ApplicationBase app;

    public Shape(ApplicationBase app, double width, double height, Color color, Pen pen) {
        super(width, height);
        this.color = color;
        this.pen = pen;
        this.app = app;
    }

    @Override
    protected abstract javafx.scene.Node render();

    protected javafx.scene.Node render(javafx.scene.shape.Shape s) {
        s.setFill(color);
        if (pen != null) {
            s.setStroke(pen.color);
            s.setStrokeWidth(pen.width);
            s.setStrokeType(pen.type);
            s.setStrokeLineCap(pen.cap);
            s.setStrokeLineJoin(pen.join);
			// .setStrokeMiterLimit(10.0);
            // .setStrokeDashOffset(0.0);
            // .getStrokeDashArray().addAll(7.0, 21.0);
        } else {
            s.setStroke(null);
        }
//		if (clip != null) {
//			s.setClip(clip.render());
//		}
        if (pressFunction != null) {
//			System.out.println("Shape.render: pressFunction = " + pressFunction);
//			System.out.println(Thread.currentThread());
            s.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED, (javafx.scene.input.MouseEvent e) -> {
                pressFunction.apply(new MouseEvent(e), pressFunctionTarget);
                e.consume();
                app.draw();
            });
        }
        if (releaseFunction != null) {
//			System.out.println("Shape.render: releaseFunction = " + releaseFunction);
//			System.out.println(Thread.currentThread());
            s.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_RELEASED, (javafx.scene.input.MouseEvent e) -> {
                releaseFunction.apply(new MouseEvent(e), releaseFunctionTarget);
                e.consume();
                app.draw();
            });
        }
        if (moveFunction != null) {
            s.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_MOVED, (javafx.scene.input.MouseEvent e) -> {
                moveFunction.apply(new MouseEvent(e), moveFunctionTarget);
                e.consume();
                app.draw();
            });
        }
        if (dragFunction != null) {
            s.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_DRAGGED, (javafx.scene.input.MouseEvent e) -> {
                dragFunction.apply(new MouseEvent(e), dragFunctionTarget);
                e.consume();
                app.draw();
            });
        }
        return s;
    }

    @Override
    protected String toString(String indent) {
        return indent + String.format("<" + getClass().getSimpleName()
                + " width=\"%.1f\" height=\"%.1f\" color=\"%s\" pen=\"%s\"/>\n",
                width, height,
                color == null ? "null" : color.toString(),
                pen == null ? "null" : pen.toString());
    }

}
