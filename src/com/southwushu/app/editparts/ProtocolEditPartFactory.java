package com.southwushu.app.editparts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.southwushu.app.models.Person;

public class ProtocolEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		AbstractGraphicalEditPart part = null;
		
		if (model instanceof Person) {
			part = new PersonEditPart();
		}
		
		part.setModel(model);
		return part;
	}

}
