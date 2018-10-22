/*
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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author georgweiss
 * Created 1 Oct 2018
 */
public class ProviderTest {
	
	@Test
	public void basicTest() {
		
		Assert.assertEquals(Provider.ca, Provider.valueOf("ca"));
		Assert.assertEquals(Provider.pva, Provider.valueOf("pva"));
	}
}
