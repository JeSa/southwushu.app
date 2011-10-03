package com.southwushu.app.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class AddPersonDialog extends Dialog{

	private Text firstName;
	private Text lastName;
	private Text middleName;
	
	public AddPersonDialog(Shell parentShell) {
		super(parentShell);
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Создание ученика");
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);

		Label label = new Label(composite, SWT.NONE);
		label.setText("Фамилия:");
		label.setLayoutData(new GridData(GridData.END, GridData.CENTER,	false, false));

		lastName = new Text(composite, SWT.BORDER);
		lastName.setLayoutData(new GridData(GridData.FILL, GridData.FILL,	true, false));

		label = new Label(composite, SWT.NONE);
		label.setText("Имя:");
		label.setLayoutData(new GridData(GridData.END, GridData.CENTER,	false, false));

		firstName = new Text(composite, SWT.BORDER);
		firstName.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));

		label = new Label(composite, SWT.NONE);
		label.setText("Отчество:");
		label.setLayoutData(new GridData(GridData.END, GridData.CENTER,	false, false));

		middleName = new Text(composite, SWT.BORDER);
		middleName.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
		return composite;
	}

	@Override
	protected void okPressed() {
		if (lastName.getText().equals("")) {
			MessageDialog.openError(getShell(), "Внимание",
					"Фамилия должна быть заполнена");
			return;
		}
		if (firstName.equals("")) {
			MessageDialog.openError(getShell(), "Внимание",
					"Имя должно быть заполненно");
			return;
		}

		super.okPressed();
	}
}
