/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
package leetcode;

public class LeetCode072EditDistance {

    public int minDistance(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] distance = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1 + 1; i++) {
            distance[i][0] = i;
        }

        for (int j = 0; j < len2 + 1; j++) {
            distance[0][j] = j;
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);

                if (c1 == c2) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    int insert = distance[i][j - 1] + 1;
                    int delete = distance[i - 1][j] + 1;
                    int replace = distance[i - 1][j - 1] + 1;

                    distance[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return distance[len1][len2];
    }
}
