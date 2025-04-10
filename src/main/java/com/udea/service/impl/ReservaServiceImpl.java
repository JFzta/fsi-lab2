package com.udea.service.impl;

import com.udea.domain.Reserva;
import com.udea.repository.ReservaRepository;
import com.udea.service.ReservaService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.udea.domain.Reserva}.
 */
@Service
@Transactional
public class ReservaServiceImpl implements ReservaService {

    private static final Logger LOG = LoggerFactory.getLogger(ReservaServiceImpl.class);

    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Reserva save(Reserva reserva) {
        LOG.debug("Request to save Reserva : {}", reserva);
        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva update(Reserva reserva) {
        LOG.debug("Request to update Reserva : {}", reserva);
        return reservaRepository.save(reserva);
    }

    @Override
    public Optional<Reserva> partialUpdate(Reserva reserva) {
        LOG.debug("Request to partially update Reserva : {}", reserva);

        return reservaRepository
            .findById(reserva.getId())
            .map(existingReserva -> {
                if (reserva.getCodigo() != null) {
                    existingReserva.setCodigo(reserva.getCodigo());
                }
                if (reserva.getFechaReserva() != null) {
                    existingReserva.setFechaReserva(reserva.getFechaReserva());
                }
                if (reserva.getEstado() != null) {
                    existingReserva.setEstado(reserva.getEstado());
                }

                return existingReserva;
            })
            .map(reservaRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Reserva> findAll(Pageable pageable) {
        LOG.debug("Request to get all Reservas");
        return reservaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Reserva> findOne(Long id) {
        LOG.debug("Request to get Reserva : {}", id);
        return reservaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Reserva : {}", id);
        reservaRepository.deleteById(id);
    }
}
