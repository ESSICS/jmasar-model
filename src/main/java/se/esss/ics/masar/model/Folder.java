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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Class representing a folder in the tree structure maintained by the jmasar service. A folder
 * contains an array of child nodes that are either {@link Folder}s or {@link Config}s.
 * @author georgweiss
 * Created 14 Nov 2018
 */
@Getter
@NoArgsConstructor
public class Folder extends Node {

	@ApiModelProperty(required = false, value = "Child nodes are added separately", allowEmptyValue = true)
	private List<Node> childNodes = new ArrayList<>();

	@Builder
	public Folder(int id, String name, Date created, Date lastModified, int parentId, List<Node> childNodes) {
		super(id, name, created, lastModified, parentId, NodeType.FOLDER);
		this.childNodes = childNodes;
	}

	/**
	 * @return {@link NodeType#FOLDER}
	 */
	@Override
	public NodeType getNodeType() {
		return NodeType.FOLDER;
	}
	
	@Override
	public boolean equals(Object other) {
		return super.equals(other);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
