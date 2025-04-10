package com.udea.service.impl;

import com.udea.domain.Asiento;
import com.udea.repository.AsientoRepository;
import com.udea.service.AsientoService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.udea.domain.Asiento}.
 */
@Service
@Transactional
public class AsientoServiceImpl implements AsientoService {

    private static final Logger LOG = LoggerFactory.getLogger(AsientoServiceImpl.class);

    private final AsientoRepository asientoRepository;

    public AsientoServiceImpl(AsientoRepository asientoRepository) {
        this.asientoRepository = asientoRepository;
    }

    @Override
    public Asiento save(Asiento asiento) {
        LOG.debug("Request to save Asiento : {}", asiento);
        return asientoRepository.save(asiento);
    }

    @Override
    public Asiento update(Asiento asiento) {
        LOG.debug("Request to update Asiento : {}", asiento);
        return asientoRepository.save(asiento);
    }

    @Override
    public Optional<Asiento> partialUpdate(Asiento asiento) {
        LOG.debug("Request to partially update Asiento : {}", asiento);

        return asientoRepository
            .findById(asiento.getId())
            .map(existingAsiento -> {
                if (asiento.getNumero() != null) {
                    existingAsiento.setNumero(asiento.getNumero());
                }
                if (asiento.getClase() != null) {
                    existingAsiento.setClase(asiento.getClase());
                }
                if (asiento.getDisponible() != null) {
                    existingAsiento.setDisponible(asiento.getDisponible());
                }

                return existingAsiento;
            })
            .map(asientoRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Asiento> findAll(Pageable pageable) {
        LOG.debug("Request to get all Asientos");
        return asientoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Asiento> findOne(Long id) {
        LOG.debug("Request to get Asiento : {}", id);
        return asientoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Asiento : {}", id);
        asientoRepository.deleteById(id);
    }
}
