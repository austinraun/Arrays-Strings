
public class MaxPathMatrix {
	public static void main(String[] args) {
		int values[][] = {{1, 2, 3, 4},{ 4, 5, 4, 3}, {4, 3, 2, 1}, {7,2,1,6}};
		int maxValue = maxPath(values);
		System.out.println(maxValue);
	}
	
	public static int maxPath(int[][] values){
		
		  int rows = values.length;
		    int cols = values[0].length;

		    int[] maxValues = new int[4];
		    
		    for (int i = 0; i < rows; ++i) {
		        for (int j = 0; j < cols; ++j) {
		            int left = 0;
		            int up = 0;
		            if (i > 0) {
		                up = maxValues[j];
		                System.out.println("up: " + up);
		            }
		            if (j > 0) {
		                left = maxValues[j - 1];
		                System.out.println("left: " + left);
		            }

		            maxValues[j] = Math.max(left, up) + values[i][j];
		            System.out.println("values["+i+"]["+j+"]:" + values[i][j]);
		            System.out.println("maxValues["+j+"]:" + maxValues[j]);
		        }
		    }

		    return maxValues[cols - 1];
		
	}
}