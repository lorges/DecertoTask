package com.decerto;

import com.decerto.service.DataJoinService;
import com.decerto.strategy.AddictionStrategy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRunner implements CommandLineRunner {

    private final DataJoinService dataJoinService;

    public ApplicationRunner(DataJoinService dataJoinService) {
        this.dataJoinService = dataJoinService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        dataJoinService.setJoinDataStrategy(new AddictionStrategy());
        System.out.println("Joined data value= " + dataJoinService.prepareAndReturnJoinedData());
    }

}
