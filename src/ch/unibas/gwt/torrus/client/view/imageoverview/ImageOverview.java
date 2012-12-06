package ch.unibas.gwt.torrus.client.view.imageoverview;

import java.util.ArrayList;

import ch.unibas.gwt.torrus.client.config.ConfigHandler;
import ch.unibas.gwt.torrus.client.widget.TorrusImage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class ImageOverview extends Composite {

	ArrayList<TorrusImage> images;
	private ArrayList<String> servers;
	private ArrayList<String> values;
	Grid gridImages;

	private static ImageOverviewUiBinder uiBinder = GWT
			.create(ImageOverviewUiBinder.class);
	@UiField
	ListBox lbView;
	@UiField
	IntegerBox ibZoom;
	@UiField
	ListBox lbDataset;
	@UiField SimplePanel gridPanel;

	interface ImageOverviewUiBinder extends UiBinder<Widget, ImageOverview> {
	}

	public ImageOverview() {
		initWidget(uiBinder.createAndBindUi(this));
		images = new ArrayList<TorrusImage>();
		String configName = Window.Location.getParameter("dataset");
		updateConfig(configName);
		// lbView.addItem("last24h");
		// lbView.addItem("lastweek");
		// lbView.addItem("lastmonth");
		// lbView.addItem("lastyear");
		ibZoom.setValue(50);
		ConfigHandler.setSetAvailableConfigs(lbDataset);
		// updateGrid();
	}

	@UiHandler("lbView")
	void onLbViewChange(ChangeEvent event) {
		int selectedIndex = lbView.getSelectedIndex();
		if (selectedIndex > -1) {
			String v = lbView.getValue(selectedIndex);
			for (TorrusImage img : images) {
				img.setView(v);
			}
		}

	}

	@UiHandler("ibZoom")
	void onIbZoomChange(ChangeEvent event) {
		Integer percent = ibZoom.getValue();
		float p = percent / 100f;
		for (TorrusImage img : images) {
			img.scaleImages(p);
		}
	}

	@UiHandler("lbDataset")
	void onLbDatasetChange(ChangeEvent event) {
		int selectedIndex = lbDataset.getSelectedIndex();
		if (selectedIndex > -1) {
			String ds = lbDataset.getValue(selectedIndex);
			updateConfig(ds);
			updateGrid();
		}
	}

	private void updateConfig(String name) {
		ConfigHandler config = ConfigHandler.getConfig(name);
		servers = config.getServers();
		values = config.getValues();
	}

	void updateGrid() {
		if (gridImages != null) {
			gridImages.clear(true);
		}
		gridImages = new Grid(servers.size() + 1, values.size() + 1);
		gridImages.setText(0, 0, "server name");
		for (int i = 0; i < values.size(); i++) {
			String value = values.get(i);
			gridImages.setWidget(0, i + 1, new TitleWidget(this, value, values,
					value));
			// grid.setText(0, i + 1, value);
		}

		for (int i = 0; i < servers.size(); i++) {
			String serverName = servers.get(i);
			String shortServerName = serverName.substring(0,
					serverName.indexOf("."));
			gridImages.setWidget(i + 1, 0, new TitleWidget(this,
					shortServerName, serverName, servers, serverName));
			for (int j = 0; j < values.size(); j++) {
				gridImages.setWidget(i + 1, j + 1,
						getImage(serverName, values.get(j)));
			}
		}
		gridPanel.clear();
		gridPanel.add(gridImages);
	}

	private Widget getImage(String serverName, String value) {
		TorrusImage image = new TorrusImage(serverName, value, "last24h");

		image.scaleImages(.5f);
		images.add(image);
		return image;
	}

	@UiHandler("gridPanel")
	void onGridImagesAttachOrDetach(AttachEvent event) {
		if (event.isAttached()) {
			updateGrid();
		}
	}

	@UiHandler("lbView")
	void onLbViewAttachOrDetach(AttachEvent event) {
		if (event.isAttached()) {
			lbView.addItem("last24h");
			lbView.addItem("lastweek");
			lbView.addItem("lastmonth");
			lbView.addItem("lastyear");
		}
	}
}
