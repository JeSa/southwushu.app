package com.southwushu.app.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;

import com.southwushu.app.models.Person;

public class AddTeamDialog extends Dialog {

	Person p = null;
	private Label titleLabel;
	private Label cityLabel;
	private Text titleText;
	private Text cityText;
	private String title;
	private String city;
	private View childView;

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.getShell().setText("Новая команда");

		childView = new View();

		try {
			FormLayout mainLayout = new FormLayout();
			// composite.getShell().setLayout(mainLayout);
			composite.setLayout(mainLayout);

			titleLabel = new Label(composite, SWT.NONE);
			titleLabel.setText("Название");
			FormData titleLabelData = new FormData();
			titleLabelData.top = new FormAttachment(0, 15);
			titleLabelData.left = new FormAttachment(0, 15);
			titleLabel.setLayoutData(titleLabelData);

			titleText = new Text(composite, 33572868);
			FormData titleTextData = new FormData();
			titleTextData.top = new FormAttachment(0, 15);
			titleTextData.left = new FormAttachment(titleLabel, 15);
			titleTextData.right = new FormAttachment(100, -15);
			titleText.setLayoutData(titleTextData);

			cityLabel = new Label(composite, SWT.NONE);
			cityLabel.setText("Город");
			FormData cityLabelData = new FormData();
			cityLabelData.top = new FormAttachment(titleLabel, 15);
			cityLabelData.left = new FormAttachment(0, 15);
			cityLabel.setLayoutData(cityLabelData);

			cityText = new Text(composite, 33572868);
			FormData cityTextData = new FormData();
			cityTextData.top = new FormAttachment(titleText, 5);
			cityTextData.left = new FormAttachment(titleLabel, 15);
			cityTextData.right = new FormAttachment(100, -15);
			cityText.setLayoutData(cityTextData);

			
			Composite viewerHolder = new Composite(composite, SWT.NONE);
			GridLayout viewerHolderLayout = new GridLayout();
			viewerHolderLayout.numColumns = 1;
			viewerHolder.setLayout(viewerHolderLayout);
			
			FormData viewerHolderData = new FormData();
			viewerHolderData.top = new FormAttachment(cityLabel, 15);
			viewerHolderData.left = new FormAttachment(0, 15);
			viewerHolder.setLayoutData(viewerHolderData);
			viewerHolder.pack();
			
			childView.createViewer(viewerHolder);

			
			Composite buttonBar = new Composite(composite, SWT.NONE);
			GridLayout buttonBarLayout = new GridLayout();
			buttonBarLayout.numColumns = 1;
			buttonBar.setLayout(buttonBarLayout);
			
			FormData buttonBarData = new FormData();
			buttonBarData.bottom = new FormAttachment(100, -15);
			buttonBarData.left = new FormAttachment(30, (int) -buttonBar.getBounds().width/2); // FIX: offset doesn't work 
			buttonBar.setLayoutData(buttonBarData);
			buttonBar.pack();
			
			super.createButtonsForButtonBar(buttonBar);

			composite.pack();

		} catch (Exception e) {
			e.printStackTrace();
		}
		composite.getShell().setSize(500, 700);
		setDialogLocation();
		return composite;
	}

	public AddTeamDialog(Shell parentShell) {
		super(parentShell);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Text getTitleText() {
		return titleText;
	}
	
	public Text getCityText() {
		return cityText;
	}

	@Override
	protected void okPressed() {
		String title = getTitleText().getText();
		String city = getCityText().getText();
		if (title != "" & city != "") {
			setTitle(getTitleText().getText());
			setCity(getCityText().getText());
			super.okPressed();
		} else
			MessageDialog.openError(getShell(), "Внимание",
					"Не все необходимые данные были введены.");
	}


	private void setDialogLocation() {
		Rectangle monitorArea = getShell().getDisplay().getPrimaryMonitor()
				.getBounds();
		Rectangle shellArea = getShell().getBounds();
		int x = monitorArea.x + (monitorArea.width - shellArea.width) / 2;
		int y = monitorArea.y + (monitorArea.height - shellArea.height) / 2;
		getShell().setLocation(x, y);
	}


	
	
	private class View extends ViewPart {
		
		private TableViewer viewer;

		public void createPartControl(Composite parent) {
			GridLayout layout = new GridLayout(2, false);
			parent.setLayout(layout);
			createViewer(parent);
		}

		private void createViewer(Composite parent) {
			viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
					| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
			
			createColumns(parent, viewer);
			
			final Table table = viewer.getTable();
			table.setHeaderVisible(true);
			table.setLinesVisible(true);

			//viewer.setContentProvider(new ArrayContentProvider());
			//viewer.setInput(ModelProvider.INSTANCE.getPersons());
			
			//getSite().setSelectionProvider(viewer);

			GridData gridData = new GridData();
			gridData.horizontalAlignment = GridData.FILL;
			gridData.verticalAlignment = GridData.FILL;
			gridData.horizontalSpan = 2;
			gridData.grabExcessHorizontalSpace = true;
			gridData.grabExcessVerticalSpace = true;
			viewer.getControl().setLayoutData(gridData);
		}

		private void createColumns(final Composite parent,
				final TableViewer viewer) {
			String[] titles = {"First name", "Last name"};
			int[] bounds = {200, 200};

			TableViewerColumn col = null;
			
			col = createTableViewerColumn(titles[0], bounds[0], 0);
			col.setLabelProvider(new ColumnLabelProvider() {
				@Override
				public String getText(Object element) {
					Person p = (Person) element;
					return p.getFirstName();
				}
			});

			col = createTableViewerColumn(titles[1], bounds[1], 1);
			col.setLabelProvider(new ColumnLabelProvider() {
				@Override
				public String getText(Object element) {
					Person p = (Person) element;
					return p.toString();
				}
			});
		}

		private TableViewerColumn createTableViewerColumn(String title,
				int bound, final int colNumber) {
			
			final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
			final TableColumn column = viewerColumn.getColumn();
			
			column.setText(title);
			column.setWidth(bound);
			column.setResizable(true);
			column.setMoveable(true);
			return viewerColumn;
		}

		public void setFocus() {
			viewer.getControl().setFocus();
		}
	}
}
