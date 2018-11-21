package se.esss.ics.masar.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import org.junit.Test;

public class ConfigTest {

	@Test
	public void testConfig() {
		Config config = Config.builder()
				.description("description")
				.system("system")
				.active(true)
				.id(1)
				.configPvList(Collections.<ConfigPv>emptyList())
				.build();
		
		
		assertTrue(config.isActive());
		assertEquals("description", config.getDescription());
		assertEquals("system", config.getSystem());
		assertTrue(config.getConfigPvList().isEmpty());
		
		Config config2 = Config.builder()
				.active(false)
				.description("description")
				.configPvList(Collections.<ConfigPv>emptyList())
				.build();
		config2.setId(2);
		
		assertFalse(config2.isActive());
		assertEquals("description", config2.getDescription());
		assertNull(config2.getSystem());
		assertTrue(config2.getConfigPvList().isEmpty());
		
		assertNotEquals(config, config2);
		
		assertEquals(config, config);
		
		assertNotEquals(config, "String");
		
	}
	
	@Test
	public void testConfigPv() {
		
		ConfigPv configPv = ConfigPv.builder()
				.groupname("groupname")
				.id(7)
				.pvName("pvName")
				.readonly(true)
				.tags("tags")
				.build();
		
		assertTrue(configPv.isReadonly());
		assertEquals(7, configPv.getId());
		assertEquals("pvName", configPv.getPvName());
		assertEquals("tags", configPv.getTags());
		assertEquals("groupname", configPv.getGroupname());
		
		Config config = Config.builder()
				.description("description")
				.system("system")
				.configPvList(Arrays.asList(configPv))
				.build();
		
		assertEquals(1, config.getConfigPvList().size());
		
		config.setParentId(7);
		config.setConfigPvList(Collections.emptyList());
		
		assertEquals(7, config.getParentId());
		assertTrue(config.getConfigPvList().isEmpty());
	}
	

	@Test
	public void testConfigPvNoArgsContructor() {
		
		ConfigPv configPv = new ConfigPv();
		assertNull(configPv.getGroupname());
		assertNull(configPv.getPvName());
		assertNull(configPv.getTags());
		assertEquals(0, configPv.getId());
	}

	
	@Test
	public void testDefaultConstructor() {
		assertEquals(NodeType.CONFIGURATION, new Config().getNodeType());
	}
	
	@Test
	public void testBuilder() {
		
		Date now = new Date();
		Config config = Config.builder()
				.active(false)
				.configPvList(Collections.emptyList())
				.created(now)
				.lastModified(now)
				.description("description")
				.id(1)
				.name("name")
				.system("system")
				.parentId(7)
				.build();
		
		assertEquals(1, config.getId());
		assertEquals(now, config.getCreated());
		assertEquals(now, config.getLastModified());
		assertTrue(config.getConfigPvList().isEmpty());
		assertFalse(config.isActive());
		assertEquals(7, config.getParentId());
		assertEquals("description", config.getDescription());
		assertEquals("name", config.getName());
		assertEquals("system", config.getSystem());
	}
	
	@Test
	public void testAllArgsContructor() {
		Date now = new Date();
		Config config = 
				new Config(1, "name", now, now, 7, false, "description", "system", Collections.emptyList());
		assertEquals(1, config.getId());
		assertEquals(now, config.getCreated());
		assertEquals(now, config.getLastModified());
		assertTrue(config.getConfigPvList().isEmpty());
		assertFalse(config.isActive());
		assertEquals(7, config.getParentId());
		assertEquals("description", config.getDescription());
		assertEquals("name", config.getName());
		assertEquals("system", config.getSystem());
	}
}
