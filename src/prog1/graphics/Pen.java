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
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import prog1.base.Base;

/**
 * A pen with attributes like color, width, and line endings.
 *
 * @author michaelrohs
 */
public class Pen {

    public final Color color;
    public final double width;
    public final StrokeType type;
    public final StrokeLineCap cap;
    public final StrokeLineJoin join;
	// sr.setStrokeMiterLimit(10.0);
    // sr.setStrokeDashOffset(0.0);
    // sr.getStrokeDashArray().addAll(7.0, 21.0);

    public Pen(String color) {
        this(Graphics.color(color), 1.0, StrokeType.CENTERED, StrokeLineCap.SQUARE, StrokeLineJoin.MITER);
    }

    public Pen(Color color) {
        this(color, 1.0, StrokeType.CENTERED, StrokeLineCap.SQUARE, StrokeLineJoin.MITER);
    }

    public Pen(String color, double width) {
        this(Graphics.color(color), width, StrokeType.CENTERED, StrokeLineCap.SQUARE, StrokeLineJoin.MITER);
    }

    public Pen(Color color, double width) {
        this(color, width, StrokeType.CENTERED, StrokeLineCap.SQUARE, StrokeLineJoin.MITER);
    }

    public Pen(String color, double width, StrokeType type) {
        this(Graphics.color(color), width, type, StrokeLineCap.SQUARE, StrokeLineJoin.MITER);
    }

    public Pen(Color color, double width, StrokeType type) {
        this(color, width, type, StrokeLineCap.SQUARE, StrokeLineJoin.MITER);
    }

    public Pen(String color, double width, StrokeType type, StrokeLineCap cap, StrokeLineJoin join) {
        this(Graphics.color(color), width, type, cap, join);
    }

    public Pen(Color color, double width, StrokeType type, StrokeLineCap cap, StrokeLineJoin join) {
        this.color = color;
        this.width = width;
        this.type = type;
        this.cap = cap;
        this.join = join;
    }

    @Override
    public String toString() {
        return "Pen(" + color + ", " + width + ", " + type + ", " + cap + ", " + join + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Pen p = (Pen) o;
        return color.equals(p.color)
                && Math.abs(width - p.width) < Base.EPSILON
                && type.ordinal() == p.type.ordinal()
                && cap.ordinal() == p.cap.ordinal()
                && join.ordinal() == p.join.ordinal();
    }

    @Override
    public int hashCode() {
        return color.hashCode()
                + 31 * (int) width
                + 31 * 31 * type.ordinal()
                + 31 * 31 * 31 * cap.ordinal()
                + 31 * 31 * 31 * 31 * join.ordinal();
    }

}
