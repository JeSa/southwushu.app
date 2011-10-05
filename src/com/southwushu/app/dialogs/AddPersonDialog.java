package com.southwushu.app.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class AddPersonDialog extends FormDialog{

	private FormToolkit toolkit;
	
	private Text firstName;
	private Text lastName;
	private Text middleName;
	
	public AddPersonDialog(Shell parentShell) {
		super(parentShell);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		toolkit = new FormToolkit(parent.getDisplay());
		Form sform = toolkit.createForm(parent);
		sform.setLayoutData(new GridData(GridData.FILL_BOTH));
		ManagedForm mform = new ManagedForm(parent);
		createFormContent(mform);
		applyDialogFont(sform.getBody());
		return sform;
	}
	
	@Override
	protected void createFormContent(IManagedForm mform) {
		FormToolkit toolkit = mform.getToolkit();
		ScrolledForm form = mform.getForm();
		form.setText("Hello, Eclipse Forms");
		//toolkit.decorateFormHeading(form);
	}
	
	@Override
	protected void okPressed() {
		if (lastName.getText().equals("")) {
			MessageDialog.openError(getShell(), "Р’РЅРёРјР°РЅРёРµ",
					"Р¤Р°РјРёР»РёСЏ РґРѕР»Р¶РЅР° Р±С‹С‚СЊ Р·Р°РїРѕР»РЅРµРЅР°");
			return;
		}
		if (firstName.equals("")) {
			MessageDialog.openError(getShell(), "Р’РЅРёРјР°РЅРёРµ",
					"Р�РјСЏ РґРѕР»Р¶РЅРѕ Р±С‹С‚СЊ Р·Р°РїРѕР»РЅРµРЅРЅРѕ");
			return;
		}

		super.okPressed();
	}
}
