package ch.unibas.gwt.torrus.client.service;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The client side stub for the RPC service.
 */
public interface TorrusServiceAsync {
	
	public void getNodes(AsyncCallback<String[]> callback) ;
}
