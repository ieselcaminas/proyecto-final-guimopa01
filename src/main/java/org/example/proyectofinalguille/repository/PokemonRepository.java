package org.example.proyectofinalguille.repository;

import org.example.proyectofinalguille.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
}