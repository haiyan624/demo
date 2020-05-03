package com.wq.algorithm.tree.find;

public class FindTreeUtil {

    public static Node findNode(Node root,int key){
        Node curr = root;
        while(curr.index!=key){
            if(key<curr.index){
                curr = curr.leftNode;
            } else if(key > curr.index){
                curr = curr.rightNode;
            } else if(curr==null){
                return null;
            }
        }
        return curr;
    }

    public static void inserNode(Node root, int key, String value){
        Node node = new Node();
        node.index=key;
        node.data=value;


    }
}
