package array.hashmap;

import java.util.HashMap;

/**
 *
 * E1: initial 3 variables as indexMap, reIndexMap, base_host
 * E2: 结果跟原数组无关，用index get the index number
 * E3: do{} while();, ; 漏写了
 * E4: hashmap.get   null if this map contains no mapping for the key.
 *
 * T:O(1) S:O(1)
 *
 *  3/14/21
 * Why here is a do-while, because key comes later, when it comes, CHECK it's unique
 * >
 * >
 *
 *
 * 两个map放 分别以 longUrl 和 shortUrl 作为<key,value> 放进去， 用charSet得到一个random的char
 * 一个base_host: "http://tinyurl.com/"
 *
 * 9/7/20.
 */
public class _535_encode_and_decode_TinyURL {
    HashMap<String, String> index = new HashMap<String, String>();
    HashMap<String, String> reIndex = new HashMap<String, String>();
    private static String BASE_HOST = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(index.containsKey(longUrl)) return BASE_HOST + index.get(longUrl);
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = null;

        do{
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<6;i++){
                int r = (int)(Math.random() * charSet.length());
                sb.append(charSet.charAt(r));
            }
            key = sb.toString();

        }while(reIndex.containsKey(key));
        index.put(longUrl, key);
        reIndex.put(key,longUrl);
        return BASE_HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return reIndex.get(shortUrl.replace(BASE_HOST, ""));
    }
}
