package com.southwushu.app.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.southwushu.app.dialogs.AddPersonDialog;
import com.southwushu.app.dialogs.AddTeamDialog;
import com.southwushu.app.models.Person;
import com.southwushu.app.models.Team;
import com.southwushu.app.persistence.PersistenceManager;

public class CreateTeamHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		AddTeamDialog addTeam = new AddTeamDialog(window.getShell());
		int code = addTeam.open();
		
		if (code == 0) {
			Team t = new Team();
			t.setName(addTeam.getTitle());
			t.setCity(addTeam.getCity());

			PersistenceManager.save(t);
			
			Person p = new Person();
			p.setFirstName("Фамилия");
			p.setLastName("Имя");
			p.setMiddleName("Отчество");
			p.setTeam(t);
			
			PersistenceManager.save(p);
		}
		return null;
	}

}
