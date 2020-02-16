package de.changeperspective.enertrack.persistence.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class WaterMeter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String counterNumber;
    private float meterReading;
    private LocalDateTime meterReadingTimestamp = LocalDateTime.now();

    /**
     * only for JPA.
     */
    protected WaterMeter() {
    }

    public WaterMeter(String name, String counterNumber, float meterReading) {
        this.name = name;
        this.counterNumber = counterNumber;
        this.meterReading = meterReading;
        this.meterReadingTimestamp = LocalDateTime.now();
    }

    public WaterMeter(String name, String counterNumber) {
        this(name, counterNumber, 0f);
    }

    @Override
    public String toString() {
        return "WaterMeter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", counterNumber='" + counterNumber + '\'' +
                ", meterReading=" + meterReading +
                ", meterReadingTimestamp=" + meterReadingTimestamp +
                '}';
    }
}
