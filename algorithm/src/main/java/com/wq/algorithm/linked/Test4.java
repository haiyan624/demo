package com.wq.algorithm.linked;

import java.util.Stack;

public class Test4 {
    public static void main(String[] args) {
        Node head = new Node(1,new Node(2,new Node(3,new Node(4,null))));
        Test4.printList(head);
        Node rHead = Test4.reverse(head);
        Test4.printList(rHead);
        Node rHead2 = Test4.reverse2(rHead);
        Test4.printList(rHead2);

    }

    private static Node reverse2(Node head) {
        if(head ==null || head.next ==null){
            return head;
        } else {
                Node rHead = reverse2(head.next);
                head.next.next = head;
                head.next = null;
                return rHead;
        }
    }

    private static Node reverse(Node head) {
        Node pre = null;
        Node cur = head;
        while(cur !=null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur=next;
        }
        return pre;
    }

    public static void printList(Node node){
        while(node!=null){
            System.out.print(node.value + ",");
            node = node.next;
        }
        System.out.println();
    }
    public static void printFromTail(Node node){
        Stack<Node> stack = new Stack<>();
        while(node != null){
            stack.push(node);
            node = node.next;
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().value+",");
        }
        System.out.println();
    }
    public static  void printFromTail2(Node node){
        if(node ==null){
            return;
        }else if(node.next==null){
            System.out.print(node.value+",");
        }else{
            printFromTail2(node.next);
            System.out.print(node.value+",");
        }
    }


}
