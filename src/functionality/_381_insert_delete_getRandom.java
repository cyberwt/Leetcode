package functionality;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * > 和前面一样的
 *
 *  > if(把lastElement的位置，跟新一遍,list里的位置，map中set 的位置，add one value, remove one)
 *  > delete last element, remove if not exist any more
 *
 *
 *
 * 10/27/20.
 */
public class _381_insert_delete_getRandom {
    ArrayList<Integer> nums;
    HashMap<Integer, Set<Integer>> locs;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public _381_insert_delete_getRandom() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Set<Integer>>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) locs.put( val, new LinkedHashSet<Integer>() );
        locs.get(val).add(nums.size());
        nums.add(val);
        return ! contain ;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) return false;
        int loc = locs.get(val).iterator().next();
        locs.get(val).remove(loc);
        if (loc < nums.size() - 1 ) {
            int lastone = nums.get( nums.size()-1 );
            nums.set( loc , lastone );
            locs.get(lastone).remove( nums.size()-1);
            locs.get(lastone).add(loc);
        }
        nums.remove(nums.size() - 1);

        if (locs.get(val).isEmpty()) locs.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}
