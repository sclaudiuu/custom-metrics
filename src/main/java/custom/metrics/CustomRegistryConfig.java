package custom.metrics;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.config.MeterRegistryConfig;
import io.micrometer.prometheus.PrometheusConfig;

public interface CustomRegistryConfig extends PrometheusConfig {
	
	CustomRegistryConfig DEFAULT = k -> null;
	
	@Override
	default String prefix() {
		return "custom";
	}
}