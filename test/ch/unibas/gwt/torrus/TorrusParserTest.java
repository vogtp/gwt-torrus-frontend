package ch.unibas.gwt.torrus;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.unibas.gwt.torrus.server.parser.TorrusConfigParser;

public class TorrusParserTest {

	@Test
	public void testGetAvailableNodes() throws Exception{
		TorrusConfigParser tcp = new TorrusConfigParser("/opt/pm/");
		String[] nodes = tcp.getAvailableNodes();
		assertNotNull(nodes);
		assertTrue(nodes.length > 0);
	}

}
