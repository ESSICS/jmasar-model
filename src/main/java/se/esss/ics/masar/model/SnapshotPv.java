package se.esss.ics.masar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SnapshotPv<T> {

	private int snapshotId;
	private int dtype;
	private int severity;
	private int status;
	private long time;
	private int timens;
	private T value;
	private boolean fetchStatus;
	private ConfigPv configPv;
}
