package com.wq.algorithm.tree.find;

import com.wq.algorithm.tree.TreeOperation;

public class FindTreeUtil {

    private Node root;

    public static void main(String[] args) {
        FindTreeUtil util = new FindTreeUtil();
        util.insertNode(8,"");
        util.insertNode(4,"");
        util.insertNode(12,"");
        util.insertNode(2,"");
        util.insertNode(6,"");
        util.insertNode(10,"");
        util.insertNode(14,"");
        util.insertNode(1,"");
        util.insertNode(3,"");
        util.insertNode(5,"");
        util.insertNode(7,"");
        util.insertNode(9,"");
        util.insertNode(11,"");
        util.insertNode(13,"");
        util.insertNode(15,"");
        TreeOperation.show(util.root);
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        TreeOperation.show(util.findNode(12));
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        util.delete(5);
        TreeOperation.show(util.root);
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        util.delete(1);
        TreeOperation.show(util.root);
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        util.delete(2);
        TreeOperation.show(util.root);
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        util.delete(12);
        TreeOperation.show(util.root);
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        util.delete(10);
        TreeOperation.show(util.root);
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        util.delete(9);
        TreeOperation.show(util.root);
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        util.delete(13);
        TreeOperation.show(util.root);
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        util.delete(8);
        TreeOperation.show(util.root);
    }
    /**
     * 查找节点
     * curr轮询，curr.index与key比较，相同则返回当前节点
     * 小于当前节点则当前节点指向左子树
     * 大于则指向右子树
     * 再来个判断，刚才节点指向左右子树时，左右子树是否为空，为空则返回空
     *
     * @param key
     * @return
     */
    public Node findNode(int key) {
        Node curr = root;
        while (curr.index != key) {
            if (key < curr.index) {
                curr = curr.leftNode;
            } else {
                curr = curr.rightNode;
            }
            if (curr == null) {
                return null;
            }
        }
        return curr;
    }

    /**
     * 插入节点
     * 局部变量parent=root
     * key与parent的index相等，则parent的value设置成想要的数据
     * 父index小于key，则看左节点，左节点为空则直接插入，不为空则父等于左节点，向下比那里
     * 反之则类似逻辑处理右节点
     *
     * @param key
     * @param value
     */
    public void insertNode(int key, String value) {
        Node node = new Node();
        node.index = key;
        node.data = value;

        if(root==null){
            root = node;
            return;
        }

        Node parent = root;
        while (true) {
            if (parent.index == key) {
                parent.data = value;
                return;
            } else if (key < parent.index) {
                if (parent.leftNode == null) {
                    parent.leftNode = node;
                    return;
                } else {
                    parent = parent.leftNode;
                }
            } else {
                if (parent.rightNode == null) {
                    parent.rightNode = node;
                    return;
                } else {
                    parent = parent.rightNode;
                }
            }

        }

    }

    /**
     * 中序遍历
     * 左-中-右
     *
     * @param root
     */
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.leftNode);
            System.out.println("访问当前节点：" + root.index + "---" + root.data);
            inOrder(root.rightNode);
        }
    }

    /**
     * 删除节点
     * 查找节点
     * 查不到返回false
     * 查到
     * 节点为叶子节点，则将父节点对应的左子树还是右子树设置为空
     * 节点有一个子节点，则将父节点对应的左子树还是右子树设置为节点的子节点
     * 节点有两个子节点，则查找以右子树中的最小节点填补当前节点。
     *
     * @param key
     * @return
     */
    public boolean delete(int key) {
        Node parent = root;
        Node curr = root;
        boolean isChildLeft = false;
        while (curr.index != key) {
            if (key<curr.index) {
                parent = curr;
                curr = curr.leftNode;
                isChildLeft = true;
            } else {
                parent = curr;
                curr = curr.rightNode;
            }
            if (curr == null) {
                break;
            }
        }
        if (curr == null) {
            // 没找到，返回false
            return false;
        }

        // 当前节点的左右子树都为空
        if (curr.leftNode == null && curr.rightNode == null) {
            if (curr == root) {
                root = null;
            } else {
                if (isChildLeft) {
                    parent.leftNode = null;
                } else {
                    parent.rightNode = null;
                }
            }
        } else if (curr.leftNode == null || curr.rightNode == null) {
            // 当前节点的一个子树为空，另一个不为空(上面已经判断左右子树都为空的情况)
            if (curr.leftNode == null) {
                // 左子树为空
                if (curr == root) {
                    root = curr.rightNode;
                } else {
                    if (isChildLeft) {
                        parent.leftNode = curr.rightNode;
                    } else {
                        parent.rightNode = curr.rightNode;
                    }
                }
            } else {
                // 右子树为空
                if (curr == root) {
                    root = curr.leftNode;
                } else {
                    if (isChildLeft) {
                        parent.leftNode = curr.leftNode;
                    } else {
                        parent.rightNode = curr.leftNode;
                    }
                }
            }
        } else {
            // 左右子树都不为空的情况：
            Node minRight = findMinRight(curr.rightNode);
            minRight.leftNode = curr.leftNode;
            if(curr==root){
                root=minRight;
            } else{
                if(isChildLeft){
                    parent.leftNode =minRight;
                } else{
                    parent.rightNode = minRight;
                }
            }
        }

        return true;
    }

    /**
     * 重建root，找到最小节点作为当前节点的root，并将原来的root作为右子树
     * 注意，需要将原始位置上的最小节点从原始位置上删除
     *
     * @param root
     * @return
     */
    private Node findMinRight(Node root) {
        if (root.leftNode == null) {
            return root;
        }
        Node parent = root;
        Node curr = root;
        while (curr.leftNode != null) {
            parent = curr;
            curr = curr.leftNode;
        }

        if (curr.rightNode==null){
            //当前最小节点是叶子节点，则将父节点的左节点置为空
            parent.leftNode=null;
        } else{
            // 当前节点的右节点不为空，则将父节点的左节点置为当前节点的左节点
            parent.leftNode=curr.rightNode;
        }
        curr.rightNode=root;
        return curr;

    }
}
