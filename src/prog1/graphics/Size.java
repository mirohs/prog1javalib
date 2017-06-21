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

import prog1.base.Base;

/**
 * Information about width and height.
 *
 * @author michaelrohs
 */
public class Size {

    public final double width, height;

    public Size(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "(" + width + ", " + height + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Size s = (Size) o;
        return Math.abs(width - s.width) < Base.EPSILON
                && Math.abs(height - s.height) < Base.EPSILON;
    }

    @Override
    public int hashCode() {
        return (int) (31 * 31 * width + 31 * 31 * 31 * height);
    }

}
