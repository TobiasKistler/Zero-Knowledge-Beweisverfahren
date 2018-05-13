
public class Proofer {
	public static void main(String[] args) {
		int[][] matrix = new int[10][10];
		double a;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				a = Math.random();
				int b = (int) Math.round(a);
				matrix[i][j] = (int) b;
				

			}

		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");

			}
			System.out.println();

		}
	}
}
