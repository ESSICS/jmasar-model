package se.esss.ics.masar.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Date;

import org.junit.Test;

public class FolderTest {

	@Test
	public void testBuilder() {
		
		Date now = new Date();
		
		Folder folder = Folder.builder()
				.created(now)
				.lastModified(now)
				.id(1)
				.name("name")
				.parent(null)
				.childNodes(Collections.emptyList())
				.build();
		
		assertEquals(1, folder.getId());
		assertEquals("name", folder.getName());
		assertEquals(now, folder.getCreated());
		assertEquals(now, folder.getLastModified());
		assertNull(folder.getParent());
		assertTrue(folder.getChildNodes().isEmpty());
		
	}
	
	@Test
	public void testNoArgsContructor() {
		
		Folder folder = new Folder();
		
		assertEquals(NodeType.FOLDER, folder.getNodeType());
		assertTrue(folder.getChildNodes().isEmpty());
		assertNull(folder.getCreated());
		assertNull(folder.getLastModified());
		assertNull(folder.getName());
		assertEquals(0, folder.getId());
		assertNull(folder.getParent());
	}
}
