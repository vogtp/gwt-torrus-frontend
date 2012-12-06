package ch.unibas.gwt.torrus.server;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface ITorrusParser {

	public String[] getAvailableNodes() throws ParserConfigurationException,
			SAXException, IOException;

}