package recursion;

import satck.parentheses._20_valid_parentheses;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 递归，就不停向下走，但要 把握 什么时候退出来
 *
 * 在 满足长度时，直接退出字符串
 * 在 left< n 和 right<n 时 继续递归
 *
 * 6/28/20.
 */
public class _22_generate_parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<String>();
        if(n <= 0){
            return res;
        }
        bfs(res,n,0,0,"");
        return res;
    }

    public void bfs(List<String> res, int n, int left, int right, String str){
        if(str.length() == 2*n){
            res.add(str);
        }

        if(left<n){
            bfs(res,n,left+1,right,str+ "(");
        }

        if(left > right){
            bfs(res,n,left,right+1,str+ ")");
        }
    }

    public static void main(String[] args) {
        _22_generate_parentheses solution = new _22_generate_parentheses();
        System.out.println(solution.generateParenthesis(5));
    }
}
