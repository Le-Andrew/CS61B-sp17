

public class exercise2 {
   public static int max(int[] m) {
       int max = Integer.MIN_VALUE;
	   for (int index = 0; index < m.length; index++) {
		   if (m[index] > max) {
			   max = m[index];
		   }
	   }
	   return max;
   }
   public static void main(String[] args) {
		int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
		System.out.println(max(numbers));
   }
}