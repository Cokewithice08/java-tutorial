package io.gitub.jast90.swt.component.base;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class AbstractTest {
    private String title;

    public AbstractTest(String title) {
        this.title = title;
        init();
    }

    private void init(){
        Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setText (this.title);
        shell.setLayout(new RowLayout());
        addComponent(shell);
        shell.setSize(new Point(800,800));
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    protected abstract void addComponent(Shell shell);

}
