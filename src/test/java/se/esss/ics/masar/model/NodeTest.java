package se.esss.ics.masar.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.Test;

public class NodeTest {

	@Test
	public void test1() {
		
		Node node = new Node();
		node.setId(1);
		
		Node node2 = new Node();
		node2.setId(2);
		
		assertNotEquals(node, node2);
		assertEquals(node, node);
		assertNotEquals(node, "String");		
	}
	
	@Test
	public void genericTest() {
		
		Date now = new Date();
		
		Node node = new Node();
		
		node.setCreated(now);
		node.setLastModified(now);
		node.setId(1);
		node.setName("name");
		node.setNodeType(NodeType.CONFIGURATION);
		node.setParentId(7);
		
		assertEquals(now, node.getCreated());
		assertEquals(now, node.getLastModified());
		assertEquals(1, node.getId());
		assertEquals("name", node.getName());
		assertEquals(NodeType.CONFIGURATION, node.getNodeType());
		assertEquals(7, node.getParentId());
	}
	
	@Test
	public void tesEquals() {
		
		Node node1 = new Node();
		Node node2 = new Node();
		
		assertNotEquals(node1, node2);
		
		node1.setId(1);
		assertNotEquals(node1, node2);
		
		node2.setId(1);
		assertEquals(node1, node2);
		
		Folder folder1 = Folder.builder()
				.id(0)
				.build();
		
		Folder folder2 = Folder.builder()
				.id(0)
				.build();
		
		assertNotEquals(folder1, folder2);
		
		folder1.setId(1);
		
		assertEquals(node1, folder1);
		
		assertEquals(folder1, node1);
		
		folder2.setId(1);
		assertEquals(folder1, folder2);
		
		folder2.setId(2);
		assertNotEquals(folder1, folder2);
		
		Config config1 = Config.builder()
				.id(0)
				.build();
		
		Config config2 = Config.builder()
				.id(0)
				.build();
		
		assertNotEquals(config1, config2);
		
		config1.setId(1);
		assertNotEquals(config1, config2);
		
		config2.setId(1);
		assertEquals(config1, config2);
		
		assertEquals(node1, config1);
		
		assertEquals(folder1, config1);
	}
}
