package gui;

import logic.SimpleBoard;
import logic.ViewData;
import logic.events.EventSource;
import logic.events.InputEventListener;
import logic.events.MoveEvent;

public class GameController implements InputEventListener{
	
	private SimpleBoard board = new SimpleBoard(25, 10);
	private final GuiController viewController;
	
	public GameController(GuiController c) {
		this.viewController = c;
		this.viewController.setEventLister(this);
		board.createNewBrick();
		this.viewController.initGameView(board.getBoardMatrix(), board.getViewData());
		this.viewController.bindScore(board.getScore().scoreProperty());
	}

	@Override
	public ViewData onDownEvent(MoveEvent event) {
		boolean canMove = board.moveBrickDown();
		if(!canMove) {
			board.mergeBrickToBackground();
			board.createNewBrick();
		}else {
			if(event.getEventSource() == EventSource.USER) {
				board.getScore().add(1);
			}
		}
		
		viewController.refreshGameBackground(board.getBoardMatrix());
		
		return board.getViewData();
	}

	@Override
	public ViewData onLeftEvent() {
		board.moveBrickLeft();
		
		return board.getViewData();
	}

	@Override
	public ViewData onRightEvent() {
		board.moveBrickRight();
		
		return board.getViewData();
	}
	
	

}
