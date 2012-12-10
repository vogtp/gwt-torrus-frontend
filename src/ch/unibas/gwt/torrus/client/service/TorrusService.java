package ch.unibas.gwt.torrus.client.service;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("torrusService")
public interface TorrusService extends RemoteService {
	
	public static class Util {
		
		private static TorrusServiceAsync instance;

		public static TorrusServiceAsync getInstance() {
			if (instance == null) {
				instance = GWT.create(TorrusService.class);
			}
			return instance;
		}
		
	}
	
	public String[] getNodes() throws Exception;
}
