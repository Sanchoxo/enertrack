package de.changeperspective.enertrack.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.changeperspective.enertrack.persistence.dao.EnergyMeterDao;
import de.changeperspective.enertrack.persistence.dao.EnergyReadingDao;
import de.changeperspective.enertrack.persistence.dto.EnergyMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/water")
public class WaterRestController {
    @Autowired
    EnergyReadingDao energyReadingDao;

    @Autowired
    EnergyMeterDao energyMeterDao;

    @Autowired
    ObjectMapper objectMapper;

    @PostConstruct
    private void registerObjectMapperModules() {
        objectMapper.findAndRegisterModules();
    }

    @RequestMapping("")
    public String waterOverview() {
        // save a few watermeter
        EnergyMeter brameier_hauptzaehler = EnergyMeter.createWaterMeter("Brameier Hauptzähler", "123992-BR-ST-RH-1", 0f);
        EnergyMeter brameier_gartenzaehler = EnergyMeter.createWaterMeter("Brameier Gartenzähler", "123992-BR-ST-RH-2", 172.2118f);
        EnergyMeter brameier_ferienhauszaehler = EnergyMeter.createWaterMeter("Brameier Ferienhaus", "2211099-BR-OH-KL-1", 9857.82f);

        energyMeterDao.save(brameier_hauptzaehler);
        energyMeterDao.save(brameier_gartenzaehler);
        energyMeterDao.save(brameier_ferienhauszaehler);

        StringBuilder sb = new StringBuilder();
        // fetch all watermeters
        sb.append("Watermeters found with findAll():");
        sb.append("</br>");
        for (EnergyMeter watermeter : energyMeterDao.findAll()) {
            sb.append(watermeter.toString());
            sb.append("</br>");
        }
        sb.append("</br>");

        // fetch an individual watermeter by ID
        EnergyMeter watermeter = energyMeterDao.findById(1L);
        sb.append("WaterMeter found with findById(1L):");
        sb.append("</br>");
        sb.append(watermeter.toString());
        sb.append("</br>");

        // fetch watermeters by counternumber
        sb.append("Watermeter found with findByCounterNumber('2211099-BR-OH-KL-1'):");
        sb.append("</br>");
        energyMeterDao.findByCounterNumber("2211099-BR-OH-KL-1").forEach(energyMeter -> sb.append(energyMeter.toString() + "</br>"));
        sb.append("</br>");

        return "Wasserzählerübersicht:</br>" + sb.toString();
    }

    @GetMapping("/getWaterMeter")
    public String getWater(@RequestParam("id") long id) throws JsonProcessingException {
        EnergyMeter energyMeter = this.energyMeterDao.findById(id);
        return objectMapper.writeValueAsString(energyMeter);
    }

    @PostMapping("")
    public String createNewWaterMeter() throws JsonProcessingException {
        String jso2 = "{\"name\":\"Testzähler NEW\",\"zaehlernummer\":\"12118-A-ST-1\",\"zaehlerstand\":12398.434,\"ableseZeitstempel\":[2020,2,14,19,37,59,484553900]}";
        EnergyMeter energyMeter = objectMapper.readValue(jso2, EnergyMeter.class);
        return objectMapper.writeValueAsString(energyMeter);
    }

    @PutMapping("")
    public String updateExistingWaterMeter() throws JsonProcessingException {
        String jso2 = "{\"name\":\"Testzähler Update\",\"zaehlernummer\":\"12118-A-ST-1\",\"zaehlerstand\":12398.434,\"ableseZeitstempel\":[2020,2,14,19,37,59,484553900]}";
        EnergyMeter energyMeter = objectMapper.readValue(jso2, EnergyMeter.class);
        return objectMapper.writeValueAsString(energyMeter);
    }
}



