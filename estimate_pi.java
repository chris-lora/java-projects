import java.lang.*;
import java.util.*;

public class estimate_pi {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of attempts: ");
		double attempts = in.nextDouble();
		double hits = 0;
		double x = 0;
		double y = 0;
		if (attempts < 1 || attempts % 1 != 0) {//doesn't run numbers less than one or decimals
			System.out.println("Error. Invalid entry.");
			System.exit(1);
			}
		else {
			for (int i = 1; i <= attempts; i++) {
				x = Math.random();
				y = Math.random();
				double circle = x*x + y*y;
				if (circle < 1)
					hits++;
			}
			System.out.println("----------------------------");
			System.out.println("Total attempts: " + attempts);
			System.out.println("Hits made: " + hits);
			double piEst = 4*(hits/attempts);
			System.out.printf("Ratio hits/attempts (Pi Estimate): %.5f\n", piEst);
			double actualPi = Math.PI;
			System.out.printf("Actual Pi: %.5f\n", actualPi);
			double error = 100*(Math.abs((actualPi - piEst)/piEst));
			System.out.printf("Error: %.2f", error);
			System.out.println("%");
		}
		in.close();
	}
}