package string.manip;

/**
 *
 * 小题目里大学问， 去优化你的想法，必须 得到最优解
 *
 case 1:  all upper case conversion -  最后一次性reverse, toUpperCase
 sb.reverse().toString().toUpperCase

 case 2: give me a extra value to help me if I need to add dash


 case 3: many dash at the head, only dash in the string

 if(char != '-')  continue operation to filer out possible values


 if (len > 0 && len % K == 0) {
 sb.append('-');
 }

 why: 先append '-' ,再append  char, 为的是不用判断第一个位置不用加 'dash'


 T:O(N) S:O(N)

 *
 *
 * 10/18/20
 */
public class _482_license_key_formatting {
    public String licenseKeyFormatting(String S, int K) {
        if(S==null || S.length() == 0){
            return S;
        }

        StringBuilder sb = new StringBuilder();
        int count =0;
        for(int i=S.length()-1; i>=0; i--){
            if(S.charAt(i) != '-'){
                if(count % K == 0 && count!=0){
                    sb.append('-');
                }
                sb.append(S.charAt(i));
                count++;
            }
        }

        return sb.reverse().toString().toUpperCase();
    }
}
