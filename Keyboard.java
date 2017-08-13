/*
 * SMS Problem 
 * 1 - NULL, 2 - ABC, 3 - DEF, 4 - GHI, 5 - JKL, 6 - MON, 7 - PQRS, 8 - TUV, 9 - WXYZ, * - <Space>, # - <Break> 
 * We must convert the numbers to text. 
 * Eg 
 * I/P - O/P 
 * 22 - B 
 * 23 - AD 
 * 223 - BD 
 * 22#2 - BA (# breaks the cycle) 
 * 3#33 - DE 
 * 2222 - 2 
 * 2222#2 - 2A 
 * 22222 - A (cycle must wrap around) 
 * 222222 - B
 */



public class Keyboard {
	public static void main(String[] args){
		String text1 = "2222";
		String text2 = "2222#2";
		String text3 = "77#7766";
		Keyboard k = new Keyboard();
		k.decode(text1);
		System.out.println();
		k.decode(text2);
		System.out.println();
		k.decode(text3);
		System.out.println();
	}

	public void decode(String str){

		for(int i =0; i < str.length();i++)
		{
			int count = 1;int j;
			for (j = i+1; j < str.length(); j++)
			{
				if (str.charAt(i) == str.charAt(j))
				{
					count++;
				}
				else break;
			}
			char t;
			if (str.charAt(i) != '#') 
			{
				t = getChar(str.charAt(i), count);
				System.out.print(t);
			}
			i = j - 1;
		}
	}

	/**
	 * returns the char for a given num and count
	 * @param num
	 * @param count
	 * @return 
	 */
	public char getChar(char num, int count){
		switch (num){
		case '2': 
			//System.out.println("It is a 2");
			if (count % 4 == 1) return 'A';
			if (count % 4 == 2) return 'B';
			if (count % 4 == 3) return 'C';
			if (count % 4 == 0) return '2';
			break;
		case '3':
			if (count % 4 == 1) return 'D';
			if (count % 4 == 2) return 'E';
			if (count % 4 == 3) return 'F';
			if (count % 4 == 0) return '3';
			break;
		case '4':
			if (count % 4 == 1) return 'G';
			if (count % 4 == 2) return 'H';
			if (count % 4 == 3) return 'I';
			if (count % 4 == 0) return '4';
			break;
		case '5':
			if (count % 4 == 1) return 'J';
			if (count % 4 == 2) return 'K';
			if (count % 4 == 3) return 'L';
			if (count % 4 == 0) return '5';
			break;
		case '6':
			if (count % 4 == 1) return 'M';
			if (count % 4 == 2) return 'N';
			if (count % 4 == 3) return 'O';
			if (count % 4 == 0) return '6';
			break;
		case '7':
			if (count % 5 == 1) return 'P';
			if (count % 5 == 2) return 'Q';
			if (count % 5 == 3) return 'R';
			if (count % 5 == 4) return 'S';
			if (count % 5 == 0) return '7';
			break;
		case '8':
			if (count % 4 == 1) return 'S';
			if (count % 4 == 2) return 'T';
			if (count % 4 == 3) return 'U';
			if (count % 4 == 0) return '8';
			break;
		case '9':
			if (count % 5 == 1) return 'W';
			if (count % 5 == 2) return 'X';
			if (count % 5 == 3) return 'Y';
			if (count % 5 == 4) return 'Z';
			if (count % 5 == 0) return '9';
			break;
		}
		return '0';
	}
}