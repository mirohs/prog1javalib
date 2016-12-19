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
 * Information about a rectangle.
 * @author michaelrohs
 */
public class Rect {
	public final double x, y, width, height;

	public Rect(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Point center() {
		return new Point(x + width / 2.0, y + height / 2.0);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + width + ", " + height + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (getClass() != o.getClass()) return false;
		Rect r = (Rect) o;
		return  Math.abs(x - r.x) < Base.EPSILON && 
				Math.abs(y - r.y) < Base.EPSILON && 
				Math.abs(width - r.width) < Base.EPSILON && 
				Math.abs(height - r.height) < Base.EPSILON;
	}

	@Override
	public int hashCode() {
		return (int)(x + 31 * y + 31 * 31 * width + 31 * 31 * 31 * height);
	}
	
}
