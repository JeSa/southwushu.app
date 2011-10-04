package com.southwushu.app.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class MinEditorInput implements IEditorInput {

	
	 private final Long id;

	    public MinEditorInput(Long id) {
	        this.id = id;
	    }
	    
	    public Long getId() {
	        return id;
	    }

	    @Override
	    public boolean exists() {
	        return true;
	    }

	    @Override
	    public ImageDescriptor getImageDescriptor() {
	        return null;
	    }

	    @Override
	    public String getName() {
	        return String.valueOf(id);
	    }

	    @Override
	    public IPersistableElement getPersistable() {
	        return null;
	    }

	    @Override
	    public String getToolTipText() {
	        return "Displays a person";
	    }

	    @Override
	    public Object getAdapter(Class adapter) {
	        return null;
	    }

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + id.intValue();
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        MinEditorInput other = (MinEditorInput) obj;
	        if (id != other.id)
	            return false;
	        return true;
	    }

}
