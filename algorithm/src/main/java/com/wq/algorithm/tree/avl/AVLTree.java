package com.wq.algorithm.tree.avl;

public class AVLTree {
    public AVLNode root;

    /**
     * 求高
     *
     * @param tRoot
     * @return
     */
    private int getHeight(AVLNode tRoot) {
        if (tRoot == null) {
            return 0;
        }
        return Math.max(getHeight(tRoot.left), getHeight(tRoot.right)) + 1;
    }

    /**
     * LL型
     *
     * @param tRoot
     * @return
     */
    private AVLNode singleRotateLeft(AVLNode tRoot) {
        AVLNode nowRoot = tRoot.left;
        tRoot.left = nowRoot.right;
        nowRoot.right = tRoot;

        tRoot.height = getHeight(tRoot);
        nowRoot.height = getHeight(nowRoot);
        return nowRoot;
    }

    /**
     * RR型
     *
     * @param tRoot
     * @return
     */
    private AVLNode singleRotateRight(AVLNode tRoot) {
        AVLNode nowRoot = tRoot.right;
        tRoot.right = nowRoot.left;
        nowRoot.left = tRoot;

        nowRoot.height = getHeight(nowRoot);
        tRoot.height = getHeight(tRoot);
        return nowRoot;
    }

    /**
     * LR型
     *
     * @param tRoot
     * @return
     */
    private AVLNode doubleRotateWithLeft(AVLNode tRoot) {
        tRoot.left = singleRotateRight(tRoot.left);
        return singleRotateLeft(tRoot);
    }

    /**
     * RL型
     *
     * @param tRoot
     * @return
     */
    private AVLNode doubleRotateWithRight(AVLNode tRoot) {
        tRoot.right = singleRotateLeft(tRoot.right);
        return singleRotateRight(tRoot);
    }

    private void insert(int data) {
        this.root = insert(data, root);
    }

    private AVLNode insert(int data, AVLNode tRoot) {
        if (tRoot == null) {
            tRoot = new AVLNode();
            tRoot.data = data;
        }

        if (data < tRoot.data) {
            tRoot.left = insert(data, tRoot.left);
            // 左子树高度比右子树大2
            if (getHeight(tRoot.left) - getHeight(tRoot.right) == 2) {
                if (data < tRoot.left.data) {
                    tRoot = singleRotateLeft(tRoot);
                } else {
                    tRoot = doubleRotateWithLeft(tRoot);
                }
            }
        } else if (data > tRoot.data) {
            tRoot.right = insert(data, tRoot.right);
            if (getHeight(tRoot.right) - getHeight(tRoot.left) == 2) {
                if (data < tRoot.right.data) {
                    tRoot = doubleRotateWithRight(tRoot);
                } else {
                    tRoot = singleRotateRight(tRoot);
                }
            }
        }
        tRoot.height = getHeight(tRoot);
        return tRoot;
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        for (int i = 1; i < 32; i++) {
            avlTree.insert(i);
        }
        TreeOperation.show(avlTree.root);
    }
}
