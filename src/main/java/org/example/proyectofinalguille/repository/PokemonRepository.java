package org.example.proyectofinalguille.repository;

import org.example.proyectofinalguille.entity.Pokemon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    List<Pokemon> findByEntrenadorsId(Long id);

    Pokemon findByNombre(String nomPokemon);

    Pokemon findByNombreIgnoreCase(String nombre);

    List<Pokemon> findAll();

    @Query("SELECT p FROM Pokemon p LEFT JOIN FETCH p.tipo")
    List<Pokemon> findAllWithTipos();

}