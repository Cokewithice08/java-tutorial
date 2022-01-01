package io.gitub.jast90.swt.basic.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class AbsoluteLayoutDemo extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public AbsoluteLayoutDemo(Composite parent, int style) {
		super(parent, style);
		setLayout(null);
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(5, 5, 435, 27);
		btnNewButton.setText("New Button");
		
		Button btnNewButton_4 = new Button(this, SWT.NONE);
		btnNewButton_4.setBounds(5, 37, 94, 27);
		btnNewButton_4.setText("New Button");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setBounds(105, 38, 94, 27);
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_2 = new Button(this, SWT.NONE);
		btnNewButton_2.setBounds(5, 70, 94, 27);
		btnNewButton_2.setText("New Button");
	
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
