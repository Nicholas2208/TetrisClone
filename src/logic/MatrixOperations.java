package logic;

public class MatrixOperations {

	public static boolean intersects(int[][] matrix, int[][] brick, int x, int y) {
		for (int i = 0; i < brick.length; i++) {
			for (int j = 0; j < brick[i].length; j++) {
				int targetX = x + i;
				int targetY = y + j;
				if (brick[j][i] != 0 && 
						(outOfBounds(matrix, targetX, targetY) || matrix[targetY][targetX] != 0)) {
					return true;
				}
			}
		}

		return false;
	}

	public static int[][] merge(int[][] filledFields, int[][] brick, int x, int y) {
		int[][] copy = copy(filledFields);
		
		for(int i = 0; i < brick.length; i++) {
			for(int j = 0; j < brick[i].length; j++) {
				int targetX = x + i;
				int targetY = y + j;
				if(brick[j][i] != 0) {
					copy[targetY - 1][targetX] = brick[j][i];
				}
			}
		}
			
		return copy;
	}

	public static int[][] copy(int[][] original) {
		int[][] myInt = new int[original.length][];
		for (int i = 0; i < original.length; i++) {
			int[] aMatrix = original[i];
			int aLength = aMatrix.length;
			myInt[i] = new int[aLength];
			System.arraycopy(aMatrix, 0, myInt[i], 0, aLength);
		}

		return myInt;
	}

	private static boolean outOfBounds(int[][] matrix, int targetX, int targetY) {
		if (targetX >= 0 && targetY < matrix.length && targetX < matrix[targetY].length) {
			return false;
		}

		return true;
	}

}
