package io.gitub.jast90.swt.component.tree;

import java.util.List;

public class TreeNode<T>{
    private String label;
    private T data;
    private List<TreeNode> children;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
