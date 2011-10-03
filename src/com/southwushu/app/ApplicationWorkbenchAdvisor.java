package com.southwushu.app;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.southwushu.app.editors.ProtocolEditorInput;
import com.southwushu.app.editors.ProtocolGraphicalEditor;
import com.southwushu.app.perspectives.PersonPerspective;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }

	public String getInitialWindowPerspectiveId() {
		return PersonPerspective.ID;
	}
	
	@Override
	public void postStartup() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		try {
			page.openEditor(new ProtocolEditorInput(1l, "Первое соревнование"), ProtocolGraphicalEditor.ID);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		super.postStartup();
	}
}
