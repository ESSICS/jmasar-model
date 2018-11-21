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

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class encapsulating data associated with a PV. The {@link SnapshotPv#fetchStatus} field will
 * indicate if the service has been able to read the PV or not.
 * @author georgweiss
 * Created 14 Nov 2018
 * @param <T> The type for this generic class.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Created by the service when a snapshot is requested.")
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
