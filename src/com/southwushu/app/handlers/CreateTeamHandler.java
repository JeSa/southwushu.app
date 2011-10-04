package com.southwushu.app.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.southwushu.app.dialogs.AddPersonDialog;
import com.southwushu.app.dialogs.AddTeamDialog;

public class CreateTeamHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		AddTeamDialog addTeam = new AddTeamDialog(window.getShell());
		int code = addTeam.open();

		return null;
	}

	

}
