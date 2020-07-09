package string.manip;

/**
 * M1: 水平比较，两两相比，取两组间的substring
 *
 * Error:
 * 必须要 跳出内循环for 后，才取 res = res.substring(0,j);
 * 因为可能没来得及进去，for循环并不存在 res = res.substring(0,j);
 *
 * T:O(N* minLen) S:O(1)
 *
 *
 *
 * M2: 垂直比较，其实就是for循环的位置变了
 *  if (i == strs[j].length() || strs[j].charAt(i) != c)  <=> 取min && if(res.charAt(j) != strs[i].charAt(j))
 *
 * 6/26/20.
 */


public class _14_longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        //水平比较，得两两一组的substring
        if(strs == null || strs.length == 0){
            return "";
        }
        String res = strs[0];
        for(int i=1; i<strs.length; i++){
            int j=0;
            for(; j<Math.min(res.length(),strs[i].length()); j++){
                if(res.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            res = res.substring(0,j);
        }

        return res;
    }


    public String longestCommonPrefix2(String[] strs) {
        //水平比较，得两两一组的substring
        if(strs == null || strs.length == 0){
            return "";
        }
        String res = strs[0];
        for(int i=0; i<res.length(); i++){
            char c = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++){
                /**
                 * i == strs[j].length() 表明当前行已经到达末尾
                 * strs[j].charAt(i) != c  当前行和第 0 行字符不相等
                 * 上边两种情况返回结果
                 */
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);

            }
        }

        return res;
    }



}
