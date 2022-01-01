package io.gitub.jast90.swt.basic.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class StackLayoutDemo extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public StackLayoutDemo(Composite parent, int style) {
		super(parent, style);
		setLayout(new StackLayout());
		Button btnButton = new Button(this, SWT.NONE);
		btnButton.setText("button1");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
