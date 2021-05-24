package array.manip;

import java.util.HashSet;

/**
 * M1: just compare with every == situation, 因有一个方形的变形 LX -> XL not opposite
 * to make sure that L should be in the left
 * 所以 start.replace("X", "").equals(end.replace("X", "") 并不够
 *
 *
 * M2: 理解常规的 dfs - TLE though
 *
 * 1。不能用index 做辅助参数，因为xlr, rlx 是可以被公用的，所以每次的index从0开始
 * 2。注意set.add(str)的位置 每次在for loop 前，被比之后立即加上
 * 3. !!! never char.toString() but new String(char) because it change!
 *
 *
 * T(2^n)   n exponential with 2 as base
 *
 * 4/17/21.
 */
public class _777_swap_adjacent_in_LR_string {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;
        if (start.length() != end.length()) {
            return false;
        }
        int i = 0, j = 0;

        while (i <= start.length() && j <= end.length()) {
            while (i < start.length() && start.charAt(i) == 'X') i++;
            while (j < end.length() && end.charAt(j) == 'X') j++;
            if (i == start.length() && j == end.length()) {
                return true;
            }
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        return false;
    }

    //dfs 很有意思的一个地方是他一直在返回true


    public boolean canTransform(String start, String end) {
        char[] source = start.toCharArray();
        HashSet<String> set = new HashSet<String>();
        return dfs(source, set, end);
    }

    public boolean dfs(char[] source, HashSet<String> set, String end){

        if(set.contains(new String(source))){
            return false;
        }
        if(new String(source).equals(end)){
            return true;
        }


        for(int i=0; i<end.length()-1; i++){
            set.add(new String(source));
            if((source[i]=='X' && source[i+1]=='L') || (source[i]=='R' && source[i+1]=='X')){

                swap(source, i, i+1);

                if(dfs(source, set, end))
                    return true;
                swap(source, i,i+1);
            }

        }
        return false;
    }

    public void swap(char[] source, int i, int j){
        char tem = source[i];
        source[i] = source[j];
        source[j] = tem;
    }

}
