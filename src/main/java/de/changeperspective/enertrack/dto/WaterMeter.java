package de.changeperspective.enertrack.dto;

import java.time.LocalDateTime;

public class WaterMeter {

    public final long id;
    public String name = "Testzähler";
    public String zaehlernummer = "12118-A-ST-1";
    public float zaehlerstand = 12398.4334f;
    public LocalDateTime ableseZeitstempel = LocalDateTime.now();

    public WaterMeter(long id) {
        this.id = id;
    }

}
