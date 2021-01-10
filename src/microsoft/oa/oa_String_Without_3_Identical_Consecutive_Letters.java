package microsoft.oa;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_String_Without_3_Identical_Consecutive_Letters {
    public static String strWithout3IdentialChars(String input) {
        if(input == null || input.length() == 0) return null;
        StringBuilder sb =  new StringBuilder();
        sb.append(input.charAt(0));
        int counter = 1;
        for(int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == input.charAt(i-1)) {
                ++counter;
                if(counter%3 != 0) sb.append(c);
            } else {
                counter = 1;
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(strWithout3IdentialChars("eedaaad"));
        System.out.println(strWithout3IdentialChars("xxxtxxx"));
    }
}
