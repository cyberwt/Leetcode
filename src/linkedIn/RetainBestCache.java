package linkedIn;

import java.util.*;

/**
 * Created by weitong on 5/10/21.
 */
public class RetainBestCache<K, T extends RetainBestCache.Rankable> {
    private Map<K, T> cache;
    private PriorityQueue<Long, Set<K>> rankingObject;
    private int maxSizeOfCache;
    private DataSource<K, T> dataSource;


    /* Constructor with a data source (assumed to be slow) and a cache size */
    public RetainBestCache(DataSource<K, T> ds, int entriesToRetain) {
        dataSource = ds;
        cache = new HashMap<>;
        rankingObject = new PriorityQueue<Wrapper>(new Comparator<Wrapper>() {
            @Override
            public int compare(Wrapper w1, Wrapper w2) {
                return w1.data.getOrder() - w2.data.getOrder();
            }
        });
        maxSizeOfCache = entriesToRetain;
    }

    class Wrapper{
        K key;
        T value;
        Wrapper(K key, T value){
            this.key = key;
            this.value = value;
        }
    }

    /* Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,
    * retrieves it from the data source. If the cache is full, attempt to cache the returned data,
    * evicting the T with lowest rank among the ones that it has available
    * If there is a tie, the cache may choose any T with lowest rank to evict.
    */
    public T get(K key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return fetchDataFromDs(key);

    }

    public T fetchDataFromDs(K key) {
        if(cache.size() >= maxSizeOfCache){
            evictElement();
        }
        T object = dataSource.get(key);
        cache.put(key, object);
        long rankOfObject = object.getRank();
        cache.put(key, );
    }

    /*
    * For reference, here are the Rankable and DataSource interfaces.
    * You do not need to implement them, and should not make assumptions
    * about their implementations.
    */
    public interface Rankable {
        /**
         * Returns the Rank of this object, using some algorithm and potentially
         * the internal state of the Rankable.
         */
        long getRank();
    }

    public interface DataSource<K, T extends Rankable> {
        T get(K key);
    }
}
