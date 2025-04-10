package com.udea.service;

import com.udea.domain.Asiento;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.udea.domain.Asiento}.
 */
public interface AsientoService {
    /**
     * Save a asiento.
     *
     * @param asiento the entity to save.
     * @return the persisted entity.
     */
    Asiento save(Asiento asiento);

    /**
     * Updates a asiento.
     *
     * @param asiento the entity to update.
     * @return the persisted entity.
     */
    Asiento update(Asiento asiento);

    /**
     * Partially updates a asiento.
     *
     * @param asiento the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Asiento> partialUpdate(Asiento asiento);

    /**
     * Get all the asientos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Asiento> findAll(Pageable pageable);

    /**
     * Get the "id" asiento.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Asiento> findOne(Long id);

    /**
     * Delete the "id" asiento.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
