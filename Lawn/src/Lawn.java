/* Lawn.java
 * Steven Huang
 * sthuang
 * pa1
 * Calculates the lawn area and mowing time
 */

import java.util.Scanner;

class Lawn {
	
   public static void main (String[] args){
	   
	   double lLength, lWidth, hLength, hWidth, mowingRate, area, seconds;
	   int h, m, s;
	  
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.print("Enter the length and width of the lot, in feet: ");
	   lLength = sc.nextDouble();
	   lWidth = sc.nextDouble();
	   
	   System.out.print("Enter the length and width of the house, in feet: ");
	   hLength = sc.nextDouble();
	   hWidth = sc.nextDouble();
	   
	   area = lLength*lWidth - hLength*hWidth;
	   System.out.println("The lawn area is " + area + " square feet.");
	   
	   System.out.print ("Enter the mowing rate, in square feet per second: ");
	   mowingRate = sc.nextDouble();
	   
	   seconds = area/mowingRate;
	   
	   s = (int) Math.round(seconds);
	   m = s/60;
	   s = s%60;
	   h = m/60;
	   m = m%60;
	   
	   System.out.println ("The mowing time is " + h + (h==1?" hour ":" hours ") + m + (m==1?" minute ":" minutes ") + s + (s==1?" second. ":" seconds."));
	   
	     
	   
	   
   }
}
