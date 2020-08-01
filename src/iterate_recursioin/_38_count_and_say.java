package iterate_recursioin;

/**
 * 理解递归 和 迭代各自的精巧之处
 *
 * res.append(count)  res.append(char)
 *
 * T:O(n^2) S:O(1)
 *
 * 6/15/20.
 */
public class _38_count_and_say {
    public String countAndSay(int n) {
        if(n == 0){
            return "";
        }
        String res = "1";
        for(int i=1; i<n ;i++){
            res = helper(res);
        }
        return res;
    }

    public String helper(String res){
        StringBuilder sb = new StringBuilder();
        char c = res.charAt(0);
        int count = 1;
        for(int i=1; i<res.length(); i++){
            if(res.charAt(i) == c){
                count++;
            }else{
                sb.append(count);
                sb.append(c);
                count =1;
                c=res.charAt(i);
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }

    public String countAndSay2(int n) {
        if(n==1) return "1";
        String prev = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i< prev.length()){
            char ca = prev.charAt(i);
            int j=0;
            while(i+j<prev.length() && prev.charAt(i+j)== ca) j++;
            sb.append(j);
            sb.append(ca);
            i += j;
        }
        return sb.toString();
    }

}
