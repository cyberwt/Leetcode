package microsoft.oa;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_Day_of_week_that_is_K_days_later {
    public static String dayOfWeek(String S, int K) {
        List<String> days = new ArrayList<String>(Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
        return days.get((days.indexOf(S) + K) % 7);
    }


    public static void main(String[] args) {
        System.out.println(dayOfWeek("Sat", 23));
    }
}
