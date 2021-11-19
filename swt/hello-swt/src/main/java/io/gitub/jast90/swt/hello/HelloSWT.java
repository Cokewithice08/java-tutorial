package io.gitub.jast90.swt.hello;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelloSWT {
    public static void main (String [] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Hello SWT");
        shell.open ();
        while (!shell.isDisposed ()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }
        display.dispose ();
    }
}
