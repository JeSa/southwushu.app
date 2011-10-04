package com.southwushu.app.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class AddTeamDialog extends Dialog{

	public AddTeamDialog(Shell parentShell) {
		super(parentShell);
		parentShell.setText("команда");
	}
	
}
