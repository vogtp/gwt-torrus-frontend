package ch.unibas.gwt.torrus.server.parser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class TorrusDummyParser implements ITorrusParser {

	@Override
	public String[] getAvailableNodes() throws ParserConfigurationException,
			SAXException, IOException {
		return new String[] { "server1", "server2", "switch1", "switch2" };
	}

}
