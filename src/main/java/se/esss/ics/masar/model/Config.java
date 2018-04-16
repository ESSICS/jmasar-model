package se.esss.ics.masar.model;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Config extends Node {

	private boolean active = true;
	private String description;
	private String system;
	private List<ConfigPv> configPvList;

	@Builder
	public Config(int id, String name, Date created, Date lastModified, Node parent, 
			boolean active, String description, String system, List<ConfigPv> configPvList) {
		super(id, name, created, lastModified, parent, NodeType.CONFIGURATION);

		this.active = active;
		this.description = description;
		this.system = system;
		this.configPvList = configPvList;
	}


	public void setConfigPvList(List<ConfigPv> configPvList) {
		this.configPvList = configPvList;
	}
	
	@Override
	public NodeType getNodeType() {
		return NodeType.CONFIGURATION;
	}

}
