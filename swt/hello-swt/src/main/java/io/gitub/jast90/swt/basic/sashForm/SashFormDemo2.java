package io.gitub.jast90.swt.basic.sashForm;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2022/1/13 10:39
 */
public class SashFormDemo2 {
    public static void main(String[] args) {
        final Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Snippet 109");
        shell.setLayout(new FillLayout());

        SashForm form = new SashForm(shell, SWT.HORIZONTAL);
        form.setLayout(new FillLayout());

        Composite child1 = new Composite(form, SWT.NONE);
        child1.setLayout(new FillLayout());
        final Tree tree = new Tree(child1, SWT.NONE);
        TreeItem trtmNewTreeitem = new TreeItem(tree, SWT.NONE);
        trtmNewTreeitem.setText("New TreeItem");

        TreeItem trtmNewTreeitem_2 = new TreeItem(trtmNewTreeitem, SWT.NONE);
        trtmNewTreeitem_2.setText("New TreeItem");


        Composite child3 = new Composite(form, SWT.NONE);
        child3.setLayout(new FillLayout());

        SashForm form1 = new SashForm(child3, SWT.VERTICAL);
        Text text = new Text(form1, SWT.BORDER);

        TabFolder tabFolder = new TabFolder(form1, SWT.BORDER);
        form1.setWeights(new int[]{60, 40});

        TabItem item = new TabItem(tabFolder, SWT.NONE);
        item.setText("TabItem1 ");

        TabItem item2 = new TabItem(tabFolder, SWT.NONE);
        item2.setText("TabItem2 ");

        Table table = new Table(tabFolder, SWT.BORDER | SWT.FULL_SELECTION);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        item.setControl(table);
        TableColumn tableColumn = new TableColumn(table, SWT.NONE);
        tableColumn.setWidth(100);
        tableColumn.setText("1");

        TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
        tableColumn_1.setWidth(100);
        tableColumn_1.setText("2");

        TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
        tableColumn_2.setWidth(100);
        tableColumn_2.setText("3");

        form.setWeights(new int[]{20, 80});
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }
}
