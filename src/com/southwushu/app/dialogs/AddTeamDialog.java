package com.southwushu.app.dialogs;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;

import com.southwushu.app.models2.Person;

//import com.southwushu.app.models.Person;

public class AddTeamDialog extends Dialog {

	Person p = null;
	private Label titleLabel;
	private Label cityLabel;
	private Text titleText;
	private Text cityText;
	private String title;
	private String city;

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.getShell().setText("Новая команда");
		try {
			composite.setLayout(new FormLayout());
			{
				GridLayout gl = new GridLayout(2, true);
				composite.setLayout(gl);
				{
					titleLabel = new Label(composite, SWT.NONE);
					titleLabel.setText("Название");
					titleText = new Text(composite, 33572868);

					cityLabel = new Label(composite, SWT.NONE);
					cityLabel.setText("Город");
					cityText = new Text(composite, 33572868);

					// Control bb = super.createButtonBar(composite);
					super.createButtonsForButtonBar(composite);

					// super.createButton(composite, IDialogConstants.OK_ID,
					// "Добавить", false);
					// super.createButton(composite, IDialogConstants.CANCEL_ID,
					// "Отмена", false);

					// View childView = new View();
					// childView.createViewer(composite);

					// createButtonAdd(composite);
					// createButtonCancel(composite);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		composite.getShell().setSize(600, 400);
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

	@Override
	protected void okPressed() {
		String title = getTitleText().getText();
		String city = getCityText().getText();
		if (title != "" & city != "") {
			setTitle(getTitleText().getText());
			setCity(getCityText().getText());
			super.okPressed();
		}
		else
			MessageDialog.openError(getShell(), "Внимание", "Не все необходимые данные были введены.");
	}

	public Text getTitleText() {
		return titleText;
	}

	public Text getCityText() {
		return cityText;
	}

	private void createLabel(Composite composite) {
		Label label = new Label(composite, SWT.None);
		label.setText("Label 1");
		FormData lblData = new FormData();
		lblData.width = 40;
		lblData.height = 20;
		lblData.left = new FormAttachment(0, 1000, 6);// x co-ordinate
		lblData.top = new FormAttachment(0, 1000, 17);// y co-ordinate
		label.setLayoutData(lblData);
	}

	private void createTextField(Composite composite) {
		Text text = new Text(composite, SWT.None);
		text.setText("Some text data");
		FormData txtData = new FormData();
		txtData.width = 100;
		txtData.height = 20;
		txtData.left = new FormAttachment(0, 1000, 50);// x co-ordinate
		txtData.top = new FormAttachment(0, 1000, 17);// y co-ordinate
		text.setLayoutData(txtData);
	}

	private void createButtonCancel(Composite composite) {
		Button btn = new Button(composite, SWT.PUSH);
		btn.setText("Отмена");
		/*
		 * FormData btnData = new FormData(); btnData.width = 90; btnData.height
		 * = 20; btnData.left = new FormAttachment(0, 1000, 100);// x
		 * co-ordinate btnData.top = new FormAttachment(0, 1000, 40);// y
		 * co-ordinate btn.setLayoutData(btnData);
		 */btn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent se) {
				close();
			}
		});
	}

	private void createButtonAdd(Composite composite) {
		Button btn = new Button(composite, SWT.PUSH);
		btn.setText("Добавить");
		/*
		 * FormData btnData = new FormData(); btnData.width = 90; btnData.height
		 * = 20; btnData.left = new FormAttachment(0, 1000, 100);// x
		 * co-ordinate btnData.top = new FormAttachment(0, 1000, 40);// y
		 * co-ordinate btn.setLayoutData(btnData);
		 */btn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent se) {
				// TODO: add new record to DB
				close();
			}
		});
	}

	private void setDialogLocation() {
		Rectangle monitorArea = getShell().getDisplay().getPrimaryMonitor()
				.getBounds();
		Rectangle shellArea = getShell().getBounds();
		int x = monitorArea.x + (monitorArea.width - shellArea.width) / 2;
		int y = monitorArea.y + (monitorArea.height - shellArea.height) / 2;
		getShell().setLocation(x, y);
	}

	// ---------------------------------------------------------------------------------//

	public class View extends ViewPart {
		public static final String ID = "de.vogella.jface.tableviewer.view";

		private TableViewer viewer;

		// We use icons
		/*
		 * private static final Image CHECKED = Activator.getImageDescriptor(
		 * "icons/checked.gif").createImage(); private static final Image
		 * UNCHECKED = Activator.getImageDescriptor(
		 * "icons/unchecked.gif").createImage();
		 */
		public void createPartControl(Composite parent) {
			GridLayout layout = new GridLayout(2, false);
			parent.setLayout(layout);
			Label searchLabel = new Label(parent, SWT.NONE);
			searchLabel.setText("Search: ");
			final Text searchText = new Text(parent, SWT.BORDER | SWT.SEARCH);
			searchText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
					| GridData.HORIZONTAL_ALIGN_FILL));
			createViewer(parent);
		}

		private void createViewer(Composite parent) {
			viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
					| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
			createColumns(parent, viewer);
			final Table table = viewer.getTable();
			table.setHeaderVisible(true);
			table.setLinesVisible(true);

			viewer.setContentProvider(new ArrayContentProvider());
			// Get the content for the viewer, setInput will call getElements in
			// the
			// contentProvider
			viewer.setInput(ModelProvider.INSTANCE.getPersons());
			// Make the selection available to other views
			getSite().setSelectionProvider(viewer);
			// Set the sorter for the table

			// Layout the viewer
			GridData gridData = new GridData();
			gridData.verticalAlignment = GridData.FILL;
			gridData.horizontalSpan = 2;
			gridData.grabExcessHorizontalSpace = true;
			gridData.grabExcessVerticalSpace = true;
			gridData.horizontalAlignment = GridData.FILL;
			viewer.getControl().setLayoutData(gridData);
		}

		public TableViewer getViewer() {
			return viewer;
		}

		// This will create the columns for the table
		private void createColumns(final Composite parent,
				final TableViewer viewer) {
			String[] titles = { "First name", "Last name", "Gender", "Married" };
			int[] bounds = { 100, 100, 100, 100 };

			// First column is for the first name
			TableViewerColumn col = createTableViewerColumn(titles[0],
					bounds[0], 0);
			col.setLabelProvider(new ColumnLabelProvider() {
				@Override
				public String getText(Object element) {
					Person p = (Person) element;
					return p.getFirstName();
				}
			});

			// Second column is for the last name
			col = createTableViewerColumn(titles[1], bounds[1], 1);
			col.setLabelProvider(new ColumnLabelProvider() {
				@Override
				public String getText(Object element) {
					Person p = (Person) element;
					return p.getLastName();
				}
			});

			// Now the gender
			col = createTableViewerColumn(titles[2], bounds[2], 2);
			col.setLabelProvider(new ColumnLabelProvider() {
				@Override
				public String getText(Object element) {
					Person p = (Person) element;
					return p.getGender();
				}
			});

			// // Now the status married
			col = createTableViewerColumn(titles[3], bounds[3], 3);
			col.setLabelProvider(new ColumnLabelProvider() {
				@Override
				public String getText(Object element) {
					return null;
				}

				/*
				 * @Override public Image getImage(Object element) { if
				 * (((Person) element).isMarried()) { return CHECKED; } else {
				 * return UNCHECKED; } }
				 */
			});

		}

		private TableViewerColumn createTableViewerColumn(String title,
				int bound, final int colNumber) {
			final TableViewerColumn viewerColumn = new TableViewerColumn(
					viewer, SWT.NONE);
			final TableColumn column = viewerColumn.getColumn();
			column.setText(title);
			column.setWidth(bound);
			column.setResizable(true);
			column.setMoveable(true);
			return viewerColumn;

		}

		/**
		 * Passing the focus request to the viewer's control.
		 */

		public void setFocus() {
			viewer.getControl().setFocus();
		}
	}
}
