package de.metas.shipper.gateway.api;

import de.metas.shipper.gateway.api.exceptions.ShipperGatewayException;
import de.metas.shipper.gateway.api.model.CreateDeliveryOrderRequest;
import de.metas.shipper.gateway.api.model.DeliveryOrderResponse;
import de.metas.shipper.gateway.api.model.OrderId;
import de.metas.shipper.gateway.api.model.UpdateDeliveryOrderRequest;

/*
 * #%L
 * de.metas.shipper.gateway.api
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

public interface ShipperGatewayClient
{
	DeliveryOrderResponse createDeliveryOrder(CreateDeliveryOrderRequest request) throws ShipperGatewayException;

	DeliveryOrderResponse updateDeliveryOrder(UpdateDeliveryOrderRequest request) throws ShipperGatewayException;

	DeliveryOrderResponse completePickupOrder(OrderId orderId) throws ShipperGatewayException;

	DeliveryOrderResponse voidPickupOrder(OrderId orderId) throws ShipperGatewayException;
}
