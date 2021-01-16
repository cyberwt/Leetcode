package greedy.array;

/**
 *
 * > 很巧妙的iterate s but based on the result of t
 *
 * > if(indexOf == -1) 不符合题意
 *
 * 1/10/21
 */
public class _392_is_subsequence {
    public boolean isSubsequence(String s, String t) {
        if(s== null || t == null){
            return false;
        }
        int index = -1;
        // 谁为参照模版
        for(int i=0; i<s.length(); i++){
            index = t.indexOf(s.charAt(i),index+1);
            if(index == -1){
                return false;
            }
        }
        return true;
    }
}
