package com.learning.algorithms.string;


public class Solution{
    public static void main(String[] args) {
        //sample
 /*       LinkedHashMap<String,String> recordMap = new LinkedHashMap<String, String>(16,0.75f,true);
        recordMap.put("PG", "80");
        recordMap.put("SG", "91");
        recordMap.put("SF", "79");
        recordMap.put("PF", "90");
        recordMap.put("C", "78");

        recordMap.get("PF");
        recordMap.get("PF");
        recordMap.get("PF");
        recordMap.get("PF");

        for (Map.Entry<String,String> entry: recordMap.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }*/

        LRUCache<String, String> cache = new LRUCache<String, String>(10 * 10000);

        for (int i = 0; i < 200000 ; i++) {
            cache.put(String.valueOf(i),"777-"+i);
        }


        for (int i = 100020; i < 100060; i++){
            System.out.println(cache.get(String.valueOf(i)));
        }

        System.out.println("---");

    }
}