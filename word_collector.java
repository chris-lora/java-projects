/*
Program does the following:
1. Reads the contents of the file (Alice01.txt) and stores it in a string.
2. Converts the string to lower case characters. 
3. Removes all special characters from the file; punctuation, digits and any other non-alphabetic characters.
4. Removes duplicate words.
5. Creates a list that contains are of the words in the file.
6. Saves the list of words to an output file. 
*/

import java.io.*;
import java.util.*;

public class word_collector {

	public static void main(String[] args) {
		
		/* Calls method that prints result onto 
		 *  output file AliceWordList.out.
		 * */
		checkText(null, null);
		System.out.println("Word list is complete!\nCheck out the output file: AliceWorldList.out");
		System.exit(1);
		}
	
	private static String readText() {
		try(FileReader reader = new FileReader("alice01.txt");
			Scanner in = new Scanner(reader)) {
			
			/* Creates single line String and 
			 *  makes the words lower case. 
			 * */
			StringBuffer test0 = new StringBuffer("");
			while(in.hasNext()) {
				String next = in.next().toLowerCase();
				test0.append(next + " ");
				}
			return test0.toString();
			} 
		catch(Exception e) {
				return null;
			}
		}
	
	private static void checkText(Scanner in, FileReader reader) {
		try(FileWriter writer = new FileWriter("AliceWordList.out");
			PrintWriter out = new PrintWriter(writer)) {
			
			/* 1. Removes all special characters 
			 *     and numbers.
			 * 2. Splits the single String.
			 * 3. Checks new List for repeated 
			 *     words and removes them.
			 * */
			String test1 = readText().replaceAll("[`~!@#$%^&*()-_=+:;',<.>/?1234567890]", "").trim();
			String[] test2 = test1.split(" ");
			List<String> test3 = new ArrayList<String>(Arrays.asList(test2));
			
			for(int word1 = 0; word1 < test3.size() - 1; word1++) {
				for(int word2 = word1 + 1; word2  < test3.size(); word2++) {
					if((test3.get(word1).compareTo(test3.get(word2)) == 0)) {
						test3.remove(word2);
					}
				}
			}
			
			/* Prints result onto output file.
			 * */
			for(String lastStr : test3)
				out.println(lastStr);
			}
		catch(Exception e) {
			System.out.println("Invalid output.");
			}
		}
	}
