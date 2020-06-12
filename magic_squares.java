import java.util.Scanner;

public class magic_squares {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter an positive odd integer: ");
		int userInput = in.nextInt();
	
		if (userInput % 2 == 0) {
			System.out.println("Input is not an odd number and/or a positive integer. Goodbye!");
			System.exit(1);	
		} else {
			int[][] table = new int[userInput][userInput]; // creates an empty array 
			for(int row = 0; row < table.length; row++) { // sets all the table spots to 0
				for (int col = 0; col < table[row].length; col++) {
					table[row][col] = 0;	
				}	
			}
			FillIn(table);	
		}
		in.close();	
	}
	
	public static void FillIn(int[][] table) {
		int n = table[0].length;
		int counter = 1; // first count 
		int initRow = n -1; // initial  row for 1
		int initCol = n / 2; // initial column for 1
		table[initRow][initCol] = counter;

		for(int row = 0; row < (n * n) - 1; row++) {
			counter += 1;	// moves to new spot
			int nextRow = initRow + 1;
			int nextCol = initCol +1; 
			if(nextRow == n) // wraps if row goes below last row
				nextRow = 0;
			if(nextCol == n) // wraps if column goes to the right of last column
				nextCol = 0;
			if(table[nextRow][nextCol] == 0) {// if there is a 0, place next value
				initRow = nextRow;
				initCol = nextCol;
				table[initRow][initCol] = counter;
			} else {
				initRow = initRow - 1; // if it is not a 0, go to spot above
				if(initRow < 0) {
					initRow = n -1;	
				}
				table [initRow][initCol] = counter;	// stores current count
			}
		}
		
		for (int row = 0; row < n; row++) {// prints the array 
			for (int col = 0; col < table[row].length; col++) {
				System.out.printf("%6d", table[row][col]);
			}
			System.out.println();
		}
	}
}
