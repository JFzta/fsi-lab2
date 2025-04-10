package com.udea.service.impl;

import com.udea.domain.Vuelo;
import com.udea.repository.VueloRepository;
import com.udea.service.VueloService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.udea.domain.Vuelo}.
 */
@Service
@Transactional
public class VueloServiceImpl implements VueloService {

    private static final Logger LOG = LoggerFactory.getLogger(VueloServiceImpl.class);

    private final VueloRepository vueloRepository;

    public VueloServiceImpl(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @Override
    public Vuelo save(Vuelo vuelo) {
        LOG.debug("Request to save Vuelo : {}", vuelo);
        return vueloRepository.save(vuelo);
    }

    @Override
    public Vuelo update(Vuelo vuelo) {
        LOG.debug("Request to update Vuelo : {}", vuelo);
        return vueloRepository.save(vuelo);
    }

    @Override
    public Optional<Vuelo> partialUpdate(Vuelo vuelo) {
        LOG.debug("Request to partially update Vuelo : {}", vuelo);

        return vueloRepository
            .findById(vuelo.getId())
            .map(existingVuelo -> {
                if (vuelo.getNumeroVuelo() != null) {
                    existingVuelo.setNumeroVuelo(vuelo.getNumeroVuelo());
                }
                if (vuelo.getOrigen() != null) {
                    existingVuelo.setOrigen(vuelo.getOrigen());
                }
                if (vuelo.getDestino() != null) {
                    existingVuelo.setDestino(vuelo.getDestino());
                }
                if (vuelo.getFechaSalida() != null) {
                    existingVuelo.setFechaSalida(vuelo.getFechaSalida());
                }
                if (vuelo.getFechaLlegada() != null) {
                    existingVuelo.setFechaLlegada(vuelo.getFechaLlegada());
                }

                return existingVuelo;
            })
            .map(vueloRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Vuelo> findAll(Pageable pageable) {
        LOG.debug("Request to get all Vuelos");
        return vueloRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Vuelo> findOne(Long id) {
        LOG.debug("Request to get Vuelo : {}", id);
        return vueloRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Vuelo : {}", id);
        vueloRepository.deleteById(id);
    }
}
