package microsoft.oa;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_longest_semi_alternating_substring {
    public int findSemi(String s){
        if(s.length() < 3) return s.length();
        int count = 1;
        int result = 1;
        for(int i = 1; i < s.length() - 1;i++){
            if((s.charAt(i-1) == s.charAt(i)) && (s.charAt(i+1) == s.charAt(i))) {
                result = Math.max(result,count+1);
                count = 1;
            } else count++;
        }
        return Math.max(result,count+1);
    }
}
