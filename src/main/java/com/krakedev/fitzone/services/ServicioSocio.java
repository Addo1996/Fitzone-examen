
package com.krakedev.fitzone.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.fitzone.entidades.Socio;
import com.krakedev.fitzone.repository.SocioRepository;

@Service
public class ServicioSocio {

    private SocioRepository socioRepository;

    public ServicioSocio(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    // crear socio y validar edad
    public Socio crear(Socio s) {
        if (s.getEdad() < 14) {
            throw new IllegalArgumentException("La edad minima permitida es 14 años.");
        }

        return socioRepository.save(s);
    }

    // listar todos los socios
    public List<Socio> listar() {
        return socioRepository.findAll();
    }

    // buscar socios por estado
    public List<Socio> buscarPorEstado(boolean activo) {
        return socioRepository.findByActivo(activo);
    }
}
