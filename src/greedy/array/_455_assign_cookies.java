package greedy.array;

import java.util.Arrays;

/**
 * greedy 每次走的是糖果，因为如果糖果不能与孩子与时俱进，就没有用途，走不尽糖果也没什么意思！
 *
 *
 * T:O(NlgN) - sort
 * S:O(1)
 *
 * 10/2/20.
 * 11/30/20  don't need it again Error:  if (re)s<g.length &&
 *
 * 1/10/21
 * 理解了，糖果动，孩子按需而行
 * plus 边界判断条件
 *
 */
public class _455_assign_cookies {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        if(g==null || s==null || g.length == 0 || s.length == 0){
            return res;
        }
        Arrays.sort(g);
        Arrays.sort(s);

        for(int i=0; i<s.length; i++){
            if (res<g.length &&  s[i] >= g[res]){
                res++;
            }
        }
        return res;
    }
}
