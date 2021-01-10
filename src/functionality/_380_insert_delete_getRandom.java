package functionality;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * > 无论怎样都要把最后一个元素和map里的元素移除
 * > 但多的一步是，我要不要放到swap lastEle 和 curEle
 *
 * > 一开始为什么不行，因为加括号套住： random.nextInt(n) <-> (int)(Math.random()*n)
 * > 不需要 size,list.size() 即可
 *
 * 10/27/20.
 */
public class _380_insert_delete_getRandom {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public _380_insert_delete_getRandom() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }

        map.put(val,list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        if(index < list.size() -1){
            int lastEle = list.get(list.size()-1);
            list.set(index,lastEle);
            map.put(lastEle,index);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }


    /** Get a random element from the set. */
    public int getRandom() {

        return list.get(rand.nextInt(list.size()) );
    }
}
