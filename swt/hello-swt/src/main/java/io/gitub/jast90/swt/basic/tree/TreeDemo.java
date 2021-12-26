package io.gitub.jast90.swt.basic.tree;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import java.io.File;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/14 13:33
 */
public class TreeDemo {
    public static void main (String [] args) {
        final Display display = new Display ();
        final Shell shell = new Shell (display);
        shell.setText ("Lazy Tree");
        shell.setLayout (new FillLayout());
        final Tree tree = new Tree(shell, SWT.BORDER);
        for (File rootFile : File.listRoots ()) {
            TreeItem root = new TreeItem (tree, 0);
            root.setText (rootFile.toString ());
            root.setData (rootFile);
            new TreeItem (root, 0);
        }
        tree.addListener (SWT.Expand, event -> {
            final TreeItem root = (TreeItem) event.item;
            TreeItem [] items = root.getItems ();
            for (TreeItem item : items) {
                if (item.getData () != null) return;
                item.dispose ();
            }
            File file = (File) root.getData ();
            File [] files = file.listFiles ();
            if (files == null) return;
            for (File rootFile : files) {
                TreeItem item = new TreeItem (root, 0);
                item.setText (rootFile.getName ());
                item.setData (rootFile);
                if (rootFile.isDirectory()) {
                    new TreeItem (item, 0);
                }
            }
        });
        Point size = tree.computeSize (300, SWT.DEFAULT);
        int width = Math.max (300, size.x);
        int height = Math.max (300, size.y);
        shell.setSize (shell.computeSize (width, height));
        shell.open ();
        while (!shell.isDisposed ()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }
        display.dispose ();
    }
}
