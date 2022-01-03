package io.github.jast90.zk.client.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class Main extends Composite {
    private StyledText text;
    private ZkTree zkTree;

    public Main(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(2, false));
        zkTree = new ZkTree(this, SWT.NONE);
        GridData gd_tree = new GridData(SWT.LEFT, SWT.FILL, false, false,
                1, 1);
        gd_tree.minimumWidth = 100;
        gd_tree.widthHint = 300;
        zkTree.setLayoutData(gd_tree);

        text = new StyledText(this, SWT.NONE);
        text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
                1, 1));
        zkTree.setText(text);

    }

    public void updateTree(){
        zkTree.updateTree();
    }
}
