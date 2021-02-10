package io.johnsanchez.pricelistscrubber.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.johnsanchez.pricelistscrubber.entities.PcHubData;
import io.johnsanchez.pricelistscrubber.services.PcHubDataService;

@RestController
@RequestMapping("/pchub")
public class PcHubDataController {

	@Autowired
	private PcHubDataService pcHubDataService;
	
	@RequestMapping("/latest")
	public List<PcHubData> latest() {
		return pcHubDataService.findLatest();
	}
	
	@RequestMapping("/latest-dt")
	public Map<String, Object> latestForDataTable() {
		return Collections.singletonMap("data", pcHubDataService.findLatest());
	}
	
	@RequestMapping
	public List<PcHubData> findBySku(@RequestParam("sku") String sku) {
		return pcHubDataService.findBySkuOrderByRecordedDateAsc(sku);
	}
	
	@RequestMapping("/fetch")
	public void scrubAndSave() {
		pcHubDataService.scrubAndSave();
	}
	
}
