package com.southwushu.app.views;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.ViewPart;

import com.southwushu.app.adapters.AdapterFactory;
import com.southwushu.app.models.Federation;
import com.southwushu.app.models.Person;
import com.southwushu.app.models.Team;
import com.southwushu.app.persistence.PersistenceManager;

public class PersonExplorerView extends ViewPart {

	public final static String ID = "com.southwushu.app.views.personexplorerview";
	
	public TreeViewer treeViewer;
	private AdapterFactory adapterFactory = new AdapterFactory();
	
	public PersonExplorerView() {
		Platform.getAdapterManager().registerAdapters(adapterFactory, Federation.class);
		Platform.getAdapterManager().registerAdapters(adapterFactory, Team.class);
		Platform.getAdapterManager().registerAdapters(adapterFactory, Person.class);
		//setUpDatabase();
	}

	@Override
	public void createPartControl(Composite parent) {
		treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		getSite().setSelectionProvider(treeViewer);
		treeViewer.setLabelProvider(new WorkbenchLabelProvider());
		treeViewer.setContentProvider(new BaseWorkbenchContentProvider());
		treeViewer.setInput(Federation.getInstance());
		attachCommands();
		
		MenuManager menuManager = new MenuManager ();
		Menu menu = menuManager.createContextMenu (treeViewer.getControl());
		treeViewer.getControl().setMenu (menu);
		getSite ().registerContextMenu (menuManager, treeViewer);
	}

	private void attachCommands() {
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
				try {
					ISelection selection = getSite().getSelectionProvider().getSelection();
					if (selection != null && selection instanceof IStructuredSelection) {
						Object obj = ((IStructuredSelection) selection).getFirstElement();
						if (obj instanceof Person)
							handlerService.executeCommand("com.southwushu.app.commands.editperson", null);
						else
							handlerService.executeCommand("com.southwushu.app.commands.editteam", null);
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					//throw new RuntimeException("Editor not found");
				}
			}
		});
	}

	
	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}
	
	@Override
	public void dispose() {
		Platform.getAdapterManager().unregisterAdapters(adapterFactory);
		super.dispose();
	}
	
	private void setUpDatabase(){
		Team team1 = new Team();
		team1.setName("Лабинская команда");
		PersistenceManager.save(team1);
		
		Team team2 = new Team();
		team2.setName("Новороссийская команда");
		PersistenceManager.save(team2);
		
		Person coach_1 = new Person();
		coach_1.setFirstName("Гарий");
		coach_1.setLastName("Асатрян");
		coach_1.setTeam(team1);
		PersistenceManager.save(coach_1);
		
	}

}
