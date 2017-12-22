package de.metas.shipper.gateway.go;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.metas.shipper.gateway.api.ShipperGatewayClient;
import de.metas.shipper.gateway.api.model.Address;
import de.metas.shipper.gateway.api.model.CreateDeliveryOrderRequest;
import de.metas.shipper.gateway.api.model.DeliveryPosition;
import de.metas.shipper.gateway.api.model.PickupDate;
import de.metas.shipper.gateway.api.service.CountryCodeFactory;
import de.metas.shipper.gateway.go.schema.GOPaidMode;
import de.metas.shipper.gateway.go.schema.GOSelfDelivery;
import de.metas.shipper.gateway.go.schema.GOSelfPickup;
import de.metas.shipper.gateway.go.schema.GOServiceType;

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

@SpringBootApplication
public class Application
{
	public static void main(final String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner test(final ShipperGatewayClient shipperGatewayClient, final CountryCodeFactory countryCodeFactory)
	{
		System.out.println("Using: " + shipperGatewayClient);

		final CreateDeliveryOrderRequest request = CreateDeliveryOrderRequest.builder()
				.pickupAddress(Address.builder()
						.companyName1("from company")
						.street1("street 1")
						.houseNo("1")
						.zipCode("12345")
						.city("Bonn")
						.country(countryCodeFactory.getCountryCodeByAlpha2("DE"))
						.build())
				.pickupDate(PickupDate.builder()
						.date(LocalDate.of(2017, Month.DECEMBER, 30))
						.build())
				.deliveryAddress(Address.builder()
						.companyName1("to company")
						.street1("street 1")
						.houseNo("1")
						.zipCode("54321")
						.city("Koln")
						.country(countryCodeFactory.getCountryCodeByAlpha2("DE"))
						.build())
				.deliveryPosition(DeliveryPosition.builder()
						.numberOfPackages(1)
						.grossWeightKg(1)
						.content("some products")
						.build())
				.serviceType(GOServiceType.Overnight)
				.paidMode(GOPaidMode.Prepaid)
				.selfDelivery(GOSelfDelivery.Pickup)
				.selfPickup(GOSelfPickup.Delivery)
				.receiptConfirmationPhoneNumber("+40-746-010203")
				.build();
		return args -> {
			System.out.println("Request: " + request);
			shipperGatewayClient.createDeliveryOrder(request);
		};
	}
}
