/**
 * 
 */
package io.johnsanchez.pricelistscrubber.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.johnsanchez.pricelistscrubber.entities.PcHubData;
import io.johnsanchez.pricelistscrubber.feignclient.PcHubRawDataService;
import io.johnsanchez.pricelistscrubber.pojo.PcHubRawData;
import io.johnsanchez.pricelistscrubber.repositories.PcHubDataRepository;

/**
 * @author john-sanchez
 *
 */
@Service
public class PcHubDataService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PcHubDataService.class);
	
	@Autowired
	private PcHubDataRepository pcHubDataRepository;
	
	@Autowired
	private PcHubRawDataService pcHubDataService;
	
	@Transactional
	public void scrubAndSave() {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(LocalDate.now().atStartOfDay(defaultZoneId).toInstant());
		PcHubRawData rawData = pcHubDataService.getData();
		
		String[][] tableData = rawData.getValues();
		for (int i = 0; i < tableData.length; i++) {
			PcHubData data = new PcHubData();
			data.setRecordedDate(date);
			String[] rowData = tableData[i];
			safely(rowData, 0, data::setSku);
			safely(rowData, 1, data::setCategory);
			safely(rowData, 2, data::setProperties);
			safely(rowData, 3, data::setBrand);
			safely(rowData, 4, data::setUnknownField1);
			safely(rowData, 5, data::setDescription);
			safely(rowData, 6, s -> toBigDecimal(s, data::setCashPrice));
			safely(rowData, 7, s -> toBigDecimal(s, data::setCardPrice));
			safely(rowData, 8, s -> toBigDecimal(s, data::setShippingPriceLbc));
			safely(rowData, 9, data::setWarrantyNotes);
			safely(rowData, 10, data::setUrl);
			safely(rowData, 11, data::setUnknownField2);
			safely(rowData, 12, s -> toBigDecimal(s, data::setShippingJTMetroManila));
			safely(rowData, 13, s -> toBigDecimal(s, data::setShippingJTProvincial));
			safely(rowData, 14, data::setUnknownField3);
			safely(rowData, 15, data::setImageUrl);
			safely(rowData, 16, data::setUnknownField4);
			safely(rowData, 17, data::setUnknownField5);
			safely(rowData, 18, data::setUnknownField6);
			safely(rowData, 19, data::setUnknownField7);
			safely(rowData, 20, data::setAvailability);
			pcHubDataRepository.save(data);
		}
		
	}
	
	private static void safely(String[] rawData, int index, Consumer<String> consumer) {
		if (index < rawData.length) {
			consumer.accept(rawData[index]);
		}
	}
	
	private static void toBigDecimal(String s, Consumer<BigDecimal> b) {
		try {
			b.accept(new BigDecimal(s));
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

}
