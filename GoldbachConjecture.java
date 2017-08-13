import java.util.Scanner;
/*
 * Goldbach's conjecture : Every even integer greater than 2 can be expressed as the sum of two primes. 
 * Write a function which takes a number as input, verify if is an even number greater than 2 
 * and also print at least one pair of prime numbers.
 */
public class GoldbachConjecture{


	public static void getGoldbachNumbers(int number){
        if(number%2 != 0)
                {
                System.out.println("Please enter an even number.Invalid Input");
                return;
                }
        for(int i=0;i<number/2;i++){

                if(isPrime(i) && isPrime(number-i))
                        System.out.println("Goldbach numbers are :"+i+" and "+(number -i)+" for "+number);

        	}


	}

	public static boolean isPrime(int number){

        for(int i=2;i<number;i++){
                if(number%i == 0)
                        return false;
        }

        return true;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner scr =new Scanner(System.in);
		System.out.println("Enter number");
		int num=scr.nextInt();
		getGoldbachNumbers(num);

		}



}