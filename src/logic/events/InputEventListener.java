package logic.events;

import logic.ViewData;

public interface InputEventListener {
	
	ViewData onDownEvent(MoveEvent event);
	
	ViewData onLeftEvent();
	
	ViewData onRightEvent();

}
