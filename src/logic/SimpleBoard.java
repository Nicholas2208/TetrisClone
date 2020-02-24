package logic;

import java.awt.Point;

import logic.bricks.Brick;
import logic.bricks.RandomBrickGenerator;

public class SimpleBoard {

	private final int width;
	private final int height;
	private int[][] currentGameMatrix;
	private final RandomBrickGenerator brickGenerator;
	private Brick brick;
	private int currentShape = 0;
	private Point currentOffset;
	private Score score;

	public SimpleBoard(int width, int height) {
		this.width = width;
		this.height = height;
		currentGameMatrix = new int[width][height];
		brickGenerator = new RandomBrickGenerator();
		score = new Score();
	}

	public boolean createNewBrick() {
		Brick currentBrick = brickGenerator.getBrick();
		setBrick(currentBrick);
		currentOffset = new Point(4, 0);

		return true;
	}

	public boolean moveBrickDown() {
		Point p = new Point(currentOffset);
		p.translate(0, 1);
		currentOffset = p;
		boolean conflict = MatrixOperations.intersects(currentGameMatrix, getCurrentShape(), p.x, p.y);
		if (conflict) {
			return false;
		} else {
			currentOffset = p;
			return true;
		}
	}

	public boolean moveBrickLeft() {
		Point p = new Point(currentOffset);
		p.translate(-1, 0);

		boolean conflict = MatrixOperations.intersects(currentGameMatrix, getCurrentShape(), p.x, p.y);
		if (conflict) {
			return false;
		} else {
			currentOffset = p;
			return true;
		}
	}

	public boolean moveBrickRight() {
		Point p = new Point(currentOffset);
		p.translate(1, 0);

		boolean conflict = MatrixOperations.intersects(currentGameMatrix, getCurrentShape(), p.x, p.y);
		if (conflict) {
			return false;
		} else {
			currentOffset = p;
			return true;
		}
	}

	public ViewData getViewData() {
		return new ViewData(getCurrentShape(),
				currentOffset.x,
				currentOffset.y,
				brickGenerator.getNextBrick().getBrickMatrix().get(0));
	}

	public int[][] getCurrentShape() {
		return this.brick.getBrickMatrix().get(currentShape);
	}

	public void setBrick(Brick brick) {
		this.brick = brick;
		currentOffset = new Point(4, 0);
	}

	public Score getScore() {
		return score;
	}

	public int[][] getBoardMatrix() {
		return currentGameMatrix;
	}

	public void mergeBrickToBackground() {
		currentGameMatrix = MatrixOperations.merge(currentGameMatrix, getCurrentShape(), currentOffset.x,
				currentOffset.y);

	}

}
