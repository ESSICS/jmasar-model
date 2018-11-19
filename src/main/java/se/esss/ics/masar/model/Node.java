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

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/**
 * Superclass representing a node in a tree structure maintained by the jmasar service.
 * @author georgweiss
 *
 */
public class Node{
	
	@ApiModelProperty(required = false, value = "Database id of the node, defined by the server", allowEmptyValue = true)
	private int id;
	@ApiModelProperty(required = true, value = "Name of the folder or configuration")
	private String name;
	@ApiModelProperty(required = false, value = "Creation date, set by the server", allowEmptyValue = true)
	private Date created;
	@ApiModelProperty(required = false, value = "Last modified date, set by the server", allowEmptyValue = true)
	private Date lastModified;
	@ApiModelProperty(required = true, value = "Parent node id. Node with id=0 is the tree root.")
	private int parentId;
	@ApiModelProperty(required = false, value = "Set by the subclass.")
	private NodeType nodeType;
	
	/**
	 * Do not change!!!
	 */
	public static final int ROOT_NODE_ID = 0;
	
	public void setParent(int parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * This implementation uses the database id field to determine if folder objects are 
	 * equal. However, if both objects have id=0 (e.g. before they have been created in the database),
	 * they are treated as not being equal.
	 * 
	 * <b>NOTE!</b> Since subclasses of this class do not implement an equals() method, the side effect of using
	 * only the database id to determine of objects are equal means that a {@link Node} object may be equal
	 * to a {@link Folder} object. This should however not happen for objects originating from a persistence
	 * layer if the persistence layer guarantees that each {@link Node} object obtains a unique database id.
	 */
	@Override
	public boolean equals(Object other) {
		
		if (other instanceof Node) {
			Node otherNode = (Node)other;
			if(otherNode.getId() == 0 && getId() == 0) {
				return false;
			}
			
			return otherNode.getId() == getId();
		}

		return false;
	}

	@Override
	public int hashCode() {
		return getId();
	}
}
