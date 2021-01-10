package microsoft.oa;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_Max_length_of_a_concatenated_string_with_unique_characters {
    private int result;
    private int maxLengthOfStr(List<String> input) {
        result = 0;
        if(input == null || input.size() == 0) return result;
        dfs(input, 0, "");
        return  result;
    }


    private void dfs(List<String> input, int index, String current) {
        System.out.println(current);
        if(isUnique(current)) {
            result = Math.max(result, current.length());
        }

        for(int i = index; i < input.size(); i++) {
            dfs(input, i + 1, current + input.get(i));
        }

    }

    private boolean isUnique(String current) {
        Set<Character> set = new HashSet<>((current.chars().mapToObj(e -> (char)e).collect(Collectors.toList())));
        return set.size() == current.length()  ? true : false;
    }


    public static void main(String[] args) {
        oa_Max_length_of_a_concatenated_string_with_unique_characters s = new oa_Max_length_of_a_concatenated_string_with_unique_characters();
        System.out.println(s.maxLengthOfStr(new ArrayList<String>(Arrays.asList("ab", "cd", "aef", "hei"))));
    }
}
