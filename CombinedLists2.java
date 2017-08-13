import java.util.HashSet;
import java.util.Iterator;

/*
 * There are two room mates. Each one prepares a list for grocery store. Make a combined list without any duplicates.
 */

public class CombinedLists2 {

	
	public static  HashSet<String> generateCombinedLists(String a[],String b[])
	{
		HashSet<String> hash = new HashSet<String>();
		for(int i=0;i<a.length;i++)
		{
			hash.add(a[i]);
		}
		for(int j=0;j<b.length;j++)
		{
			hash.add(b[j]);
		}
		
		return hash;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] l1 = { "a", "b", "c", "d", "e" };
		String[] l2 = { "f", "b", "g", "d", "h" };

		HashSet<String> hashSet = generateCombinedLists(l1, l2);
		Iterator<String> itr = hashSet.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
	}


