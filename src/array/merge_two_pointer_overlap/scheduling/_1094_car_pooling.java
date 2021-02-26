package array.merge_two_pointer_overlap.scheduling;

import java.util.TreeMap;

/**
 *
 * see the bus as a black box, do the cacluation when when there's a start and stop
 * Use treemap, to store the locations in a ascending order
 * has a temporary value to record current values for the car
 *
 * use treemap T:O(NlogN) n is the total of the locations, S:O(N)
 *
 * If I already knew the number of stops, not need to has a treemap, a fixed number of buck is enough
 *
 *
 * 2/14/21.
 */
public class _1094_car_pooling {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer,Integer>();
        for(int i=0; i<trips.length; i++){
            map.put(trips[i][1],map.getOrDefault(trips[i][1],0) + trips[i][0]);
            map.put(trips[i][2],map.getOrDefault(trips[i][2],0) - trips[i][0]);
        }
        int val =0;
        for(int num: map.values()){
            val +=num;
            if(val > capacity){
                return false;
            }
        }
        return true;
    }
}
