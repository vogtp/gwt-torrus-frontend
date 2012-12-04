package ch.unibas.gwt.torrus.server;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TorrusConfigParser {
	
	private static final String NODE_CONFIG = "/etc/torrus/xmlconfig/spectrum_nodes.xml";
	private String[] nodes;
	private long lastModified;
	private String torrusHome;
	

	public TorrusConfigParser(String torrusHome) {
		super();
		this.torrusHome = torrusHome;
	}


	public String[] getAvailableNodes() throws ParserConfigurationException, SAXException, IOException {
		File nodeConfig = new File(torrusHome+NODE_CONFIG);
		long lm = nodeConfig.lastModified();
		if (nodes == null || lastModified < lm) {
			lastModified = lm;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(nodeConfig);
			
			NodeList includes = document.getElementsByTagName("include");
			nodes = new String[includes.getLength()];
			
			for (int i = 0; i <includes.getLength(); i++) {
				Node filenmeAttr = includes.item(i).getAttributes().getNamedItem("filename");
				String filename = filenmeAttr.getNodeValue();
				filename=filename.replace("nodes/", "");
				filename=filename.replace(".xml", "");
				nodes[i] = filename;
			}
		}
		
		return nodes;
	}
	
	
}
