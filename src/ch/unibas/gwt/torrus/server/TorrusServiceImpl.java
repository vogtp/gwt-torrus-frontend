package ch.unibas.gwt.torrus.server;

import ch.unibas.gwt.torrus.client.service.TorrusService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class TorrusServiceImpl extends RemoteServiceServlet implements
		TorrusService {

	private ITorrusParser torrusParser;
	
	public TorrusServiceImpl() {
		super();
		// torrusParser = new TorrusConfigParser(TORRUS_HOME);
		torrusParser = new TorrusDummyParser();
	}


	@Override
	public String[] getNodes() {
		try {
			return torrusParser.getAvailableNodes();
		} catch (Exception e) {
			e.printStackTrace(); // FIXME do proper handling
			return new String[0];
		}
	}


}
