package com.example.springapp.controller;

import com.example.springapp.prometheus.MetricsService;
import com.example.springapp.service.FiboDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fibo")
public class FiboController {

    private final FiboDataService someDataService;

    private final MetricsService metricsService;

    @GetMapping("/{val}")
    public Long getFibo(@PathVariable Integer val) {
        metricsService.incrementFiboRequests();
        metricsService.setFiboControllerInput(val);
        return someDataService.getFibo(val);
    }

}
