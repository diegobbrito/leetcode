package com.leetcode.bitmanipulation;

public class AddBinary {
//    https://leetcode.com/problems/add-binary/

    //    Time Complexity: O(max(n, m)), where n is the length of string a and m is the length of string b.
//    In each iteration of the while loop, you're processing one character from a or b (or both),
//    and the loop runs until all characters from both strings have been processed.
//    Since you reverse the result at the end, the overall time complexity remains O(max(n, m)).
//    Space Complexity: O(max(n, m)), because you're storing the result in a StringBuilder,
//    and the maximum length of the result is proportional to the length of the longer string,
//    plus one extra bit for a potential carry.
//    Additionally, the space used by sb and the reversed string is proportional to the number of bits needed to represent the sum.
    public String addBinary(String a, String b) {
        // Create a StringBuilder to store the result as binary digits are added
        var sb = new StringBuilder();

        // Initialize two pointers at the last characters of strings a and b
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Initialize carry to 0, which will store any carry-over during addition
        int carry = 0;

        // Loop while there are still digits to process in either string
        while (i >= 0 || j >= 0) {
            // Start with the carry from the previous iteration
            int sum = carry;

            // Add the digit from string 'a' and 'b' if it's within bounds
            // this expression converts a character '0' or '1' into its equivalent integer value, 0 or 1
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;

            // Update carry for the next iteration. carry = sum / 2 because binary addition can carry over when the sum is 2 or 3.
            carry = sum / 2;

            // Append the current binary digit (sum % 2) to the result
            //  Why sum % 2? The % operator returns the remainder of a division.
            //  In binary addition, we want to capture the least significant bit (the current binary digit) of the sum.
            //  Since sum can be 0, 1, 2, or 3:
            //sum % 2 will give:
            //0 % 2 = 0 → Resulting binary digit is 0
            //1 % 2 = 1 → Resulting binary digit is 1
            //2 % 2 = 0 → Resulting binary digit is 0 (with a carry of 1)
            //3 % 2 = 1 → Resulting binary digit is 1 (with a carry of 1)
            sb.append(sum % 2);

            // Move the pointers to the left (to the next significant digit)
            i--;
            j--;
        }

        // If there's any leftover carry, append it to the result
        if (carry != 0)
            sb.append(carry);

        // The result is built in reverse order, so reverse it before returning
        return sb.reverse().toString();
    }

}
