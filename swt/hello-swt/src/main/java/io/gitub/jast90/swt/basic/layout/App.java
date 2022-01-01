package io.gitub.jast90.swt.basic.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class App {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

//		AbsoluteLayoutDemo hello = new AbsoluteLayoutDemo(shell,SWT.BORDER);
//		FillLayoutDemo hello = new FillLayoutDemo(shell,SWT.BORDER);
//		FormLayoutDemo hello = new FormLayoutDemo(shell,SWT.BORDER);
		GridLayoutDemo hello = new GridLayoutDemo(shell,SWT.BORDER);
//		RowLayoutDemo hello = new RowLayoutDemo(shell,SWT.BORDER);
//		StackLayoutDemo hello = new StackLayoutDemo(shell,SWT.BORDER);
		hello.setSize(800,800);
//		hello.pack();
		shell.setSize(800, 800);
//		shell.pack();
		shell.open();
//		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
