package com.wq.algorithm.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RBHashMapTest {
    public static void main(String[] args) {
        String[] aa =new String[2];
        aa[0]="";
        Map<Key,String> map = new HashMap<>(1);
        // 64*0.75=48
        for (int i=0;i<63;i++){
            map.put(new Key(i*2+1),i*2+1+"vv");
        }
    }
}
