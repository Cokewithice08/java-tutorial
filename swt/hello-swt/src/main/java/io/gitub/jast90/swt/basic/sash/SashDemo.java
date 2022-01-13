package io.gitub.jast90.swt.basic.sash;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.swt.widgets.Shell;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2022/1/13 10:14
 */
public class SashDemo {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Sash Demo");
        shell.setSize(400, 300);
        final Sash sash = new Sash(shell, SWT.BORDER | SWT.VERTICAL);
        Rectangle clientArea = shell.getClientArea();
        sash.setBounds(0, clientArea.y, 20, clientArea.height);
        sash.addListener(SWT.Selection, e -> sash.setBounds(e.x, e.y, e.width, e.height));
        shell.open();
        sash.setFocus();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }
}
