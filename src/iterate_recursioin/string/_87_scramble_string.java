package iterate_recursioin.string;

/**
 * 基础判断：
 * 1。长度不相等，直接false
 * 2。内容相等，直接true
 * 3。每个字母都对应么
 *
 * 4。每一份块 前前要相等，后后要相等。 不能为true返回时，直接return false
 *
 * 7/14/20.
 */
public class _87_scramble_string {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        if(s1.equals(s2)){
            return true;
        }

        int[] com = new int[26];
        for(int i=0; i<s1.length(); i++){
            com[s1.charAt(i) - 'a']++;
            com[s2.charAt(i) -'a']--;
        }

        for(int i=0; i<26; i++){
            if(com[i] != 0){
                return false;
            }
        }

        for(int i=1; i<s1.length(); i++){
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) &&
                    isScramble(s1.substring(i), s2.substring(i))
                    ){
                return true;
            }

            if(isScramble(s1.substring(i), s2.substring(0,s2.length()-i)) &&
                    isScramble(s1.substring(0,i), s2.substring(s2.length()-i))
                    ){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        _87_scramble_string solution = new _87_scramble_string();
        System.out.println(solution.isScramble("great", "regat"));
    }
}
