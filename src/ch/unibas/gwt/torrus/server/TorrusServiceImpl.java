package ch.unibas.gwt.torrus.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
	private TorrusConfigParser torrusParser;
	
	public TorrusServiceImpl() {
		super();
		torrusParser = new TorrusConfigParser(TORRUS_HOME);
	}


	@Override
	public String[] getNodes() throws IOException, ParserConfigurationException, SAXException  {
		return torrusParser.getAvailableNodes();
	}


}
