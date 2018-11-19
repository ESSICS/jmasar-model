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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Class representing a snapshot, i.e. PV values read at some point in time. Note that
 * when the service is requested to take a snapshot, it will initially be in a "draft" state.
 * The PV data is maintained in a list of {@link SnapshotPv}s.
 * A snapshot will not be visible until the service is requested to "commit" it.
 * @author georgweiss
 * Created 14 Nov 2018
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Snapshot{
	
	@ApiModelProperty(required = false, value = "Create date of the snapshot, defined by the server", allowEmptyValue = true)
	private Date created;
	@ApiModelProperty(required = false, value = "Database id of the snapshot, defined by the server", allowEmptyValue = true)
	private int id;
	@ApiModelProperty(required = true, value = "Database id of the configuration associated with the snapshot")
	private int configId;
	@ApiModelProperty(required = false, value = "Default is false", allowEmptyValue = true)
	private boolean approve;
	@ApiModelProperty(required = true, value = "User/account name that triggered the snapshot. Need not be the same as the username of the configuration.")
	private String userName;
	@ApiModelProperty(required = false, value = "Database id of the username, defined by the server", allowEmptyValue = true)
	private int usernameId;
	@ApiModelProperty(required = false, value = "Optional comment for the snapshot", allowEmptyValue = true)
	private String comment;
	@ApiModelProperty(required = false, value = "Optional name of the snapshot", allowEmptyValue = true)
	private String name;
	
	private List<SnapshotPv<?>> snapshotPvList;
	
	public void setSnapshotPvList(List<SnapshotPv<?>> snapshotPvList) {
		this.snapshotPvList = snapshotPvList;
	}
}
