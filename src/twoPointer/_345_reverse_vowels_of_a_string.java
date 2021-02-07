package twoPointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 几个基本规则：
 * 1.建以list为基础的hashset:
 * HashSet<Character> set= new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
 *
 * 2. not arr.toString() 这调用的是char[] 的function, 只会返回一个地址
 * String.valueOf(arr) or new String(arr)
 *
 * 3. if ;else if; else 结构，只能有其中一种符合情况
 *
 * 1/27/21.
 */
public class _345_reverse_vowels_of_a_string {
    private HashSet<Character> set= new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i=0, j=s.length()-1;
        while(i<j){
            char left = arr[i];
            char right = arr[j];
            // 3。这个结构每次只能前进一格,i或j， 虽然不高效，但好理解，建立了二者之间的关系，比去分散的if else 来说
            if(!set.contains(left)){
                i++;
            }else if(!set.contains(right)){
                j--;
            }else{
                arr[i] = right;
                arr[j] = left;
                i++;
                j--;
            }
        }
        // arr.toString() not work
        return new String(arr);
    }

}
