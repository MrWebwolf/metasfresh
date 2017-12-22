package de.metas.shipper.gateway.go.schema;

import de.metas.shipper.gateway.api.model.SelfDelivery;
import lombok.Getter;

/*
 * #%L
 * de.metas.shipper.go
 * %%
 * Copyright (C) 2017 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

/**
 * Self delivery: does the Sender bring to Shipper or Shipper is fetching from Sender.
 * 
 * @author metas-dev <dev@metasfresh.com>
 *
 */
public enum GOSelfDelivery implements SelfDelivery
{
	/** Shipper will fetch the packages from Sender */
	Pickup("0"),
	/** Sender is bringing packages to Shipper */
	SelfPickup("1");

	@Getter
	private final String code;

	private GOSelfDelivery(final String code)
	{
		this.code = code;
	}
}
