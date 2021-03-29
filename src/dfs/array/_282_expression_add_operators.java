package dfs.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Error:
 * 常规dfs 在主函数里开局
 * dfs(num, target, res, String path, int index, long! eval, long! muted)
 *
 * 1. 在for函数里
 * Why long???  [1]
 * overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
 *
 *
 *
 * Why from [index, i+1)
 * long cur = Long.parseInt(index,i+1);
 *
 * 2. 不要以0开头的值， if(i!= index &&  num.charAt(index)== '0' ) break;
 *
 *
 * 3. if index == 0, all the staff is new, 此为 特殊情况
 *
 * 4. 乘法的巧妙之处
 * dfs(num, target, res, path + '*' + cur, eval-muted+ muted*cur, muted*cur)
 *
 *
 *
 * ? 复杂度怎么分析 [2]
 * T(n) = 3*T(n - 1) + T(n - 1) = 4*T(n - 1)
 *
 *
 *
 * 3/23/21.
 */
public class _282_expression_add_operators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<String>();
        if(num == null || num.length() ==0){
            return res;
        }
        // curValue, evla, curFactor
        helper(num, target, res, "",0, 0, 0 );
        return res;
    }

    public void helper(String num, int target,List<String> res,String path,int index, long eval, long multed){
        if(index == num.length()){
            if(target == eval){
                res.add(path);
            }
            return;
        }

        for(int i=index; i<num.length(); i++){
            // E1: it not a number like  002
            // why I want a break!! here
            if(i!= index &&  num.charAt(index)== '0' ) break;
            // Long.parseLong(index, i+1)
            long cur  = Long.parseLong(num.substring(index,i+1));
            // E2: pos = 0, not val =0
            if(index == 0){
                helper(num, target, res,path+cur,i+1,cur,cur );
            }else{
                helper(num, target, res,path+"+"+cur,i+1,eval+cur,cur );
                helper(num, target, res,path+"-"+cur,i+1,eval-cur,-cur);
                // 前面 乘法 是对的
                helper(num, target, res,path+"*"+cur,i+1,eval-multed+multed*cur,multed*cur);
            }
        }
    }
}
