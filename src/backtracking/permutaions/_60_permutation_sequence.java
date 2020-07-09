package backtracking.permutaions;

import java.util.LinkedList;

/**
 * 是个数学问题，不断取组合
 *  1.Construct factor[]（就是permutation的根基）and index list
    2. int index = k/factor[i];  得到一堆数，我属于哪个组合
 *  3. k被计算之后，回归新值
 *
 * 7/6/20
 */
public class _60_permutation_sequence {
    public String getPermutation(int n, int k) {
        int[] factor = new int[n];
        factor[0] = 1;
        for(int i=1; i<=n-1; i++){
            factor[i] = i* factor[i-1];
        }

        StringBuilder sb = new StringBuilder();

        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i=1; i<=n; i++){
            list.add(i);
        }
        k--;
        for(int i=n-1; i>=0; i--){
            int index = k/factor[i];
            sb.append(list.get(index));
            list.remove(index);
            k = k-index*factor[i];
        }

        return sb.toString();
    }

    public static void main(String[] args){
        _60_permutation_sequence solution = new _60_permutation_sequence();

        String res = solution.getPermutation( 4,5);
        System.out.println(res);
    }
}
