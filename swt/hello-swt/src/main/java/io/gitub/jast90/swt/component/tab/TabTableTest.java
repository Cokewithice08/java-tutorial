package io.gitub.jast90.swt.component.tab;

import io.gitub.jast90.swt.component.base.AbstractTest;
import io.gitub.jast90.swt.component.table.MyTable;
import io.gitub.jast90.swt.component.table.TableData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;
import java.util.List;

public class TabTableTest extends AbstractTest {
    public TabTableTest(String title) {
        super(title);
    }

    @Override
    protected void addComponent(Shell shell) {
        TabTable tabTable = new TabTable(shell, SWT.BORDER, shell);
        tabTable.pack();
    }

    public static void main(String[] args) {
        new TabTableTest("自定义tabTable");
    }
}
