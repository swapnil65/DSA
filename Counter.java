import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Counter {

	
	
		  
		
	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>();
		arr.add("def");
		arr.add("abc");
		arr.add("pqr");

		Set<String> set = new HashSet<String>(arr);
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
		    String s = iter.next().toString();
			System.out.print(s);
		    System.out.println(s.length());
		}

}
}
