package microsoft.oa;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_min_adj_swaps_to_make_palindrome {
    private static boolean isPalindrome(char[] arr) {
        Set<Character> count = new HashSet<>();
        for(char c : arr) {
            if(count.contains(c))
                count.remove(c);
            else
                count.add(c);
        }
        return count.size() < 2;
    }

    public static int adjacentSwaps(String input) {
        if(input == null || input.length() == 0) return -1;
        char[] charArr = input.toCharArray();
        int totalSwaps = 0;
        if(!isPalindrome(charArr))
            return -1;

        int p1 = 0, p2 = input.length() - 1;

        while(p2 > p1) {
            if(charArr[p1] != charArr[p2]) {
                int k = p2;
                while(k > p1 && charArr[k] != charArr[p1]) k--;
                if(k == p1) { //When no matching character found
                    swap(charArr, p1, p1 + 1);
                    totalSwaps++;
                } else { //When Matching character found swap until K reaches p2 position
                    while(k < p2) {
                        swap(charArr, k, k + 1);
                        totalSwaps++;
                        k++;
                    }
                    p1++; p2--;
                }
            } else {
                p1++; p2--; //When the characters are equal move on
            }
        }
        return totalSwaps;
    }

    private static void swap(char[] charArr, int k, int i) {
        char temp = charArr[k];
        charArr[k] = charArr[i];
        charArr[i] = temp;
    }

    public static void main(String[] args) {
        test(adjacentSwaps("dmmaa"), 4);
        test(adjacentSwaps("aabb"), 2);
    }

    private static void test(int actual, int expected) {
        if (actual == expected) {
            System.out.println("PASSED!");
        } else {
            System.out.println(String.format("FAILED! Expected %d, but got: %d", expected, actual));
        }
    }
}
