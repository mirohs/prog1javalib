/*
 * Copyright 2017 michaelrohs.
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
 *
 * @author michaelrohs
 */
public class MouseEvent {
	
	/**
	 * The coordinates of the mouse event.
	 */
	public final double x, y;
	
	/**
	 * Which mouse button is down.
	 */
	public final boolean primaryButtonDown, secondaryButtonDown, middleButtonDown;
	
	/**
	 * Which modifier key is down.
	 */
	public final boolean shiftDown, controlDown, altDown, metaDown;

	/**
	 * Protected constructor. MouseEvents are only generated by the library itself.
	 * @param x
	 * @param y
	 * @param primaryButtonDown
	 * @param secondaryButtonDown
	 * @param middleButtonDown
	 * @param shiftDown
	 * @param controlDown
	 * @param altDown
	 * @param metaDown 
	 */
	protected MouseEvent(double x, double y, boolean primaryButtonDown, boolean secondaryButtonDown, boolean middleButtonDown, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown) {
		this.x = x;
		this.y = y;
		this.primaryButtonDown = primaryButtonDown;
		this.secondaryButtonDown = secondaryButtonDown;
		this.middleButtonDown = middleButtonDown;
		this.shiftDown = shiftDown;
		this.controlDown = controlDown;
		this.altDown = altDown;
		this.metaDown = metaDown;
	}
	
	/**
	 * Copy constructor.
	 * @param e mouse event
	 */
	protected MouseEvent(javafx.scene.input.MouseEvent e) {
		this(e.getSceneX(), e.getSceneY(), 
				e.isPrimaryButtonDown(), e.isSecondaryButtonDown(), e.isMiddleButtonDown(), 
				e.isShiftDown(), e.isControlDown(), e.isAltDown(), e.isMetaDown());
	}
			
			
	@Override
	public String toString() {
		return "MouseEvent(" + "x = " + x + ", y = " + y + 
				", primaryButtonDown = " + primaryButtonDown + 
				", secondaryButtonDown = " + secondaryButtonDown + 
				", middleButtonDown = " + middleButtonDown + 
				", shiftDown = " + shiftDown + 
				", controlDown = " + controlDown + 
				", altDown = " + altDown + 
				", metaDown = " + metaDown + ')';
	}
	
}
