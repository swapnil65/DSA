/*
 * All elements in the array are repeated thrice except one
 * The problem is to find out that element with frequency 1
 */


public class ElementNotRepeatedThrice {
	
	public int getUniqueElement(int a[]){
		
		int ones=0;
		int twos=0;
		int notThrees=0;
		for(int i=0; i < a.length; i++){
			
			int x = a[i];
			twos |= ones & x;
			ones ^= x;
			
			notThrees = ~(ones & twos);
			ones &= notThrees;
			twos &= notThrees;
		}
		return ones;
	}

	public static void main(String[] args) {
		
		int a [] = {1, 1, 20, 3, 3, 20, 20, 15, 4, 1, 4, 3, 4};
		ElementNotRepeatedThrice e = new ElementNotRepeatedThrice();
		System.out.println(e.getUniqueElement(a));
	}

}
