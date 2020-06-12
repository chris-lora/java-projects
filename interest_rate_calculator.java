import java.io.*;
import javax.swing.*;
import java.lang.*;

public class interest_rate_calculator {
	public static void main(String[] args) {
		boolean valid = false;
		double initInvest = 0;
		double interestRate = 0;
		int investYears = 0;
		double n = 4.0; //compounding quarterly or 4 times per year
		while(!valid) {
			String tempInvest0 = JOptionPane.showInputDialog("Enter your initial investment (for example: for $1,500.50, enter 1500.50): ");
			String tempRate0 = JOptionPane.showInputDialog("Enter your annual interest rate (for example: for 3.5%, enter 3.5): ");
			String tempYears0 = JOptionPane.showInputDialog("Enter number of years for investment (for example: 5 years, enter 5): ");
			try {
				initInvest = Double.parseDouble(tempInvest0);
				interestRate = Double.parseDouble(tempRate0);
				investYears = Integer.parseInt(tempYears0);
				valid = true;
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "One or more of your inputs are invalid. Please try again.");
			}
		}
		if (initInvest < 0 || investYears < 0)
			JOptionPane.showMessageDialog(null, "One or more of your inputs are invalid. Please try again.");
		else {
			double tempRate1 = (1.0 + (interestRate/100.0)/n);
			for (int i = 1; i <= investYears; i++) {
				double tempInvest1 = initInvest * Math.pow((tempRate1), (n * (i)));
				JOptionPane.showMessageDialog(null, "Value investment after " + i + " year(s) is: " + tempInvest1); 
				//prints each year investment
			}	
			double finalInvest = initInvest * Math.pow((1.0 + (interestRate/100.0)/n), (n * investYears));
			double totalProfit = finalInvest - initInvest; //print final profit (formula - principle)
			JOptionPane.showMessageDialog(null, "Total profit for " + investYears + " year(s) is: " + totalProfit);
		}
	}
}
