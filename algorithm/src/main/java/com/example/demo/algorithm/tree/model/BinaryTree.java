package com.example.demo.algorithm.tree.model;

import java.util.Stack;

/**
 * @author Mickey
 */
public class BinaryTree {
    private BinaryTreeNode root;


    public BinaryTree() {
    }

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void createTree(){
        root = new BinaryTreeNode();
        root.setValue(1);
        BinaryTreeNode node2 = new BinaryTreeNode();
        node2.setValue(2);
        BinaryTreeNode node3 = new BinaryTreeNode();
        node3.setValue(3);
        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.setValue(4);
        BinaryTreeNode node5 = new BinaryTreeNode();
        node5.setValue(5);
        BinaryTreeNode node6 = new BinaryTreeNode();
        node6.setValue(6);
        BinaryTreeNode node7 = new BinaryTreeNode();
        node7.setValue(7);
        BinaryTreeNode node8 = new BinaryTreeNode();
        node8.setValue(8);
        BinaryTreeNode node9 = new BinaryTreeNode();
        node9.setValue(9);
        BinaryTreeNode node10 = new BinaryTreeNode();
        node10.setValue(10);
        BinaryTreeNode node11 = new BinaryTreeNode();
        node11.setValue(11);

        root.setLeftChild(node2);
        root.setRightChild(node3);
        node2.setLeftChild(node4);
        node2.setRightChild(node5);
        node3.setLeftChild(node6);
        node3.setRightChild(node7);
        node4 .setLeftChild(node8);
        node4.setRightChild(node9);
        node5 .setLeftChild(node10);
        node5.setRightChild(node11);
    }
    /**
     * 清空树
     */
    public void clear() {
        clear(root);
    }

    private void clear(BinaryTreeNode node) {
        if (node != null) {
            clear(node.getLeftChild());
            clear(node.getRightChild());
            // 删除节点
            node = null;
        }
    }

    /**
     * 判断二叉树是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 得到树的高度
     *
     * @return
     */
    public int getTreeHight() {
        return getTreeHight(root);
    }

    private int getTreeHight(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHight = getTreeHight(node.getLeftChild());
            int rightHight = getTreeHight(node.getRightChild());
            return leftHight > rightHight ? leftHight + 1 : rightHight + 1;
        }
    }

    /**
     * 获取二叉树的节点数
     * @return
     */
    public int size() {
        return size(root);
    }

    private int size(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return size(node.getLeftChild()) + size(node.getRightChild()) + 1;
        }
    }

    public BinaryTreeNode getParentNode(BinaryTreeNode node){
        return getParentNode(root,node);
    }

    private BinaryTreeNode getParentNode(BinaryTreeNode parent, BinaryTreeNode node) {
        if(parent==null){
            return null;
        }else if(parent.getLeftChild()==node|| parent.getRightChild()==node){
            return parent;
        } else{
            BinaryTreeNode left = getParentNode(parent.getLeftChild(),node);
            if(left==null){
                BinaryTreeNode right = getParentNode(parent.getRightChild(),node);
                return right;
            }else{
                return left;
            }
        }
    }
    /**
     * 获取某个节点的左子树
     */
    public BinaryTreeNode getleftTree(BinaryTreeNode node){
        return node.getLeftChild();
    }

    /**
     * 获取某个节点的右子树
     * @param node
     * @return
     */
    public BinaryTreeNode getrightTree(BinaryTreeNode node){
        return node.getRightChild();
    }

    /**
     *  给某个节点插入左节点
     * @param parent
     * @param newnode
     */
    public void insertLeft(BinaryTreeNode parent,BinaryTreeNode newnode){
        parent.setLeftChild(newnode);
    }

    /**
     *  给某个节点插入右节点
     * @param parent
     * @param newnode
     */
    public void insertRitht(BinaryTreeNode parent,BinaryTreeNode newnode){
        parent.setRightChild(newnode);
    }

    /**
     * 先序遍历
     * @param node
     */
    public void preOrder(BinaryTreeNode node){
        if(node!=null){
            System.out.print(node.getValue()+",");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    public void preOrder2(BinaryTreeNode node){
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            BinaryTreeNode tempNode = stack.pop();
            System.out.print(tempNode.getValue()+",");
            if(tempNode.getRightChild()!=null){
                stack.push(tempNode.getRightChild());
            }
            if(tempNode.getLeftChild()!=null){
                stack.push(tempNode.getLeftChild());
            }
        }
    }

    public void inOrder2(BinaryTreeNode node){
        if(node == null){
            return;
        }
        BinaryTreeNode p = root;
        BinaryTreeNode pVisit = null;
        Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();
        stk.add(p);

        while(stk.isEmpty() == false) {
            //只要你有左孩子，就将左孩子压入栈中
            if(p!=null && p.getLeftChild()!=null) {
                stk.add(p.getLeftChild());
                p = p.getLeftChild();
            }else {
                p = stk.peek();//栈顶元素，先出栈，可能还有右孩子
                if(p.getRightChild()==null  || p.getRightChild()==pVisit) {//如果没有右孩子或右孩子已经访问过了，出栈
                    System.out.print(p.getValue()+" ");
                    pVisit = p;//这个很重要，考虑一下只有右孩子的树，得不断的回溯
                    p = null;//没有新节点加入，继续进行出栈操作
                    stk.pop();
                }else {//如果有右孩子，右孩子入栈
                    pVisit = p.getRightChild();
                    stk.add(p.getRightChild());
                    p = p.getRightChild();
                }
            }
        }
    }

    public void  postOrder2(BinaryTreeNode node){
        if(node==null){
            return;
        }

    }

    private void vistNode(BinaryTreeNode node){
        System.out.print(node.getValue()+",");
    }
    public void inOrder(BinaryTreeNode node){
        if(node!=null){
            inOrder(node.getLeftChild());
            System.out.print(node.getValue()+",");
            inOrder(node.getRightChild());
        }
    }

    public void postOrder(BinaryTreeNode node){
        if(node!=null){
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
            System.out.print(node.getValue()+ ",");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createTree();
        tree.preOrder(tree.root);
        System.out.println();
        tree.preOrder2(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.inOrder2(tree.root);


    }
}
