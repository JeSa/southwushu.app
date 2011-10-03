package com.southwushu.app.adapters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;

import com.southwushu.app.persistence.PersistenceManager;
import com.southwushu.app.models.Team;
import com.southwushu.app.models.Person;
import com.southwushu.app.models.Federation;;

public class AdapterFactory implements IAdapterFactory {

	private IWorkbenchAdapter federationAdapter = new IWorkbenchAdapter() {
		public Object getParent(Object o) {
			return null;
		}
		public String getLabel(Object o) {
			return null;
		}
		public ImageDescriptor getImageDescriptor(Object object) {
			// to be filled in soon!
			return null;
		}
		public Object[] getChildren(Object o) {
			return ((Federation)o).getTeams().toArray();
		}
	};
	
	private IWorkbenchAdapter teamAdapter = new IWorkbenchAdapter() {
		public Object getParent(Object o) {
			return Federation.getInstance();
		}
		public String getLabel(Object o) {
			return ((Team)o).getName();
		}
		public ImageDescriptor getImageDescriptor(Object object) {
			// to be filled in soon!
			return null;
		}
		public Object[] getChildren(Object o) {
			return PersistenceManager.execNamedQuery(Person.GET_COACH_BY_TEAM,o).toArray();
		}
	};
	
	private IWorkbenchAdapter studentAdapter = new IWorkbenchAdapter() {
		public Object getParent(Object o) {
			return null;
		}
		public String getLabel(Object o) {
			return ((Person)o).getFirstName();
		}
		public ImageDescriptor getImageDescriptor(Object object) {
			// to be filled in soon!
			return null;
		}
		public Object[] getChildren(Object o) {
			return ((Person)o).getStudents().toArray();
		}
	};

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		
		if(adapterType == IWorkbenchAdapter.class &&
				adaptableObject instanceof Federation)
			return federationAdapter;
		
		if(adapterType == IWorkbenchAdapter.class &&
			adaptableObject instanceof Team)
		return teamAdapter;
		
		if(adapterType == IWorkbenchAdapter.class &&
			adaptableObject instanceof Person)
		return studentAdapter;

		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[] {IWorkbenchAdapter.class};
	}

}
