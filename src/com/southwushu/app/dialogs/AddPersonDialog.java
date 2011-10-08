package com.southwushu.app.dialogs;

import java.awt.Button;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
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

public class AddPersonDialog extends FormDialog {

	private FormToolkit toolkit;

	private Text firstNameText;
	private Text lastNameText;
	private Text middleNameText;
	private Text birthdateText;
	
	private String firstName;
	private String lastName;
	private String middleName;
	private String birthday;

	private Composite isCoachArea;

	private org.eclipse.swt.widgets.Button isCoach;

	private org.eclipse.swt.widgets.Button isChild;
	

	public AddPersonDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		toolkit = new FormToolkit(parent.getDisplay());
		Form sform = toolkit.createForm(parent);
		sform.setBounds(100, 100, 500, 1000);
		//sform.setLayoutData(new GridData(GridData.FILL_BOTH));
		ManagedForm mform = new ManagedForm(parent);
		createFormContent(mform);
		applyDialogFont(sform.getBody());
		return sform;
	}

	@Override
	protected void createFormContent(IManagedForm mform) {

		FormToolkit toolkit = mform.getToolkit();
		ScrolledForm form = mform.getForm();
		form.setBounds(0, 0, 500, 1000);
		form.getBody().setBounds(0, 0, 500, 1000);
		form.setBackground(new Color(null, new RGB(222, 111, 111)));
		form.setLocation(800, 800);
		
		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		gl.horizontalSpacing = 10;
		gl.verticalSpacing = 10;
		gl.makeColumnsEqualWidth = true;
		form.getBody().setLayout(gl);
		
		toolkit.createLabel(form.getBody(), "Фамилия");
		firstNameText = new Text(form.getBody(), 33572868);
 		firstNameText.setToolTipText("First Name");
		toolkit.createLabel(form.getBody(), "Имя");
		lastNameText = new Text(form.getBody(), 33572868);
		lastNameText.setToolTipText("Last Name");
		toolkit.createLabel(form.getBody(), "Отчество");
		middleNameText = new Text(form.getBody(), 33572868);
		middleNameText.setToolTipText("Middle Name");
		toolkit.createLabel(form.getBody(), "Дата рождения");
		birthdateText = new Text(form.getBody(), 33572868);
		
		isCoachArea = toolkit.createComposite(form.getBody());
		isCoach = toolkit.createButton(isCoachArea.getShell(), "Тренер", SWT.RADIO);
		isChild = toolkit.createButton(isCoachArea.getShell(), "Спортсмен", SWT.RADIO);
		isCoachArea.setLayout(gl);
		
	}

	@Override
	protected void okPressed() {
		if (lastNameText.getText().equals("")) {
			MessageDialog.openError(getShell(), "Р’РЅРёРјР°РЅРёРµ",
					"Р¤Р°РјРёР»РёСЏ РґРѕР»Р¶РЅР° Р±С‹С‚СЊ Р·Р°РїРѕР»РЅРµРЅР°");
			return;
		}
		if (firstNameText.equals("")) {
			MessageDialog.openError(getShell(), "Р’РЅРёРјР°РЅРёРµ",
					"Р�РјСЏ РґРѕР»Р¶РЅРѕ Р±С‹С‚СЊ Р·Р°РїРѕР»РЅРµРЅРЅРѕ");
			return;
		}
		
		firstName = firstNameText.getText();
		super.okPressed();
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

}
