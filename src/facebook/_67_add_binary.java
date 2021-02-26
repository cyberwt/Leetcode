package facebook;

/**
 * 算术题，
 * > loop顺序，从低位到高位
 * > carry 的计算 是在cur 之后的， 最后还要在判断一下
 * > 返回的值, 怎么构建
 *
 *
 * 2/17/21.
 */
public class _67_add_binary {
    public String addBinary(String a, String b) {
        // loop 的顺序
        // string 从右到左的loop
        // 结果reverse 一下
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        int i=0, carry = 0;
        // sb vs string 仅仅是时间上的不同么
        // Integer.parseInt(String.valueOf(ch));
        // int a = Character.getNumericValue(ch);
        String res = "";
        while(aIndex >= 0 || bIndex >= 0){
            int aVal = aIndex>=0 ? (a.charAt(aIndex)-'0') : 0;
            int bVal = bIndex>=0 ? (b.charAt(bIndex)-'0') : 0;
            int cur = aVal+bVal+carry;
            carry = cur/2;
            res = (cur%2) + res;
            aIndex--;
            bIndex--;
        }
        if(carry !=0){
            res = "1" + res;
        }

        return res;
    }
}
