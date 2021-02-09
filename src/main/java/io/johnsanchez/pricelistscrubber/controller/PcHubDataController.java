package io.johnsanchez.pricelistscrubber.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
//		List<PcHubData> latest = pcHubDataService.findLatest();
//		List<List<Object>> data = new ArrayList<List<Object>>();
//		for (PcHubData phdata : latest) {
//			List<Object> values = new ArrayList<Object>();
//			values.add(phdata.getCategory());
//			values.add(phdata.getBrand() + " " + phdata.getProperties() + " " + phdata.getDescription());
//			values.add(phdata.getCashPrice().toString());
//			values.add(phdata.getAvailability());
//			values.add(phdata.getSku());
//			data.add(values);
//		}
		return Collections.singletonMap("data", pcHubDataService.findLatest());
	}
	
	@RequestMapping("/fetch")
	public void scrubAndSave() {
		pcHubDataService.scrubAndSave();
	}
	
}
