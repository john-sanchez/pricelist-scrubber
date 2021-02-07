package io.johnsanchez.pricelistscrubber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PricelistScrubberApplication {

	public static void main(String[] args) {
		SpringApplication.run(PricelistScrubberApplication.class, args);
	}

}
