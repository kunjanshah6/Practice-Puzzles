/*
 *

 Problem : 
 
 A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. 
There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
By this logic, we say a sequence of brackets is balanced if the following conditions are met:
It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.

Function Description

Complete the function isBalanced in the editor below. It must return a string: YES if the sequence is balanced or NO if it is not.

isBalanced has the following parameter(s):

s: a string of brackets

Input Format :

The first line contains a single integer , the number of strings. 
Each of the next  lines contains a single string , a sequence of brackets.

Output Format
For each string, return YES or NO.

Sample Input : 
3
{[()]}
{[(])}
{{[[(())]]}}

Sample Output : 
YES
NO
YES

Explanation : 

The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
The string {[(])} is not balanced because the brackets enclosed by the matched pair { and } are not balanced: [(]).
The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
 * 
 * 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Balanced_Brackets {

	// Complete the isBalanced function below.
	static String isBalanced(String s) {

		int stringLength = s.length();

		Stack<Character> stackChar = new Stack<Character>();

		// Iterate One by one Bracket
		for (int i = 0; i < stringLength; i++) {
			char c = s.charAt(i);

			
			// If IN bracket then Push into Stack.
			if (c == '{' || c == '(' || c == '[') {
				stackChar.push(c);
			} else if (stackChar.size() != 0) {

				// If OUT bracket then check balancing
				switch (c) {
				case '}':
					if (stackChar.pop() != '{') {
						return "NO";
					}
					break;

				case ')':
					if (stackChar.pop() != '(') {
						return "NO";
					}
					break;

				case ']':
					if (stackChar.pop() != '[') {
						return "NO";
					}
					break;

				}
			}
		}

		// If balanced return YES
		if (stackChar.size() == 0) {
			return "YES";
		}

		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = br.read();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.nextLine();
			String result = isBalanced(s);
			System.out.println(result);
		}
	}
}
