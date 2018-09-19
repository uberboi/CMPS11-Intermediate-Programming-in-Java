/* Guess.java
 * Steven Huang
 * sthuang
 * pa2
 * Interactve number guessing game ranging from 1-10 with three guesses.
 */

import java.util.Scanner;

public class Guess {

	public static void main (String[] args){
		double x;
		int a,b, c;
		x = Math.random();
		x = 10*x+1;
	    int i = (int)x;
	    //System.out.println(i);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("I'm thinking of an integer in the range 1 to 10. you have three guesses.");
		System.out.println(); 
		
		System.out.print("Enter your first guess: ");
		a = sc.nextInt();
		
		if (a>i){
			System.out.println("Your guess is too high.");
			System.out.println();
			System.out.print("Enter your second guess: ");
			b = sc.nextInt();
			if (b>i){ 
				System.out.println("Your guess is too high.");
				System.out.println();
				System.out.print("Enter your third guess: ");
				c = sc.nextInt();
				if (c>i){
					System.out.println("Your guess is too high.");
					System.out.println();
					System.out.println("You lose. The number was " + i + ".");
				}else if (c<i){
					System.out.println ("Your guess is too low.");
					System.out.println();
					System.out.println("You lose. The number was " + i + ".");
				}else if (c==i){
					System.out.println("You win!");
				}
			}else if (b<i){
				System.out.println("You guess is too low. ");
				System.out.println();
				System.out.print("Enter your third guess: ");
				c = sc.nextInt();
				if (c>i){
					System.out.println("Your guess is too high.");
					System.out.println();
					System.out.println("You lose. The number was " + i + ".");
				}else if (c<i){
					System.out.println ("Your guess is too low.");
					System.out.println();
					System.out.println("You lose. The number was " + i + ".");
				}else if (c==i){
					System.out.println("You win!");
				}
			}else if (b==i){
				System.out.println("You win!");
			}
			
		}else if (a<i){
			System.out.println("Your guess is too low.");
			System.out.println();
			System.out.print("Enter your second guess: ");
			b = sc.nextInt();
			if (b>i){ 
				System.out.println("Your guess is too high.");
				System.out.println();
				System.out.print("Enter your third guess: ");
				c = sc.nextInt();
				if (c>i){
					System.out.println("Your guess is too high.");
					System.out.println();
					System.out.println("You lose. The number was " + i + ".");
				}else if (c<i){
					System.out.println ("Your guess is too low.");
					System.out.println();
					System.out.println("You lose. The number was " + i + ".");
				}else if (c==i){
					System.out.println("You win!");
				}
			}else if (b<i){
				System.out.println("You guess is too low. ");
				System.out.println();
				System.out.print("Enter your third guess: ");
				c = sc.nextInt();
				if (c>i){
					System.out.println("Your guess is too high.");
					System.out.println();
					System.out.println("You lose. The number was " + i + ".");
				}else if (c<i){
					System.out.println ("Your guess is too low.");
					System.out.println();
					System.out.println("You lose. The number was " + i + ".");
				}else if (c==i){
					System.out.println("You win!");
				}
			}else if (b==i){
				System.out.println("You win!");
			}
			
		}else if (a==i){ 
		    System.out.println("You win!");
		      }
		
		
		
	}
}
