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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Class encapsulating data to describe a PV from a "masar" point of view.
 * @author georgweiss
 * Created 1 Oct 2018
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigPv {
	
	private int id;
	private String pvName;
	
	/**
	 * The default provider is ca, see {@link Provider}.
	 */
	@Builder.Default
	private Provider provider = Provider.ca;
	
	@Builder.Default
	private boolean readonly = false;
	private String tags;
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
