package com.southwushu.app.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class ProtocolEditorInput implements IEditorInput {

	private Long competition_id;
	private String competition_name;
	
	public ProtocolEditorInput(Long id, String name) {
		this.competition_id = id;
		this.competition_name = name;
	}
	

	@Override
	public boolean exists() {
		return (this.competition_id != null);
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return ImageDescriptor.getMissingImageDescriptor();
	}

	@Override
	public String getName() {
		return competition_name;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ProtocolEditorInput))
			return false;
		return ((ProtocolEditorInput)obj).getName().equals(getName());
	}
	
	@Override
	public String getToolTipText() {
		return this.competition_name;
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}
}
