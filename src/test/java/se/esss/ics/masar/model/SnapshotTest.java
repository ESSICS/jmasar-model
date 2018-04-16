package se.esss.ics.masar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import org.junit.Test;

import se.esss.ics.masar.model.Snapshot;
import se.esss.ics.masar.model.SnapshotPv;

import static org.junit.Assert.*;

public class SnapshotTest {
	
	@Test
	public void testSnapshot() {
		
		Date now = new Date();
		
		Snapshot snapshot = Snapshot.builder()
			.created(now)
			.id(77)
			.approve(false)
			.comment("comment")
			.configId(1)
			.snapshotPvList(Collections.emptyList())
			.userName("userName")
			.usernameId(9)
			.build();
		
		assertFalse(snapshot.isApprove());
		assertEquals(77, snapshot.getId());
		assertEquals("comment", snapshot.getComment());
		assertEquals("userName", snapshot.getUserName());
		assertEquals(1, snapshot.getConfigId());
		assertEquals(9, snapshot.getUsernameId());
		assertTrue(snapshot.getSnapshotPvList().isEmpty());
		assertEquals(now, snapshot.getCreated());
		
		snapshot.setSnapshotPvList(null);
		
		assertNull(snapshot.getSnapshotPvList());
	}
	
	@Test
	public void testSnapshotPv() {
		
		SnapshotPv<Double> snapshotPv = SnapshotPv.<Double>builder()
				.dtype(4)
				.snapshotId(777)
				.severity(9)
				.status(10)
				.time(1000L)
				.timens(7777)
				.value(new Double(7.7))
				.configPv(ConfigPv.builder().pvName("whatever").build())
				.build();
		
		assertEquals(4, snapshotPv.getDtype());
		assertEquals(777, snapshotPv.getSnapshotId());
		assertEquals(9, snapshotPv.getSeverity());
		assertEquals(10, snapshotPv.getStatus());
		assertEquals(1000L, snapshotPv.getTime());
		assertEquals(7777, snapshotPv.getTimens());
		assertEquals(Double.class, snapshotPv.getValue().getClass());
		assertEquals(7.7, snapshotPv.getValue().doubleValue(), 0);
		assertEquals("whatever", snapshotPv.getConfigPv().getPvName());
		assertFalse(snapshotPv.isFetchStatus());
		
		assertNotEquals(snapshotPv, "String");
		assertEquals(snapshotPv, snapshotPv);
		
		Date now = new Date();
		
		Snapshot snapshot = Snapshot.builder()
		.created(now)
		.id(77)
		.snapshotPvList(Arrays.<SnapshotPv<?>>asList(snapshotPv))
		.build();
		
		assertFalse(snapshot.isApprove());
		assertEquals(77,  snapshot.getId());
		assertNull(snapshot.getComment());
		assertNull(snapshot.getUserName());
		assertEquals(1, snapshot.getSnapshotPvList().size());
		
	}
	
	@Test
	public void testNoArgsConstructor() {
		
		Snapshot snapshot = new Snapshot();
		String s = snapshot.getComment();
		
		assertNull(s);
		assertNull(snapshot.getCreated());
		assertNull(snapshot.getSnapshotPvList());
		assertNull(snapshot.getUserName());
		assertEquals(0, snapshot.getConfigId());
		assertEquals(0, snapshot.getId());
		assertEquals(0, snapshot.getUsernameId());
	}
	
	@Test
	public void testSnapshotPvNoArgsContructor() {
		SnapshotPv<Double> snapshotPv = new SnapshotPv<>();
		
		assertNull(snapshotPv.getConfigPv());
		assertNull(snapshotPv.getValue());
		assertEquals(0, snapshotPv.getDtype());
		assertEquals(0, snapshotPv.getSeverity());
		assertEquals(0, snapshotPv.getStatus());
		assertEquals(0, snapshotPv.getTime());
		assertEquals(0,  snapshotPv.getTimens());
		assertEquals(0,  snapshotPv.getSnapshotId());
		assertFalse(snapshotPv.isFetchStatus());
	}
	
	@Test
	public void testSnapshotPvSetters() {
		SnapshotPv<Double> snapshotPv = new SnapshotPv<>();
		
		snapshotPv.setConfigPv(ConfigPv.builder().build());
		snapshotPv.setSeverity(1);
		snapshotPv.setDtype(2);
		snapshotPv.setFetchStatus(true);
		snapshotPv.setSnapshotId(3);
		snapshotPv.setStatus(4);
		snapshotPv.setTime(5);
		snapshotPv.setTimens(6);
		snapshotPv.setValue(new Double(7.7));
		
		assertNotNull(snapshotPv.getConfigPv());
		assertEquals(7.7, snapshotPv.getValue(), 0.01);
		assertEquals(2, snapshotPv.getDtype());
		assertEquals(1, snapshotPv.getSeverity());
		assertEquals(4, snapshotPv.getStatus());
		assertEquals(5, snapshotPv.getTime());
		assertEquals(6,  snapshotPv.getTimens());
		assertEquals(3,  snapshotPv.getSnapshotId());
		assertTrue(snapshotPv.isFetchStatus());
	}
}
