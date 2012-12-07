package ch.unibas.gwt.torrus.client;

import ch.unibas.gwt.torrus.client.view.imageoverview.ImageOverview;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt_torrus implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		rootPanel.add(new ImageOverview());

	}

}
