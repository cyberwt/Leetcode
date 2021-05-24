package facebook.onsite;

/**
 *
 * arr with hashmap, use want you want as the desired one
 *
 *
 * T:O(N) S:O(N)
 *
 *
 * 4/2/21.
 */
public class _387_first_unique_character_in_a_string {
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
