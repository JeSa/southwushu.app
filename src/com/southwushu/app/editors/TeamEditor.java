package com.southwushu.app.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import com.southwushu.app.models.Person;
import com.southwushu.app.models.Team;
import com.southwushu.app.persistence.PersistenceManager;

public class TeamEditor extends EditorPart {

	public static final String ID = "com.southwushu.app.editors.teameditor";
	private Team team;
	private MinEditorInput input;
	
	public TeamEditor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		if (!(input instanceof MinEditorInput)) {
			throw new RuntimeException("Wrong input");
		}

		this.input = (MinEditorInput) input;
		setSite(site);
		setInput(input);
		team = (Team) PersistenceManager.execSingleNQuery(Team.GET_BY_ID, this.input.getId());
		setPartName("Team ID: " + team.getId());


	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		parent.setLayout(layout);
		Label label1 = new Label(parent, SWT.NONE);
		label1.setText("First Name");
		Text text = new Text(parent, SWT.BORDER);
		text.setText(team.getName());
		text.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
