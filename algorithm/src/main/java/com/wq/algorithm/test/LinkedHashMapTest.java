package com.wq.algorithm.test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(10, 0.75f, true);
        for (int i = 1; i <= 6; i++) {
            map.put(i + "", i + "value");
        }
        map.get(1 + "");
        map.get(2 + "");
//        Collection<String> values = map.values();
//        for (String value : values) {
//            System.out.println(value);
//        }
//        Set<Map.Entry<String, String>> entries = map.entrySet();
//        for (Map.Entry<String, String> entry : entries) {
//            System.out.println(entry.getValue());
//        }
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getValue());
        }
    }
}
