package custom.metrics;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.ToDoubleFunction;

import org.springframework.stereotype.Service;

import io.micrometer.core.annotation.Incubating;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry.Config;
import io.micrometer.core.instrument.MeterRegistry.More;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.distribution.DistributionStatisticConfig;
import io.micrometer.core.instrument.search.RequiredSearch;
import io.micrometer.core.instrument.search.Search;
import io.micrometer.core.lang.Nullable;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.CollectorRegistry;

@Service
public class CustomMeterRegistry {

	private PrometheusMeterRegistry prometheusMeterRegistry;

	public CustomMeterRegistry(PrometheusMeterRegistry prometheusMeterRegistry) {
		this.prometheusMeterRegistry = new PrometheusMeterRegistry(CustomRegistryConfig.DEFAULT);
	}

	public List<Meter> getMetters() {
		return prometheusMeterRegistry.getMeters();
	}

	public void forEachMeter(Consumer<? super Meter> consumer) {
		prometheusMeterRegistry.forEachMeter(consumer);
	}

	public Config config() {
		return prometheusMeterRegistry.config();
	}

	public Search find(String name) {
		return prometheusMeterRegistry.find(name);
	}

	public RequiredSearch get(String name) {
		return prometheusMeterRegistry.get(name);
	}

	public Counter counter(String name, Iterable<Tag> tags) {
		return prometheusMeterRegistry.counter(name, tags);
	}

	public Counter counter(String name, String... tags) {
		return prometheusMeterRegistry.counter(name, tags);
	}

	public DistributionSummary summary(String name, Iterable<Tag> tags) {
		return prometheusMeterRegistry.summary(name, tags);
	}

	public DistributionSummary summary(String name, String... tags) {
		return prometheusMeterRegistry.summary(name, tags);
	}

	public Timer timer(String name, Iterable<Tag> tags) {
		return prometheusMeterRegistry.timer(name, tags);
	}

	public Timer timer(String name, String... tags) {
		return prometheusMeterRegistry.timer(name, tags);
	}

	public More more() {
		return prometheusMeterRegistry.more();
	}

	@Nullable
	public <T> T gauge(String name, Iterable<Tag> tags, @Nullable T stateObject, ToDoubleFunction<T> valueFunction) {
		return prometheusMeterRegistry.gauge(name, tags, stateObject, valueFunction);
	}

	@Nullable
	public <T extends Number> T gauge(String name, Iterable<Tag> tags, T number) {
		return prometheusMeterRegistry.gauge(name, tags, number);
	}

	@Nullable
	public <T extends Number> T gauge(String name, T number) {
		return prometheusMeterRegistry.gauge(name, number);
	}

	@Nullable
	public <T> T gauge(String name, T stateObject, ToDoubleFunction<T> valueFunction) {
		return prometheusMeterRegistry.gauge(name, stateObject, valueFunction);
	}

	@Nullable
	public <T extends Collection<?>> T gaugeCollectionSize(String name, Iterable<Tag> tags, T collection) {
		return prometheusMeterRegistry.gaugeCollectionSize(name, tags, collection);
	}

	@Nullable
	public <T extends Map<?, ?>> T gaugeMapSize(String name, Iterable<Tag> tags, T map) {
		return prometheusMeterRegistry.gaugeMapSize(name, tags, map);
	}

	@Incubating(since = "1.1.0")
	@Nullable
	public Meter remove(Meter meter) {
		return prometheusMeterRegistry.remove(meter);
	}

	@Incubating(since = "1.1.0")
	@Nullable
	public Meter remove(Meter.Id mappedId) {
		return prometheusMeterRegistry.remove(mappedId);
	}

	@Incubating(since = "1.2.0")
	public void clear() {
		prometheusMeterRegistry.clear();
	}

	public void close() {
		prometheusMeterRegistry.close();
	}

	public boolean isClosed() {
		return prometheusMeterRegistry.isClosed();
	}

	public String scrape() {
		return prometheusMeterRegistry.scrape();
	}

	public void scrape(Writer writer) throws IOException {
		prometheusMeterRegistry.scrape(writer);
	}

	public Counter newCounter(Meter.Id id) {
		return prometheusMeterRegistry.newCounter(id);
	}

	public DistributionSummary newDistributionSummary(Meter.Id id,
			DistributionStatisticConfig distributionStatisticConfig, double scale) {
		return prometheusMeterRegistry.newDistributionSummary(id, distributionStatisticConfig, scale);
	}

	public CollectorRegistry getPrometheusRegistry() {
		return prometheusMeterRegistry.getPrometheusRegistry();
	}

}