/*
 * find longest increasing sub sequence in 2d array. 
 * (bit more expl..) 
 * ex: finding length of the snake in snake game 
 * --------- 
 * the sequence must not be diagonally. 
 * but it can be any like top-bootm,bottom-left-top ........ 
 * increasing means one step 
 * ex: 10,11,12,13 (correct) 
 * 12,14,15,20(wrong) 
 * Ex: input: consider 4x4 grid 
 * 2 3 4 5 
 * 4 5 10 11 
 * 20 6 9 12 
 * 6 7 8 40 

output : 4 5 6 7 8 9 10 11 12
 */
public class IncreasingSubsequence {

	private static final int[][] board = new int[][]{
	      {2, 3, 4, 5},
	      {4, 5, 10, 11},
	      {20, 6, 9, 12},
	      {6, 7, 8, 40}};  
public static void main(String[] args){
	int max = 0;
	String sequence="";
	int[][] dp = new int[board.length][board[0].length];
	for(int i = 0; i < board.length; i++){
		for(int j = 0; j < board[0].length; j++){
			dp[i][j] = 1;
		}
	}
	int row=0;
	int column=0;
	for (int i = 0; i < board.length; i++)
	{
		for(int j = 0; j < board[0].length; j++)
		{
			if(i == 0 && j == 0)
			{
				continue;
			}
			if(i > 0 && (board[i][j]-board[i - 1][j]) == 1)
			{
				if(dp[i][j] > dp[i-1][j]+1)
				{
					sequence+=board[i][j]+" ";
					System.out.println("one"+sequence);
				}
				else
				{
					sequence+=board[i-1][j]+" ";
					System.out.println("two"+sequence);
				}
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + 1);
				max = Math.max(max,  dp[i][j]);
				row=i;
				column=j;
			}
			if(j > 0 && (board[i][j]-board[i][j-1])==1)
			{
				if(dp[i][j] > dp[i][j-1]+1)
				{
					sequence+=board[i][j]+" ";
					System.out.println("three"+sequence);
				}
				else
				{
					sequence+=board[i][j-1]+" ";
					System.out.println("four"+sequence);
				}
				dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
				max = Math.max(max,  dp[i][j]);
				row=i;
				column=j;
			}
			
		}
		
	}
	sequence+=board[row][column]+"";
	System.out.println(sequence);
	System.out.println(max);
}

}


