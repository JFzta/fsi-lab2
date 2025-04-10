package com.udea.service;

import com.udea.domain.Pasajero;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.udea.domain.Pasajero}.
 */
public interface PasajeroService {
    /**
     * Save a pasajero.
     *
     * @param pasajero the entity to save.
     * @return the persisted entity.
     */
    Pasajero save(Pasajero pasajero);

    /**
     * Updates a pasajero.
     *
     * @param pasajero the entity to update.
     * @return the persisted entity.
     */
    Pasajero update(Pasajero pasajero);

    /**
     * Partially updates a pasajero.
     *
     * @param pasajero the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Pasajero> partialUpdate(Pasajero pasajero);

    /**
     * Get all the pasajeros.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Pasajero> findAll(Pageable pageable);

    /**
     * Get the "id" pasajero.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Pasajero> findOne(Long id);

    /**
     * Delete the "id" pasajero.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
