package iterate_recursioin;

import java.util.HashMap;
import java.util.Map;

class flatten_dictionary {

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        // your code goes here
        HashMap<String, String> map = new HashMap<String, String>();
        dfs(map, "", dict);
        return map;
    }


    static void dfs(HashMap<String,String> map,String str,HashMap<String, Object> dict){
        for(String key: dict.keySet()){
            if (dict.get(key)  instanceof Map){
                if(str.length() == 0){
                    dfs(map,key,((HashMap) dict.get(key)));
                }else{
                    dfs(map,str+"."+key,((HashMap) dict.get(key)));
                }


            }else{
                Object value = dict.get(key);
                if(str.length() == 0){
                    map.put(key,value.toString());
                }else{
                    map.put(key,str+"."+value.toString());
                }
            }

            }
        }



    public static void main(String[] args) {
        HashMap<String,Object> test = new HashMap<String,Object>();
        test.put("1", "123");
        HashMap<String,String> test2 = new HashMap<String,String>();
        test2.put("2", "234");
        test.put("3",test2);


        flatten_dictionary solution = new flatten_dictionary();
        HashMap<String,String> map = solution.flattenDictionary(test);
        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
    }

}