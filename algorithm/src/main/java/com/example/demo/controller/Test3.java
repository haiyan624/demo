package com.example.demo.controller;

import com.example.demo.controller.entity.Node;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

@RestController
@RequestMapping("/test2")
public class Test3 {
    @RequestMapping(value = { "/conf" }, method = RequestMethod.GET)
    public ResponseEntity<String> getEmailConfPage() throws Exception {
        this.test();
        return new ResponseEntity<String>("sssssss", HttpStatus.OK);
    }

    public void test(){
        Node head = new Node(1,new Node(2,null));
        this.printForTail1(head);
    }

    public void reverse1(Node head){
        Node pre = null;
        Node cur = head;
        while(cur.next!=null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur=next;
        }
    }

    public Node reserse2(Node head){
        if(head == null || head.next == null){
            return head;
        } else{
            Node rHead = reserse2(head.next);
            head.next.next = head;
            head.next = null;
            return rHead;
        }
    }

    public void printFromHead(Node node){
        Node cur = node;
        while(cur!=null){
            System.out.print(node.value + ',');
            node = node.next;
        }
        System.out.println();
    }

    public void printForTail1(Node node) {
        Stack<Node> stack = new Stack<>();
        while(node!=null){
            stack.push(node);
            node = node.next;
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().value + ",");
        }
        System.out.println();
    }
}
