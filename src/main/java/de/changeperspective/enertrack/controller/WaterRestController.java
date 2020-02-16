package de.changeperspective.enertrack.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.changeperspective.enertrack.persistence.dto.WaterMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/water")
public class WaterRestController {

    @Autowired
    ObjectMapper objectMapper;

    @PostConstruct
    private void registerObjectMapperModules(){
        objectMapper.findAndRegisterModules();
    }

    @RequestMapping("")
    public String waterOverview() {
        return "Wasserzählerübersicht";
    }

    @GetMapping("/getWaterMeter")
    public String getWater(@RequestParam("id") long id) throws JsonProcessingException {
        WaterMeter waterMeter = new WaterMeter("TEst", "Test2");
        return objectMapper.writeValueAsString(waterMeter);
    }

    @PostMapping("")
    public String createNewWaterMeter() throws JsonProcessingException {
        String jso2 = "{\"name\":\"Testzähler NEW\",\"zaehlernummer\":\"12118-A-ST-1\",\"zaehlerstand\":12398.434,\"ableseZeitstempel\":[2020,2,14,19,37,59,484553900]}";
        WaterMeter waterMeter = objectMapper.readValue(jso2, WaterMeter.class);
        return objectMapper.writeValueAsString(waterMeter);
    }

    @PutMapping("")
    public String updateExistingWaterMeter() throws JsonProcessingException {
        String jso2 = "{\"name\":\"Testzähler Update\",\"zaehlernummer\":\"12118-A-ST-1\",\"zaehlerstand\":12398.434,\"ableseZeitstempel\":[2020,2,14,19,37,59,484553900]}";
        WaterMeter waterMeter = objectMapper.readValue(jso2, WaterMeter.class);
        return objectMapper.writeValueAsString(waterMeter);
    }
}



