package com.southwushu.app.perspectives;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.southwushu.app.views.PersonExplorerView;

public class PersonPerspective implements IPerspectiveFactory {

	public final static String ID = "com.southwushu.app.perspectives.personperspective";
	
	@Override
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		layout.addView(PersonExplorerView.ID, IPageLayout.LEFT, 0.5f, layout.getEditorArea());
	}

}
