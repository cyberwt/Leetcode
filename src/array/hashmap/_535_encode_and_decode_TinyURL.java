package array.hashmap;

import java.util.HashMap;

/**
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
