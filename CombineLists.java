import java.util.Iterator;
import java.util.TreeSet;

/*
 * There are two room mates. Each one prepares a list for grocery store. 
 * Make a combined list without any duplicates.
 */
public class CombineLists
{
	public static TreeSet<String> getCombinedList(String[] l1, String[] l2)
	{
		TreeSet<String> hashSet = new TreeSet<String>();

		for (int i = 0; i < l1.length; i++)
		{
			if (hashSet.add(l1[i].toLowerCase()))
			{
				continue;
			}
		}

		for (int i = 0; i < l2.length; i++)
		{
			if (!hashSet.contains(l2[i].toLowerCase()))
			{
				hashSet.add(l2[i]);
			}
		}

		return hashSet;
	}

	public static void main(String[] args)
	{
		String[] l1 = { "a", "b", "c", "d", "e" };
		String[] l2 = { "f", "b", "g", "d", "h" };

		TreeSet<String> hashSet = getCombinedList(l1, l2);
		Iterator<String> itr = hashSet.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
}