package recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * 1/ divide & conquer
 *  递归的如此巧妙，在有特殊符号的位置上，向里卷，不断逼出最小可能值
 * List<Integer> l1 = diffWaysToCompute(a1);
   List<Integer> l2 = diffWaysToCompute(a2);
 *
 * 2/ 递归跳出条件，当res为空时:
 *
 *  if(res.size() == 0) res.add(Integer.valueOf(input));
 *
 * T:O(N!) - Catalan Numbers
 *
 * 1/29/21.
 */
public class _241_different_ways_to_add_parentheses {
    public List<Integer> diffWaysToCompute(String input) {
        // different ways to add ()
        List<Integer> res = new LinkedList<Integer>();
        if(input == null || input.length() == 0){
            return res;
        }
        // complexity is not easy to totally understand
        for(int i=0; i<input.length(); i++){
            char label = input.charAt(i);
            if(label == '+' || label =='-' || label =='*'){
                String a1 = input.substring(0,i);
                String a2 = input.substring(i+1);
                List<Integer> l1 = diffWaysToCompute(a1);
                List<Integer> l2 = diffWaysToCompute(a2);
                for(int val1: l1){
                    for(int val2: l2){
                        if(label == '+'){
                            res.add(val1+val2);
                        }else if(label == '-'){
                            res.add(val1-val2);
                        }else{
                            res.add(val1*val2);
                        }

                    }
                }

            }
        }

        if(res.size() == 0) res.add(Integer.valueOf(input));
        // 跳出条件
        return res;
    }
}
