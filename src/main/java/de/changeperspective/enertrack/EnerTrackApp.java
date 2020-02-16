package de.changeperspective.enertrack;

import de.changeperspective.enertrack.persistence.dao.WaterMeterDao;
import de.changeperspective.enertrack.persistence.dto.WaterMeter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EnerTrackApp {

    private static final Logger log = LoggerFactory.getLogger(EnerTrackApp.class);

    public static void main(String[] args) {
        SpringApplication.run(EnerTrackApp.class, args);
    }

    @Bean
    public CommandLineRunner demo(WaterMeterDao repository) {
        return (args) -> {
            // save a few watermeter
            repository.save(new WaterMeter("Brameier Hauptzähler", "123992-BR-ST-RH-1"));
            repository.save(new WaterMeter("Brameier Gartenzähler", "123992-BR-ST-RH-2"));
            repository.save(new WaterMeter("Brameier Ferienhaus", "2211099-BR-OH-KL-1", 433.76f));

            // fetch all watermeters
            log.info("Watermeters found with findAll():");
            log.info("-------------------------------");
            for (WaterMeter watermeter : repository.findAll()) {
                log.info(watermeter.toString());
            }
            log.info("");

            // fetch an individual watermeter by ID
            WaterMeter watermeter = repository.findById(1L);
            log.info("WaterMeter found with findById(1L):");
            log.info("--------------------------------");
            log.info(watermeter.toString());
            log.info("");

            // fetch watermeters by counternumber
            log.info("Watermeter found with findByCounterNumber('2211099-BR-OH-KL-1'):");
            log.info("--------------------------------------------");
            repository.findByCounterNumber("2211099-BR-OH-KL-1").forEach(waterMeter -> log.info(waterMeter.toString()));
            log.info("");
        };
    }

}
