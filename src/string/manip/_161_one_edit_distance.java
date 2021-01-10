package string.manip;

/**
 * 只能编辑一次， 删/增改 是一粟，都往下比一个就行
 *
 * 这个很tricky, 意思是 t一定要改一次，才能变成s
 *
 * 8/15/20.
 */
public class _161_one_edit_distance {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null || Math.abs(s.length()-t.length()) >1 ){
            return false;
        }

        if(s.length() > t.length()){
            return isOneEditDistance(t,s);
        }

        int i=0,j=0;
        int lenS = s.length();
        int lenT = t.length();

        while(i<lenS && j<lenT){
            if(s.charAt(i) != t.charAt(j)){
                return s.substring(i+1).equals(t.substring(j+1)) ||
                        s.substring(i).equals(t.substring(j+1));
            }
            i++;
            j++;
        }

        return Math.abs(s.length() - t.length()) == 1;
    }
}
