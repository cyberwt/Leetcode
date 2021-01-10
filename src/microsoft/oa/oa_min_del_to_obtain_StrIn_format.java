package microsoft.oa;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_min_del_to_obtain_StrIn_format {
    private int minDelToObtainStrInFormat(String S) {
        int minDeletions = 0;
        if(S == null || S.length() == 0) return minDeletions;
        int counter = 0;
        for(char c : S.toCharArray()) {
            if(c == 'B') counter++;
            else if(c == 'A') {
                minDeletions += counter;
                counter = 0;
            }
        }
        return minDeletions;
    }

    public static void main(String[] args) {
        oa_min_del_to_obtain_StrIn_format s = new oa_min_del_to_obtain_StrIn_format();
        System.out.println(s.minDelToObtainStrInFormat("BAAABAB"));
    }
}
