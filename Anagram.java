/*
 * You can swap only two consecutive elements. You have to show all steps to convert a string
 * into another string (both strings will be anagrams of each other). E.g. GUM to MUG 
	GUM 
	GMU 
	MGU 
	MUG 
 */
public class Anagram 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		char a[] = "TEHUNOOL".toCharArray();
		//StringBuffer sb = new StringBuffer("GUM");
        //char b[] = sb.reverse().toString().toCharArray();
		char b[]= "ONLEHTUO".toCharArray();
        char temp;
        int n = b.length;
        int j, i = 0;
        System.out.println(a);
        while(n > i) 
        {
               j = i;
               while(a[j] != b[i]) 
               {
                  j++;
               }
               
               while(j > i) 
               {
                   temp = a[j];
                   a[j] = a[j-1];
                   a[j-1] = temp;
                   System.out.println(a);
                   j--;
               }
               
               i++;
        }
    }
	
}
