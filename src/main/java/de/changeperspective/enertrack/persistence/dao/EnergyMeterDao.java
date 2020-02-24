package de.changeperspective.enertrack.persistence.dao;

import de.changeperspective.enertrack.persistence.dto.EnergyMeter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Interface for WaterMeterRepository CRUD.
 * <p>
 * enertrack
 * <p>
 * Author Ralf Brameier
 * on GitHub Sanchoxo
 * visit project https://github.com/Sanchoxo/enertrack
 * <p>
 * Date 15. Februar 2020
 */
@Repository
@Transactional
public interface EnergyMeterDao extends CrudRepository<EnergyMeter, Long> {

    List<EnergyMeter> findByCounterNumber(String counterNumber);

    EnergyMeter findById(long id);
}
