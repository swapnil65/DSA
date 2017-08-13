
public class CounterSpiral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] characterArray = {{'C', 'I', 'P', 'E'}, {'R', 'N', 'K', 'U'}, {'U', 'O', 'W', 'O'}, {'L', 'E', 'S', 'Y'}};
		char[][] charArray = {    
				{'i',	'l', 	'o', 	'v', 	'e' },
				{'d',	'i', 	'n', 	't', 	'e' },
				{'n', 	'e', 	'w', 	'e', 	'p' }, 
				{'a', 	'i', 	'v', 	'r', 	'i' }, 
				{'m',	'a', 	'x', 	'e', 	'c' } };
		int top = 0;
		int right = characterArray[0].length-1;
		int bottom = characterArray.length-1;
		int left = 0;
		
		//System.out.println(right + " " + bottom);
		
		while(true)
		{
			for(int i = right; i >= left; i--) 
				System.out.print(characterArray[top][i]);
			top++;
			
			if(top > bottom || left > right)
				break;
			
			for(int i = top; i <= bottom; i++)
				System.out.print(characterArray[i][left]);
			left++;
			
			if(top > bottom || left > right)
				break;
			
			for(int i = left; i <= right; i++)
				System.out.print(characterArray[bottom][i]);
			bottom--;
			
			if(top > bottom || left > right)
				break;
			
			for(int i = bottom; i >= top; i--)
				System.out.print(characterArray[i][right]);
			right--;
			
			if(top > bottom || left > right)
				break;

		}
		System.out.println();
		spiral2(charArray);

	}
	
	public static void spiral2(char a[][])
	{
		int top = 0;
		int right = a[0].length-1;
		int bottom = a.length-1;
		int left = 0;
		
		while(true)
		{
			for(int i=left;i<=right;i++)
				System.out.print(a[top][i]);
			top++;
			
			if(left>right || top>bottom)
				break;
			
			for(int i=top;i<=bottom;i++)
				System.out.print(a[i][right]);
			right--;
			
			if(left>right || top>bottom)
				break;
			
			for(int i=right;i>=left;i--)
				System.out.print(a[bottom][i]);
			bottom--;
			
			if(left>right || top>bottom)
				break;
			
			for(int i=bottom;i>=top;i--)
				System.out.print(a[i][left]);
			left++;
			
			if(left>right || top>bottom)
				break;
		}
		
	}
	

}
