package io.johnsanchez.pricelistscrubber.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import io.johnsanchez.pricelistscrubber.pojo.PcHubRawData;

@FeignClient(name="pchub-googlesheets", url = "https://sheets.googleapis.com")
public interface PcHubDataService {
	
	//curl 'https://sheets.googleapis.com/v4/spreadsheets/10bTlhxgBCCsFCD3wvGMvHzDqKOOFqR-iFpiJFtTHirA/values/PLs!A8:U?key=AIzaSyCIdLw59N8o9vLSdb20BVwHzRAcyYoyewg' 
	// -H 'User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:85.0) Gecko/20100101 Firefox/85.0' 
	// -H 'Accept: application/json, text/plain, */*' 
	// -H 'Accept-Language: en-US,en;q=0.5' --compressed 
	// -H 'Origin: http://pchubpricelist.online' -H 'DNT: 1' 
	// -H 'Connection: keep-alive' 
	// -H 'Referer: http://pchubpricelist.online/' 
	// -H 'Cache-Control: max-age=0' 
	// -H 'TE: Trailers'	
	
	@RequestMapping(value="/v4/spreadsheets/10bTlhxgBCCsFCD3wvGMvHzDqKOOFqR-iFpiJFtTHirA/values/PLs!A8:U?key=AIzaSyCIdLw59N8o9vLSdb20BVwHzRAcyYoyewg",
			headers = {"Origin=http://pchubpricelist.online",
					"Referer=http://pchubpricelist.online/"})
	public PcHubRawData getData();

}
