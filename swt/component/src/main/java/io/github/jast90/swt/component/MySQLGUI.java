package io.github.jast90.swt.component;

import io.github.jast90.swt.component.base.AbstractTest;
import io.github.jast90.swt.component.menu.MyMenu;
import io.github.jast90.swt.component.menu.MyMenuTest;
import io.github.jast90.swt.component.tab.TabTable;
import io.github.jast90.swt.component.tree.MyTree;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;


public class MySQLGUI extends AbstractTest {

    public MySQLGUI(String title) {
        super(title);
    }

    @Override
    protected void addComponent(Shell shell) {
//        shell.setLayout(new GridLayout());
        new MyTree(shell, SWT.BORDER);
        new MyMenu(MyMenuTest.getData(),shell);
        TabTable tabTable = new TabTable(shell, SWT.NONE, shell);
        tabTable.pack();
    }

    public static void main(String[] args) {
        new MySQLGUI("MySQL客户端");
    }
}
