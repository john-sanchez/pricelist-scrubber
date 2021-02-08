package io.johnsanchez.pricelistscrubber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.johnsanchez.pricelistscrubber.services.PcHubDataService;

@RestController
@RequestMapping("/pchub")
public class PcHubDataController {

	@Autowired
	private PcHubDataService pcHubDataService;
	
	@RequestMapping("/fetch")
	public void scrubAndSave() {
		pcHubDataService.scrubAndSave();
	}
	
}
