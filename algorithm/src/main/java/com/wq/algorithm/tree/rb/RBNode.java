package com.wq.algorithm.tree.rb;


import java.util.HashMap;
import java.util.Map;

public class RBNode {
    public RBNode parent;
    public RBNode left;
    public RBNode right;
    public boolean red;
    public int data;


    public RBNode(int data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>(32);
        map.put("1","aa");
    }
}