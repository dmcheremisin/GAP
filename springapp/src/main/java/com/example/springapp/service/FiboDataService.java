package com.example.springapp.service;

import com.example.springapp.entity.FiboData;
import com.example.springapp.repo.FiboDataRepo;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FiboDataService {

    private final FiboDataRepo someDataRepo;

    @Timed(value = "fibo_execution_time", description = "Time to calculate n-th fibo and save result")
    @Transactional
    public Long getFibo(Integer val) {
        Long result = calculateFibo(val);
        FiboData someData = new FiboData();
        someData.setRequest(val);
        someData.setResult(result);
        someData.setExecutionDate(LocalDateTime.now());
        someDataRepo.save(someData);
        return result;
    }

    private Long calculateFibo(Integer val) {
        long n1 = 0, n2 = 1;
        if (val == 0) return n1;
        if (val == 1) return n2;
        for (int i = 2; i <= val; i++) {
            long next = n1 + n2;
            n1 = n2;
            n2 = next;
        }
        return n2;
    }

}
