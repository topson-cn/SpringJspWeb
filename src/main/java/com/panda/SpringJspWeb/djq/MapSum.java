package com.panda.SpringJspWeb.djq;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class MapSum {

    private Map<String, Integer> datas = new HashMap<>();

    /** Initialize your data structure here. */
    public MapSum() {
    }
    
    public void insert(String key, int val) {
        datas.put(key,val);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        Set<Map.Entry<String, Integer>> entries = datas.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getKey().startsWith(prefix)){
                sum += entry.getValue();
            }
        }
        return sum;
    }
}