package org.example.proyectofinalguille.repository;

import org.example.proyectofinalguille.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    List<Pokemon> findByEntrenadorId(Long entrenador_id);

    Pokemon findByNombre(String nomPokemon);

}