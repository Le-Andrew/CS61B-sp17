public class creative_ex_1b {
	public static void drawTriangle(int N) {
		int col = 0;
		int row = 0;
		
		while (row < N) {
			col = 0;
			while (col <= row) {
				System.out.print('*');	
				col = col + 1;
			}
			System.out.println();	
			row = row + 1;
		}
	}
	public static void main(String[] args) {
		drawTriangle(10);
	}
}