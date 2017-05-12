package com.andyadc.utilities.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.TimeUnit;

/**
 * @author andaicheng
 * @version 2017/5/12
 */
public class GetStarted {

    static final MetricRegistry METRIC_REGISTRY = new MetricRegistry();

    public static void main(String[] args) {
        startReport();
        Meter meter = METRIC_REGISTRY.meter("request");
        meter.mark();
        wait5Seconds();
    }

    static void startReport() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(METRIC_REGISTRY)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(1, TimeUnit.SECONDS);
    }

    static void wait5Seconds() {
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
        }
    }
}
