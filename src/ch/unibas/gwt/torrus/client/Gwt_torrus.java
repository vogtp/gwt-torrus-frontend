package ch.unibas.gwt.torrus.client;

import ch.unibas.gwt.torrus.client.view.imageoverview.ImageOverview;
import ch.unibas.gwt.torrus.client.view.serverchooser.ServerChooserPopupPanel;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt_torrus implements EntryPoint {

	private static final String PAGE_IMAGE_GRID = "PAGE_IMAGE_GRID";
	private static final String PAGE_SERVERS = "PAGE_SERVERS";

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		if (History.getToken().isEmpty()) {
			History.newItem(PAGE_IMAGE_GRID);
		}

		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		String currentPage = History.getToken();
		if (PAGE_IMAGE_GRID.equals(currentPage)) {
			rootPanel.clear();
			rootPanel.add(new ImageOverview());
		} else if (PAGE_SERVERS.equals(currentPage)) {
			rootPanel.clear();
			rootPanel.add(new ServerChooserPopupPanel());
		}

	}

}
