package se.esss.ics.masar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigPv {
	
	private int id;
	private String pvName;
	
	@Builder.Default
	private boolean readonly = false;
	private String tags;
	private String groupname;
}
