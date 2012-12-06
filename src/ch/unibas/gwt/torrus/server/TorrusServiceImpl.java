package ch.unibas.gwt.torrus.server;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import ch.unibas.gwt.torrus.client.service.TorrusService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class TorrusServiceImpl extends RemoteServiceServlet implements
		TorrusService {

	private static final String TORRUS_HOME = "/opt/pm/";
	private ITorrusParser torrusParser;
	
	public TorrusServiceImpl() {
		super();
		// torrusParser = new TorrusConfigParser(TORRUS_HOME);
		torrusParser = new TorrusDummyParser();
	}


	@Override
	public String[] getNodes() throws IOException, ParserConfigurationException, SAXException  {
		return torrusParser.getAvailableNodes();
	}


}
