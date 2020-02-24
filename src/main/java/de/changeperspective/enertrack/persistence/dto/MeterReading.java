package de.changeperspective.enertrack.persistence.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * enertrack
 * <p>
 * Author Ralf Brameier
 * on GitHub Sanchoxo
 * visit project https://github.com/Sanchoxo/enertrack
 * <p>
 * Date 16. Februar 2020
 */
@Entity
public class MeterReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long meterReadingId;

    @ManyToOne
    private EnergyMeter energyMeter;

    private float meterReading;
    private LocalDateTime meterReadingTimestamp;

    /**
     * only for JPA.
     */
    protected MeterReading() {
    }

    public MeterReading(float meterReading, LocalDateTime meterReadingTimestamp) {
        this.meterReading = meterReading;
        this.meterReadingTimestamp = meterReadingTimestamp;
    }

    public long getMeterReadingId() {
        return meterReadingId;
    }

    public float getMeterReading() {
        return meterReading;
    }

    public void setMeterReading(float meterReading) {
        this.meterReading = meterReading;
    }

    public LocalDateTime getMeterReadingTimestamp() {
        return meterReadingTimestamp;
    }

    public void setMeterReadingTimestamp(LocalDateTime meterReadingTimestamp) {
        this.meterReadingTimestamp = meterReadingTimestamp;
    }

    @Override
    public String toString() {
        return "MeterReading{" +
                "id=" + meterReadingId +
                ", meterReading=" + meterReading +
                ", meterReadingTimestamp=" + meterReadingTimestamp +
                '}';
    }
}
