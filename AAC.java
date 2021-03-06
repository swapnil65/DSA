import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AAC { 

	/** 
	 * @param args 
	 */ 
	public static void main(String[] args) { 
		// TODO Auto-generated method stub 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Enter total cost"); 
		try 
		{ 
			double cost = Double.parseDouble(br.readLine()); 

			System.out.println("Enter the amount paid"); 
			double amount = Double.parseDouble(br.readLine()); 

			double ret = amount - cost; 

			int one = 0, five = 0, ten = 0, quarter = 0, nickel = 0, dime = 0, cent = 0; 
			while(true)
			{ 
				//System.out.println(ret); 
				if(ret >= 10){ 
					ten++; 

					ret -=10; 
				} 
				else if(ret >= 5){ 
					five++; 

					ret -= 5; 
				} 
				else if(ret>=1){ 
					one++; 

					ret -= 1; 
				} 
				else if(ret >= 0.25){ 
					quarter++; 

					ret -= 0.25; 
				} 
				else if(ret>=0.10){ 
					dime++; 

					ret -=0.10; 
				} 
				else if(ret>=0.05){ 
					nickel++; 

					ret -= 0.05; 
				} 
				else if(ret>=0.01){ 
					cent++; 

					ret -= 0.01; 
				} 

				if(ret <= (double)0){ 
					break; 
				} 

			} 
			System.out.println("Tens = "+ten+" Five = "+five+" One = "+one+" Quarter = "+quarter+" dime = "+dime+" nickel = "+nickel+" cent = "+cent); 


		} catch (NumberFormatException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 
	} 

}