
package com.krakedev.fitzone.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.fitzone.entidades.Socio;
import com.krakedev.fitzone.services.ServicioSocio;

@RestController
@RequestMapping("/socios")
public class SocioController {

    private final ServicioSocio servicioSocio;

    public SocioController(ServicioSocio servicioSocio) {
        this.servicioSocio = servicioSocio;
    }

    // crear socio
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Socio socio) {
        try {
            Socio nuevoSocio = servicioSocio.crear(socio);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoSocio);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // listar socios
    @GetMapping
    public ResponseEntity<List<Socio>> listar() {
        return ResponseEntity.ok(servicioSocio.listar());
    }

    // buscar socios por estado
    @GetMapping("/estado")
    public ResponseEntity<List<Socio>> buscarPorEstado(
            @RequestParam boolean activo) {
        return ResponseEntity.ok(servicioSocio.buscarPorEstado(activo));
    }
}
