package de.changeperspective.enertrack.persistence.dto;

import de.changeperspective.enertrack.persistence.enums.EnergyMeterType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class EnergyMeter {

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    EnergyMeterType energyMeterType;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long energyMeterId;
    private String name;

    @Column(unique = true)
    private String counterNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "energymeter_id")
    private List<MeterReading> meterReadings = new ArrayList<>();

    /**
     * only for JPA.
     */
    protected EnergyMeter() {
    }

    private EnergyMeter(EnergyMeterType type, String name, String counterNumber, MeterReading meterReading) {
        this.name = name;
        this.counterNumber = counterNumber;
        this.energyMeterType = type;
        meterReadings.add(meterReading);
    }

    public static EnergyMeter createWaterMeter(String name, String counterNumber, float meterreading) {
        return new EnergyMeter(EnergyMeterType.WATER, name, counterNumber, new MeterReading(meterreading, LocalDateTime.now()));
    }

    public String getName() {
        return name;
    }

    public String getCounterNumber() {
        return counterNumber;
    }

    public List<MeterReading> getMeterReadings() {
        return Collections.unmodifiableList(meterReadings);
    }

    public void addMeterReading(MeterReading meterreading) {
        this.meterReadings.add(meterreading);
    }

    @Override
    public String toString() {
        return "WaterMeter{" +
                "id=" + energyMeterId +
                ", name='" + name + '\'' +
                ", counterNumber='" + counterNumber + '\'' +
                ", meterReadings=" + getMeterReadings() +
                '}';
    }
}
