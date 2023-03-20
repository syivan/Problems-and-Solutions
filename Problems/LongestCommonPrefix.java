package Problems;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Example: [ flower, flight, flip ]
 * Returns: fl
 * @author Ivan Sy
 * @version 03/23
 */

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] test = {"flower", "flow", "flight", "flashing"};
        String result = new LongestCommonPrefix().bruteForce1(test);
        System.out.println(result);
    }
    /**
     * brute force solution
     * Time Complexity of O(n^2)
     * @param strs array of strings
     * @return longest common prefix between all strings in array
     */
    public String bruteForce1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = "";
        for (int i = 0; i < strs[0].length(); i++) { //iterate through length of first string in array
            char current_char = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) { //iterate through all strings in array
                //if current i count is greater/equal to length of the current string in for loop
                if (i >= strs[j].length() || strs[j].charAt(i) != current_char) return prefix;
            }
            prefix += current_char;
        }
        return prefix;
    }

    /**
     * brute force solution, but significantly faster
     * Time Complexity: O(S) - sum of all characters in the string array, or
     *                  O(A * S) - A being each element of Array, and S being the count of characters in said element
     * @param strs array of strings
     * @return the longest common prefix among all strings in the array
     */
    public String bruteForce2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) { //iterate through all strings in array
            while (strs[i].indexOf(prefix) != 0) { // if prefix value is not at the front of the current string
                prefix = prefix.substring(0, prefix.length()-1); //cut the current prefix string by 1 from the end
            }
        }
        return prefix;
    }
}
