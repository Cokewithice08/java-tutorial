package io.gitub.jast90.swt.component;

import io.gitub.jast90.swt.component.base.AbstractTest;
import io.gitub.jast90.swt.component.menu.MyMenu;
import io.gitub.jast90.swt.component.menu.MyMenuTest;
import io.gitub.jast90.swt.component.tab.TabTable;
import io.gitub.jast90.swt.component.tree.MyTree;
import io.gitub.jast90.swt.component.tree.MyTreeTest;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;


public class MySQLGUI extends AbstractTest {

    public MySQLGUI(String title) {
        super(title);
    }

    @Override
    protected void addComponent(Shell shell) {
        new MyTree(shell, SWT.BORDER, MyTreeTest.getData(),shell);
        new MyMenu(shell, SWT.BAR, MyMenuTest.getData(),shell);
        TabTable tabTable = new TabTable(shell, SWT.BORDER, shell);
        tabTable.pack();
    }

    public static void main(String[] args) {
        new MySQLGUI("MySQL客户端");
    }
}
