package io.gitub.jast90.swt.component.tree;

import io.gitub.jast90.swt.component.base.AbstractTest;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;
import java.util.List;

public class MyTreeTest extends AbstractTest {

    public MyTreeTest(String title) {
        super(title);
    }

    @Override
    protected void addComponent(Shell shell) {
        MyTree myTree = new MyTree(shell, SWT.BORDER, getData());
    }

    public static void main(String[] args) {
        new MyTreeTest("自定义tree");
    }

    public static List<TreeNode> getData(){
        List<TreeNode> list = new ArrayList<>();
        TreeNode<String> node;
        for (int i = 0; i < 10; i++) {
            node = new TreeNode();
            node.setLabel("label"+i);
            node.setData(String.valueOf(i));
            list.add(node);
        }
        return list;
    }
}
