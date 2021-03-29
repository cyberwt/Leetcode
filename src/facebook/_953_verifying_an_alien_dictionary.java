package facebook;

/**
 *
 *
 *
 *
 * >有几个细节，要考虑到:
 *
 * helper function:
 *
 * 1. >, < 时直接break,return
 * 2. return len1 <= len2 in the end
 *
 *
 *
 *
 *
 *
 * 3/20
 *
 *
 * > 题很简单
 * 思考:
 * 1. CC and input validation
 * 2. optimize codes structure
 *
 *  return len1 <= len2;
 *
 * 3. follow up - use map to record order of the words
 *
 Outer loop iterates m (= words.length) times, and inner loop runs n (= A[0].length()) times;
 map cost O(1) space.


 *
 *
 *
 *
 * 2/17/21.
 */
public class _953_verifying_an_alien_dictionary {
    // 题要是简单呢: bug free  & how to optimize & follow up with new format
    int[] dic = new int[26];
    // fine to have a global variable
    public boolean isAlienSorted(String[] words, String order) {
        // first thought: hashmap: O(1), arr: O(1)
        // is null or len0 count as alienSorted

        // is it means the words are sorted or in each word it's sorted
        if(words == null || words.length == 0){
            return true;
        }
        char[] orderDic = order.toCharArray();
        for(int i=0;i<26;i++){
            dic[orderDic[i] - 'a'] = i;
        }
        for(int i=1; i<words.length; i++){
            if(!isAlienSorted(words[i-1], words[i])){
                return false;
            }
        }

        return true;
    }

    public boolean isAlienSorted(String word1, String word2){
        int len1 = word1.length(), len2 = word2.length();

        for(int i=0 ;i<Math.min(len1,len2); i++){
            if(dic[ word1.charAt(i)-'a'] != dic[ word2.charAt(i)-'a']){
                return dic[ word1.charAt(i)-'a'] < dic[ word2.charAt(i)-'a'];
            }
        }

        return len1 <= len2;
    }
}
