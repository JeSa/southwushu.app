package com.southwushu.app.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.southwushu.app.figures.PersonFigure;
import com.southwushu.app.models.Person;

public class PersonEditPart extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		return new PersonFigure();
	}

	@Override
	protected void refreshVisuals() {
		PersonFigure figure = (PersonFigure)getFigure();
		Person model = (Person)getModel();
		figure.setTitle(model.getFirstName() + " " + model.getLastName());

	}
	
	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		
	}

}
