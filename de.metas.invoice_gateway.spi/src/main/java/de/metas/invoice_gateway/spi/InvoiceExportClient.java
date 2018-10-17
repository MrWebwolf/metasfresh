package de.metas.invoice_gateway.spi;

import lombok.NonNull;

import java.util.List;

import de.metas.invoice_gateway.spi.model.InvoiceToExport;
import de.metas.invoice_gateway.spi.model.InvoiceExportResult;

/*
 * #%L
 * metasfresh-invoice.gateway.commons
 * %%
 * Copyright (C) 2018 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

/** SPI to extend for different formats and protocols. */
public interface InvoiceExportClient
{
	public boolean canExport(@NonNull final InvoiceToExport invoice);

	public List<InvoiceExportResult> export(@NonNull final InvoiceToExport invoice);
}
