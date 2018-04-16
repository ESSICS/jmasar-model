package se.esss.ics.masar.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Snapshot{
	
	private Date created;
	private int id;
	private int configId;
	private boolean approve;
	private String userName;
	private int usernameId;
	private String comment;
	
	private List<SnapshotPv<?>> snapshotPvList;
	
	public void setSnapshotPvList(List<SnapshotPv<?>> snapshotPvList) {
		this.snapshotPvList = snapshotPvList;
	}
}
