package custom.metrics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.micrometer.core.instrument.Meter;

@Component
@RestControllerEndpoint(id = "custom-metters")
public class CustomMetterController {

	@Autowired
	CustomMeterRegistry customMeterRegistry;

	@GetMapping
	public @ResponseBody List<Meter> getMettersList() {
		return customMeterRegistry.getMetters();
	}

	@GetMapping(value = "/scrape")
	public String getMetters() {
		return customMeterRegistry.scrape();
	}
}
