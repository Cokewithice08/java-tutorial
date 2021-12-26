package io.gitub.jast90.swt.component.menu;

import io.gitub.jast90.swt.component.base.AbstractTest;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;
import java.util.List;

public class MyMenuTest extends AbstractTest {

    public MyMenuTest(String title) {
        super(title);
    }

    @Override
    protected void addComponent(Shell shell) {
        new MyMenu(shell, SWT.BAR,getData(),shell);
    }

    public static List<MenuNode> getData() {
        List<MenuNode> list = new ArrayList<>();
        MenuNode menuNode;
        for (int i = 0; i < 10; i++) {
            menuNode = new MenuNode();
            menuNode.setTitle("菜单"+i);
            list.add(menuNode);
        }
        return list;
    }

    public static void main(String[] args) {
        new MyMenuTest("自定义菜单");
    }
}
