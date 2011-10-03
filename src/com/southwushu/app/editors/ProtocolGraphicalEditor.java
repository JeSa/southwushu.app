package com.southwushu.app.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.parts.GraphicalEditor;

import com.southwushu.app.editparts.ProtocolEditPartFactory;
import com.southwushu.app.models.Person;

public class ProtocolGraphicalEditor extends GraphicalEditor {

	public static final String ID = "com.southwushu.app.editors.protocolgraphicaleditor";
	
	public ProtocolGraphicalEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}
	
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new ProtocolEditPartFactory());
	}
	
	@Override
	protected void initializeGraphicalViewer() {
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(createStub());

	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	private Person createStub() {
		Person person = new Person();
		
		person.setFirstName("Иван");
		person.setLastName("Иванов");
		person.setMiddleName("Иванович");
		
		return person;
	}
}
