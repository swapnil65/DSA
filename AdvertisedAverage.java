import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
 * Written Test
 */
/**********************************************************************
 * 2.write a program to diaplay the advisered average for the list of  
 *   numbers my omitting the largest number in the series.
 * eg :3,6,12,55,289,600,534,900 and 172.
 * avg=(3+6+12+55+289+172) /6and eliminating 534,900,600
 * 
 * My understanding 1:
 * 	Just eliminate the largest number.
 * 	Algorithm:
 * 		1. Iterate through the number list. 
 * 		2. Keep on adding and keep track of the largest number you have 
 * 		   encountered.
 * 		3. When loops end. Subtract the largest number.
 * 
 * 	Complexity: O(n)
 * 
 * 
 * My Understanding 2:	
 *   Eliminate the "n" largest number, where n is passed as the argument
 *   Algorithm:
 *   	1. Sort the number list. (I am using Java function for it)
 *   	2. Take the average of list.length -n. 
 *   
 *   Complexity: O(n2)  (For basic sorting algorithm.)
 *   			 O(nlogn) for quick/merge sort.
 *   
 * @author jhaxx030
 */
public class AdvertisedAverage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer a[]=new Integer[] {3,6,12,55,289,600,534,900,172};
		List<Integer> numberList = Arrays.asList(a);

		averageUsingApproch1(numberList);
		averageUsingApproch2(numberList,3);
	}
	
	/************************************************************
	 * Approach1
	 */
	static void averageUsingApproch1(List<Integer> numberList){
		int sum = 0;
		int largestNumber = 0;
		for (Integer number: numberList){
			sum += number;
			if(largestNumber  < number){
				largestNumber = number;
			}
		}
		// Subtracting the largest number.
		sum -= largestNumber;
		// Removing "1" for largest number. 
		double averageValue = sum / numberList.size()-1;
		System.out.println("Advertised Average is:"+averageValue);
	}
	
	/************************************************************
	 * Approach2
	 */
	static void averageUsingApproch2(List<Integer> numberList, 
			int countNotToconsider){
		
		// Sort the list.
		Collections.sort(numberList);
		
		int sum = 0;
		for(int i=0;i<numberList.size()-countNotToconsider;i++){
			sum += numberList.get(i);
		}
		
		// Removing "countNotToconsider". 
		double averageValue=sum/numberList.size()-countNotToconsider;
		System.out.println("Advertised Average is:"+averageValue);
	}
}