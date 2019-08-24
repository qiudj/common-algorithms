package com.learning.algorithms.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 借助LinkedHashMap实现LRU算法,
 * 此方法修改值算一次访问
 */
public class LRUCache<K,V> {
    private static final float LOAD_FACTOR = 0.75f;
    private LinkedHashMap<K, V> map;
    private int cacheSize;

    public LRUCache(final int cacheSize) {
        this.cacheSize = cacheSize;
        int capacity = (int) (Math.ceil(cacheSize / LOAD_FACTOR) + 1);
        map = new LinkedHashMap<K,V>(capacity, LOAD_FACTOR, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
                return map.size() > LRUCache.this.cacheSize;
            }
        };
    }

    public synchronized V get(K key){
        return map.get(key);
    }

    public synchronized void put(K key, V value){
        map.put(key, value);
    }

    public void printCacheElements(){
        System.out.print("\n开始打印缓存内的元素...");
        for (Map.Entry<K,V> entry: map.entrySet()){
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }
    }
}
