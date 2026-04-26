package org.example.proyectofinalguille.repository;

import org.example.proyectofinalguille.entity.Tipo;
import org.springframework.data.repository.CrudRepository;

public interface TipoRepository extends CrudRepository<Tipo, Long> {
    Tipo findByNombre(String nombre);

    Tipo findByNombreIgnoreCase(String nombre);
}