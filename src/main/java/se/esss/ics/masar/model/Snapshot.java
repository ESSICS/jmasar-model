/** 
 * Copyright (C) ${year} European Spallation Source ERIC.
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
	private String name;
	
	private List<SnapshotPv<?>> snapshotPvList;
	
	public void setSnapshotPvList(List<SnapshotPv<?>> snapshotPvList) {
		this.snapshotPvList = snapshotPvList;
	}
}
