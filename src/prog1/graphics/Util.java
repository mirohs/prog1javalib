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

import javafx.geometry.Point2D;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

/**
 * Static utility methods.
 *
 * @author michaelrohs
 */
public class Util {

    /**
     * The identity transformation.
     */
    public final static Transform identityTransform = new Affine();

    /**
     * This class is meant to be used in a static way.
     */
    private Util() {
    }

    /**
     * Computes the greatest factor that is contained in both x and y.
     *
     * @param x x
     * @param y y
     * @return greatest common divisor
     */
    public static int greatestCommonDivisor(int x, int y) {
        if (y > x) {
            return greatestCommonDivisor(y, x);
        }
        int rest = x % y;
        while (rest != 0) {
            x = y;
            y = rest;
            rest = x % y;
        }
        return y;
    }

    /**
     * Returns the bounding box of the points under the given affine
     * transformation.
     *
     * @param t affine transform
     * @param ps points as alternating x and y coordinates
     * @return the bounding box
     */
    public static Rect boundingBoxXY(Transform t, double... ps) {
        double x1 = Double.POSITIVE_INFINITY;
        double y1 = Double.POSITIVE_INFINITY;
        double x2 = Double.NEGATIVE_INFINITY;
        double y2 = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < ps.length;) {
            double x = ps[i++];
            double y = ps[i++];
            Point2D p = t.transform(x, y);
            x1 = Math.min(x1, p.getX());
            y1 = Math.min(y1, p.getY());
            x2 = Math.max(x2, p.getX());
            y2 = Math.max(y2, p.getY());
        }
        return new Rect(x1, y1, x2 - x1, y2 - y1);
    }

    /**
     * If x is between xMin and xMax, then return x; if x is less than xMin,
     * then return xMin; if x is greater than xMax, then return xMax.
     *
     * @param x value to clamp
     * @param xMin lower bound
     * @param xMax upper bound
     * @return the clamped value
     */
    public static double clamp(double x, double xMin, double xMax) {
        return (x < xMin) ? xMin : ((x > xMax) ? xMax : x);
    }

    /**
     * If x is between xMin and xMax, then return x; if x is less than xMin,
     * then return xMin; if x is greater than xMax, then return xMax.
     *
     * @param x value to clamp
     * @param xMin lower bound
     * @param xMax upper bound
     * @return the clamped value
     */
    public static int clamp(int x, int xMin, int xMax) {
        return (x < xMin) ? xMin : ((x > xMax) ? xMax : x);
    }

}
