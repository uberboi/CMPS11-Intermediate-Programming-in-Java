/* GCD.java
 * Steven Huang
 * sthuang
 * pa3
 * Calculates the greatest common denominator of two positive integers.
 */

import java.util.Scanner;

public class GCD {
	public static void main (String[] args){
		int a, b, temp, dividend, divisor, remainder, r;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a positive integer: ");
		while(true){
			while (!sc.hasNextInt()){
				sc.next();
				System.out.print("Please enter a positive integer: ");
			}
			a = sc.nextInt();
			if (a>0){
				break;
			}else{
				System.out.print("Please enter a positive integer: ");
			}
		}
		System.out.print("Enter another positive integer: ");
		while(true){
			while (!sc.hasNextInt()){
				sc.next();
				System.out.print("Please enter a positive integer: ");
			}
			b = sc.nextInt();
			if (b>0){
				break;
			}else{
				System.out.print("Please enter a positive integer: ");
			}
		}
		
		dividend = a;
		divisor = b;
		if (dividend<divisor){
			temp = dividend;
			dividend = divisor;
			divisor = temp;
		}	 
		
		remainder = divisor;
		do {
			r = dividend%divisor;
			if (r == 0) 
				break;
			remainder = r;
			dividend = divisor;
			divisor = r;             
		}while (r>0);
		
		System.out.println("The GCD of " + a + " and " + b + " is " + remainder);
	}
}
