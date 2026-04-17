package org.example.proyectofinalguille.repository;

import org.example.proyectofinalguille.entity.Entrenador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface EntrenadorRepository extends CrudRepository<Entrenador, Long> {
}