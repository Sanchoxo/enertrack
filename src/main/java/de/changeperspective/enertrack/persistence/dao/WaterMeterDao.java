package de.changeperspective.enertrack.persistence.dao;

import de.changeperspective.enertrack.persistence.dto.WaterMeter;
import org.springframework.data.repository.CrudRepository;

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
public interface WaterMeterDao extends CrudRepository<WaterMeter, Long> {

    List<WaterMeter> findByCounterNumber(String counterNumber);

    WaterMeter findById(long id);
}
