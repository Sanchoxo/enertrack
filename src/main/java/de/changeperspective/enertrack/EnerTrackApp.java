package de.changeperspective.enertrack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnerTrackApp {

    private static final Logger log = LoggerFactory.getLogger(EnerTrackApp.class);

    public static void main(String[] args) {
        SpringApplication.run(EnerTrackApp.class, args);
    }

    //@Bean
    //@Transactional
    //public CommandLineRunner demo(WaterMeterDao repositoryWater, WaterReadingDao repositoryMeter)
    //}

}
