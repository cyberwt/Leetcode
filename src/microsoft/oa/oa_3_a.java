package microsoft.oa;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_3_a {
    public static void main(String[] args) {
        String s1 = "aabab";
        String s2 = "dog";
        String s3 = "aa";
        String s4 = "baaa";
        String s5 = "aaba";
        System.out.println(maxA(s1));
        System.out.println(maxA(s2));
        System.out.println(maxA(s3));
        System.out.println(maxA(s4));
        System.out.println(maxA(s5));
    }

    private static int maxA(String s) {
        int cnt = 0, res = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == 'a')
                cnt++;
            else {
                res += 2 - cnt;
                cnt = 0;
            }
            if(cnt == 3)
                return -1;
        }
        if(s.charAt(s.length() - 1) != 'a')
            res+=2;
        else
            res += 2 - cnt;
        return res;
    }
}
