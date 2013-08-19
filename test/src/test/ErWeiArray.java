package test;

public class ErWeiArray {
	   public static void main(String[] args) {
	        int[][] arrSource = {{1, 2, 3, 4},
	            {4, 5, 6, 7}};
	        int[][] arrTarget = {{7, 8, 9, 10},
	            {10, 11, 12, 13, 14}
	        };
	        int[][][] result = myMatch(arrSource, arrTarget);
	        System.out.println(result);

	        for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result.length; j++) {
					for (int j2 = 0; j2 < result.length; j2++) {
						System.out.print(result[i][j][j2]);
					}
				}
			}
	    }

	    /***
	     * 合并两二维数组
	     * @param arr1
	     * @param arr2
	     * @return
	     */
	    private static int[][] arrUnion(int[][] arr1, int[][] arr2) {
	        int newRowCount = arr1.length + arr2.length;
	        int newColCount = arr1[0].length > arr2[0].length ? arr1[0].length : arr2[0].length;
	        int[][] unionedArr = new int[newRowCount][newColCount];
	        for (int i = 0; i < arr1.length; i++) {
	            for (int j = 0; j < arr1[0].length; j++) {
	                unionedArr[i][j] = arr1[i][j];
	            }
	        }
	        for (int i = arr1.length; i < newRowCount; i++) {
	            for (int j = 0; j < arr2[0].length; j++) {
	                unionedArr[i][j] = arr2[i + arr2.length - newRowCount][j];
	            }
	        }
	        return unionedArr;
	    }

	    /***
	     * 自定义匹配
	     * @param arrSource
	     * @param arrTarget
	     * @return
	     */
	    private static int[][][] myMatch(int[][] arrSource, int[][] arrTarget) {
	        int[][][] result = new int[arrSource[0].length][arrSource.length][arrSource[0].length];
	        for (int curCol = 0; curCol < arrSource[0].length; curCol++) {
	            int[][] arrSource2 = new int[arrSource.length][arrSource[0].length];
	            for (int i = 0; i < arrSource.length; i++) {
	                for (int j = 0; j < arrSource[0].length; j++) {
	                    arrSource2[i][j] = arrSource[i][curCol];
	                }
	            }
	            int[][] arrUnioned = arrUnion(arrSource2, arrTarget);
	            result[curCol] = arrUnioned;
	        }
	        return result;
	    }
}
class Test{
	public static void main(String[] args) {
		int[][] num={{1},{2,3},{4,5,6}};
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				System.out.print(" "+num[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		
	}
}
