package com.example.springapp.prometheus;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MetricsService {

    private final Counter fiboRequests;

    private final AtomicInteger fiboControllerInput;

    public MetricsService(MeterRegistry meterRegistry) {
        fiboRequests = Counter.builder("fibo.controller.requests")
                .description("Total GET /fibo controller requests")
                .tags("controller", "fibo")
                .register(meterRegistry);
        fiboControllerInput = meterRegistry.gauge("fibo.controller.input", new AtomicInteger(0));
    }

    public void incrementFiboRequests() {
        fiboRequests.increment();
    }

    public void setFiboControllerInput(Integer request) {
        fiboControllerInput.set(request);
    }
}