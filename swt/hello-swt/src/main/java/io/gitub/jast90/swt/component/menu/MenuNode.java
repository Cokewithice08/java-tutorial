package io.gitub.jast90.swt.component.menu;

import java.util.List;

public class MenuNode {
    private String title;
    private List<MenuNode> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuNode> getChildren() {
        return children;
    }

    public void setChildren(List<MenuNode> children) {
        this.children = children;
    }
}
