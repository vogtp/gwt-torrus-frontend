package ch.unibas.gwt.torrus.client.view.imageoverview;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;

public class ImageOverview extends Composite {

	private static ImageOverviewUiBinder uiBinder = GWT
			.create(ImageOverviewUiBinder.class);

	interface ImageOverviewUiBinder extends UiBinder<Widget, ImageOverview> {
	}

	public ImageOverview() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
