package greedy.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * > 有些明白了，大数先插，占位，小数后来者居上，一定满足题意
 *
 * > T:O(NlngN) S:O(1)
 *
 * 10/2/20.
 *
 *
 * 2:
 * >
 * 在最优情况下， 先把大神高的人查好，因为，他们不灵活，若身高相同了，先插index小的
 * 先解决 || 有复杂条件的
 *
 * > return (list-> arraylist)
 * list.toArray(new int[list.size()][]);
 *
 */
public class _406_queue_reconstruction_by_height {

    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length ==0 || people[0].length == 0){
            return people;
        }
        Arrays.sort(people, (a, b) -> a[0]==b[0]? a[1]-b[1] : b[0]-a[0]);

        List<int[]> list = new ArrayList<>();
        for(int[] val: people){
            System.out.println("val[0]: " + val[0] + " val[1]:" +val[1]);
            list.add(val[1], val);
        }
        return list.toArray(new int[list.size()][]);
    }
}
