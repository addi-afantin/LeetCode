package org.example;

import java.util.Scanner;

/*
https://leetcode.com/problems/basic-calculator/?envType=study-plan-v2&envId=top-interview-150

Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:
Input: s = "1 + 1"
Output: 2

Example 2:
Input: s = " 2-1 + 2 "
Output: 3

Example 3:
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23

Constraints:
1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer.

 */
public class BasicCalculator {
    private static Integer i = 0;

    public static void main(String[] args) {
        System.out.print("Enter the string: ");
        final var input = getInput();
        i = input.length() - 1;
        System.out.println("Result: " + calculate(input));
    }

    private static Integer calculate(String input) {
        var result = 0;
        while (i >= 0) {
            if (input.charAt(i) == ')') {
                i--;
                result += calculate(input);
                i--;
                continue;
            }
            if (input.charAt(i) == '(') {
                if (input.charAt(i - 1) == '-') {
                    result *= -1;
                }
                return result;
            }
            if (input.charAt(i) == '+' || input.charAt(i) == '-') {
                i--;
                continue;
            }
            var number = Integer.parseInt(String.valueOf(input.charAt(i)));
            if (i - 1 >= 0 && input.charAt(i - 1) == '-') {
                number *= -1;
            }
            result += number;
            i--;
        }
        return result;
    }

    private static String getInput() {
        Scanner s = new Scanner(System.in);
        final var input = s.nextLine();
        s.close();
        return input.replaceAll("[ \\t]+", "");
    }
}
