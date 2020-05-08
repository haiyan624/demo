package com.wq.algorithm.tree.rb.map;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class MyConsistentHashingWithVirtualNode {
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111", "192.168.0.3:111",
            "192.168.0.4:111"};

    private static List<String> realServers = new LinkedList<>();

    private static SortedMap<Integer, String> virtualMap = new TreeMap<>();

    private static int virtualNum = 5;

    private final static String SPILT_STRING = "&&VN";

    static {
        for (String server : servers) {
            realServers.add(server);
        }

        for (String server : servers) {
            for (int i = 0; i < virtualNum; i++) {
                String virtualServer = server + SPILT_STRING + i;
                virtualMap.put(getHash(virtualServer), virtualServer);
                System.out.println("添加虚拟机：" + server + SPILT_STRING + i + "到：" + virtualServer);
            }
        }
    }

    private static String getServer(String ip){
        int ipHash =getHash(ip);
        SortedMap<Integer, String> tailMap = virtualMap.tailMap(ipHash);
        if(tailMap==null||tailMap.size()<=0){
            tailMap = virtualMap;
        }
        Integer currHash = tailMap.firstKey();
        String virtualNode = tailMap.get(currHash);
        return virtualNode.substring(0,virtualNode.indexOf(SPILT_STRING));
    }

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
     */
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    public static void main(String[] args) {
        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "10.211.0.1:3333", "223.213.34.67:2341"};
        for (int i = 0; i < nodes.length; i++)
            System.out
                    .println("[" + nodes[i] + "]的hash值为" + getHash(nodes[i]) + ", 被路由到结点[" + getServer(nodes[i]) + "]");
    }
}
