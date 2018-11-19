/** 
 * Copyright (C) 2018 European Spallation Source ERIC.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package se.esss.ics.masar.model;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Class representing a configuration node. It holds a list of {@link ConfigPv}s, but does not
 * contain any other {@link Node} objects. A configuration in the save & restore context basically
 * lists the PVs that are to be saved to a {@link Snapshot} upon user request.
 * @author georgweiss
 * Created 14 Nov 2018
 */
@Getter
@NoArgsConstructor
public class Config extends Node {

	@ApiModelProperty(required = false, value = "Default is true. Use case not defined...", allowEmptyValue = true)
	private boolean active = true;
	@ApiModelProperty(required = true, value = "Describes the configuration")
	private String description;
	@ApiModelProperty(required = false, value = "The system/subsystem associated with the configuration", allowEmptyValue = true)
	private String system;
	@ApiModelProperty(required = true, value = "Must be specified, but can be updated.")
	private List<ConfigPv> configPvList;

	@Builder
	public Config(int id, String name, Date created, Date lastModified, int parentId, 
			boolean active, String description, String system, List<ConfigPv> configPvList) {
		super(id, name, created, lastModified, parentId, NodeType.CONFIGURATION);

		this.active = active;
		this.description = description;
		this.system = system;
		this.configPvList = configPvList;
	}


	public void setConfigPvList(List<ConfigPv> configPvList) {
		this.configPvList = configPvList;
	}
	
	/**
	 * @return {@link NodeType#CONFIGURATION}
	 */
	@Override
	public NodeType getNodeType() {
		return NodeType.CONFIGURATION;
	}
}
