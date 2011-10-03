package com.southwushu.app.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class PersonFigure extends Figure {
	private XYLayout layout;
	private Label title = new Label();
	
	public PersonFigure() {
		layout = new XYLayout();
		setLayoutManager(layout);
		title.setForegroundColor(ColorConstants.blue);
		add(title);
		setConstraint(title, new Rectangle(5, 5, -1, -1));
		
		setBorder(new LineBorder(5));
	}
	
	public void setTitle(String value) {
		title.setText(value);
	}
	
}
