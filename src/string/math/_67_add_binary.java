package string.math;

/**
 * 算数：
 * 进位，求余， 勿忘最高位
 *
 * 7/5/20.
 */
public class _67_add_binary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        _67_add_binary solution = new _67_add_binary();
        System.out.println(solution.addBinary("11","101"));
        String strs = "/a//b////c/d//././/..";
        for(String str:strs.split("/"))
            System.out.println(str.length());
    }
}
