import java.util.Arrays;
import java.util.HashMap;

public class Dictionary {

    public static void main(String[] args){

    String[] Dictionary=new String[]{"dog","god","tool","loot","rose","sore"};

    HashMap<String,String> h=new HashMap<String, String>();

    for(int i=0;i<Dictionary.length;i++){

        char temp[] = Dictionary[i].toCharArray();

        Arrays.sort(temp);//sorted word e.g dgo for dog
        
        String strTemp = String.valueOf(temp);

        if(!h.containsKey(strTemp)){
            
        	h.put(strTemp,Dictionary[i]);
        }

        else
        {
           String s=h.get(strTemp);
           h.put(strTemp,s + ","+ Dictionary[i]);
        }
    }

    String s = "tolo";
    char []word = s.toCharArray();
    Arrays.sort(word);

    String sortedword = String.valueOf(word);

    if(h.containsKey(sortedword.toLowerCase())){ //used lowercase to make the words case sensitive

        System.out.println("Anagrams from Dictionary for word-->" + s + ": " + h.get(sortedword.toLowerCase()));
    }

}
}
