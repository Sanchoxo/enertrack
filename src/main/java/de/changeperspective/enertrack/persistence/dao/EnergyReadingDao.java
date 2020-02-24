package de.changeperspective.enertrack.persistence.dao;

import de.changeperspective.enertrack.persistence.dto.MeterReading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Interface for WaterReadingRepository CRUD.
 * <p>
 * enertrack
 * <p>
 * Author Ralf Brameier
 * on GitHub Sanchoxo
 * visit project https://github.com/Sanchoxo/enertrack
 * <p>
 * Date 22. Februar 2020
 */
@Repository
@Transactional
public interface EnergyReadingDao extends CrudRepository<MeterReading, Long> {

    MeterReading findById(long id);

    List<MeterReading> findByEnergyMeter(long energyMeterId);
}
