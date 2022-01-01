package io.gitub.jast90.swt.basic.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class FormLayoutDemo extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public FormLayoutDemo(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		
		Button btnNewButton = new Button(this, SWT.NONE);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(0, 10);
		fd_btnNewButton.left = new FormAttachment(0, 10);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("New Button");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		FormData fd_btnNewButton_1 = new FormData();
		fd_btnNewButton_1.top = new FormAttachment(btnNewButton, 0, SWT.TOP);
		fd_btnNewButton_1.left = new FormAttachment(btnNewButton, 6);
		btnNewButton_1.setLayoutData(fd_btnNewButton_1);
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_2 = new Button(this, SWT.NONE);
		FormData fd_btnNewButton_2 = new FormData();
		fd_btnNewButton_2.bottom = new FormAttachment(btnNewButton, 0, SWT.BOTTOM);
		fd_btnNewButton_2.left = new FormAttachment(btnNewButton_1, 6);
		btnNewButton_2.setLayoutData(fd_btnNewButton_2);
		btnNewButton_2.setText("New Button");
		
		Button btnNewButton_3 = new Button(this, SWT.NONE);
		FormData fd_btnNewButton_3 = new FormData();
		fd_btnNewButton_3.bottom = new FormAttachment(btnNewButton, 0, SWT.BOTTOM);
		fd_btnNewButton_3.left = new FormAttachment(btnNewButton_2, 26);
		btnNewButton_3.setLayoutData(fd_btnNewButton_3);
		btnNewButton_3.setText("New Button");
		
		Button btnNewButton_4 = new Button(this, SWT.NONE);
		FormData fd_btnNewButton_4 = new FormData();
		fd_btnNewButton_4.bottom = new FormAttachment(100, -222);
		fd_btnNewButton_4.top = new FormAttachment(100, -249);
		fd_btnNewButton_4.right = new FormAttachment(btnNewButton, 336, SWT.RIGHT);
		fd_btnNewButton_4.left = new FormAttachment(0, 10);
		btnNewButton_4.setLayoutData(fd_btnNewButton_4);
		btnNewButton_4.setText("New Button");
		
		Button button = new Button(this, SWT.NONE);
		FormData fd_button = new FormData();
		fd_button.top = new FormAttachment(btnNewButton_4, 46);
		fd_button.left = new FormAttachment(0, 44);
		button.setLayoutData(fd_button);
		button.setText("New Button");
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
