package com.southwushu.app.handlers;

import com.southwushu.app.models.Person;
import com.southwushu.app.models.Team;
import com.southwushu.app.persistence.PersistenceManager;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.southwushu.app.dialogs.AddPersonDialog;

public class CreatePersonHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		AddPersonDialog addPerson = new AddPersonDialog(window.getShell());
		int code = addPerson.open();

		if (code == 0) { // button 'Ok'
			Team team3 = new Team();
			team3.setName("Пока Новая Команда"); // TODO: choose the team
			PersistenceManager.save(team3);

			Person p = new Person();
			p.setFirstName(addPerson.getFirstName());
			p.setLastName(addPerson.getLastName());
			p.setMiddleName(addPerson.getMiddleName());
			p.setTeam(team3);
			
			PersistenceManager.save(p);
		}

		return null;
	}

}
