package io.gitub.jast90.swt.component.tree;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import java.util.List;

public class MyTree extends Composite {
    private List<TreeNode> data;
    private Tree tree;
    private Shell shell;

    public MyTree(Composite parent, int style, List<TreeNode> data, Shell shell) {
        super(parent, style);
        shell.setLayout(new RowLayout());
        this.data = data;
        this.shell = shell;
        init();

    }

    private void init(){
        tree = new Tree(this, SWT.BORDER);
        for (TreeNode each : this.data) {
            TreeItem root = new TreeItem (tree, 0);
            root.setText (each.getLabel());
            root.setData (each.getData());
            new TreeItem (root, 0);
        }
        tree.pack();
    }

    public void onTreeExpand(TreeListener listener){
        tree.addTreeListener(listener);
    }
}
