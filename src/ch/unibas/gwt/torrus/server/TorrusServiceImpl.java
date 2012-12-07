package ch.unibas.gwt.torrus.server;

import java.io.File;

import ch.unibas.gwt.torrus.client.service.TorrusService;
import ch.unibas.gwt.torrus.server.parser.ITorrusParser;
import ch.unibas.gwt.torrus.server.parser.TorrusConfigParser;
import ch.unibas.gwt.torrus.server.parser.TorrusDummyParser;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class TorrusServiceImpl extends RemoteServiceServlet implements
		TorrusService {

	private static final String TORRUS_HOME = "/opt/pm/";
	private static final String TORRUS_HOME_WINDOWS = "c:/torrus/pm/";

	private ITorrusParser torrusParser;

	public TorrusServiceImpl() {
		super();
		if (new File(TORRUS_HOME).exists()) {
			torrusParser = new TorrusConfigParser(TORRUS_HOME);
		} else if (new File(TORRUS_HOME_WINDOWS).exists()) {
			torrusParser = new TorrusConfigParser(TORRUS_HOME_WINDOWS);
		} else {
			torrusParser = new TorrusDummyParser();
		}
	}

	@Override
	public String[] getNodes() throws Exception {
		try {
			return torrusParser.getAvailableNodes();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
