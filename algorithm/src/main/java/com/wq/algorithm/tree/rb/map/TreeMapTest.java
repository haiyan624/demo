package com.wq.algorithm.tree.rb.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        for(int i=0;i<10;i++){
            if(i!=5){
                map.put(i,i+"va");
            }
        }
        printMap(map);
        printMap(map.tailMap(4));
        printMap(map.headMap(4));
        map.headMap(4).put(1,"ss");
        // 是快速失败
//        map.firstEntry().setValue("q");
        printMap(map);
    }

    public static void printMap(Map<Integer,String> map){
        System.out.println("-----------");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.print(entry.getKey()+":"+entry.getValue()+"---");
        }
        System.out.println("-----------");
    }
}
