package logic.events;

import logic.DownData;
import logic.ViewData;

public interface InputEventListener {
	
	DownData onDownEvent(MoveEvent event);
	
	ViewData onLeftEvent();
	
	ViewData onRightEvent();
	
	ViewData onRotateEvent();

}
