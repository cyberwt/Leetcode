package iterate_recursioin;

/**
 *  去考虑:
 *
 *  -> 跳出条件
 *  -> 构建解决问题的函数 f(n)
 *  -> 降低问题规模，从n到n-1
 *
 *  6/28/20.
 */
public class _10_regular_expression_matching {
    public boolean isMatch(String s, String p) {
        // 出口
        if(p.isEmpty()) return s.isEmpty();
        boolean flag = (!s.isEmpty() && ((s.charAt(0) == p.charAt(0))|| p.charAt(0) == '.'));

        // 切碎问题

        if(p.length() >=2 && p.charAt(1) == '*'){
            // match zero
            // match any preceding
            return ( isMatch(s,p.substring(2))||(flag && isMatch(s.substring(1), p)));
        }else{
            return (flag && isMatch(s.substring(1),p.substring(1)));
        }
    }

}
