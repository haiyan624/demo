package com.wq.algorithm.tree.find;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Objects;

public class Node {
    /**
     * 关键字段
     */
    public int index;

    /**
     * 值
     */
    public String data;

    /**
     * 左子树
     */
    public Node leftNode;

    /**
     * 右子树
     */
    public Node rightNode;

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
