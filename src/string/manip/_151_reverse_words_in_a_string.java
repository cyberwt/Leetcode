package string.manip;

/**
 *  9/3
 *  自己想出来了，但需要注意 corner case
 *  i, j快慢指针的 值域
 *  最前面的word 要s.trim()
 *
 *
 *  几个知识点
 *  s.tirm()
 *  s.split("\\s+")
 *
 *  一次过的，可以跳过了这题
 *
 *
 *  8/11/20.
 */
public class _151_reverse_words_in_a_string {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        String newStr = s.trim();
        String[] str = newStr.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=str.length-1; i>=0; i--){
            if(i!=0){
                sb.append(str[i]+ " ");
            }else{
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }

    public String reverseWords2(String s) {
        if(s == null || s.length() ==0){
            return "";
        }
        s = reverse(s.trim());
        int i=0, j=0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length() && j<s.length()){
            while(j<s.length() && s.charAt(j) != ' ' ) j++;
            //if()
            String subStr = reverse(s.substring(i,j));
            sb.append(" " + subStr);
            i=j;
            while(i<s.length() && s.charAt(i) == ' ') i++;
            j=i;
        }
        return sb.toString().trim();
    }

    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
