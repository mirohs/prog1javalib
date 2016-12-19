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

import javafx.scene.input.MouseEvent;

/**
 * Function that handles mouse events.
 * @author michaelrohs
 */
public interface MouseFunction {

	/**
	 * Function that handles mouse events.
	 * @param event <a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/MouseEvent.html">JavaFX mouse event</a> (methods getX(), getY(), getSceneX(), getSceneY())
	 * @param target an arbitrary object that is supplied when registering the click function
	 */
	public void apply(MouseEvent event, Object target);
}
