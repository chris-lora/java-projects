/*
Program does the following: 
1. Asks user what conversion they want to make. 
2. If user enters 1, converts Fahrenheit to Celsius.
3. If user enter 2, converts Celsius to Fahrenheit.
4. Other inputs terminate the program. 
*/

import java.util.*;

public class temperature_converter {
  public static void main(String[] args) {
	  try(Scanner in = new Scanner(System.in)) {
		  System.out.println("Enter 1 for converting Fahrenheit to Celsius, enter 2 for converting Celsius to Fahrenheit: ");
		  int convertCode = in.nextInt();
		  if(convertCode == 1) {
			  System.out.println("Enter Fahrenheit temperature: ");
			  double fTemp = in.nextDouble();
			  double cTemp = ((fTemp - 32) * (5.0/9));
			  System.out.printf("%5.1f F converts to %5.1f C.", fTemp, cTemp);
		  } else if(convertCode == 2) {
			  System.out.println("Enter Celsius temperature: ");
			  double cTemp = in.nextDouble();
			  double fTemp = (cTemp * 1.8) + 32;
			  System.out.printf("%5.1f C converts to %5.1f F.", cTemp, fTemp);
		  }
		  in.close();
	  }
	  catch(Exception e) {
		  System.out.println("Invalid input.");
	  }
	  System.out.printf("\nGoodbye.");
	  System.exit(1);
  }
}
