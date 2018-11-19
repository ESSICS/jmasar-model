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

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Class encapsulating data to describe a PV subject to a save operation (=take snapshot).
 * @author georgweiss
 * Created 1 Oct 2018
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigPv {
	
	@ApiModelProperty(required = false, value = "Database id of the config PV, defined by the server", allowEmptyValue = true)
	private int id;
	@ApiModelProperty(required = true, value = "The fully qualified EPICS PV name")
	private String pvName;
	
	/**
	 * The default provider is {@link Provider#ca}.
	 */
	@ApiModelProperty(required = false, value = "Defaults to ca (=channel access)", allowEmptyValue = true)
	@Builder.Default
	private Provider provider = Provider.ca;
	
	@ApiModelProperty(required = false, value = "Defaults to false. Use case TBD", allowEmptyValue = true)
	@Builder.Default
	private boolean readonly = false;
	@ApiModelProperty(required = false, value = "Use case TBD", allowEmptyValue = true)
	private String tags;
	@ApiModelProperty(required = false, value = "Use case TBD", allowEmptyValue = true)
	private String groupname;
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof ConfigPv) {
			return pvName.equals(((ConfigPv)other).getPvName());
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return pvName.hashCode();
	}
}
