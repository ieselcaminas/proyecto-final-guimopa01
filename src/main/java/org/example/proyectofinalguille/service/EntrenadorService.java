package org.example.proyectofinalguille.service;

import org.example.proyectofinalguille.entity.Entrenador;
import org.example.proyectofinalguille.entity.Pokemon;
import org.example.proyectofinalguille.repository.EntrenadorRepository;
import org.example.proyectofinalguille.repository.PokemonRepository;

import java.util.List;
import java.util.Optional;

public class EntrenadorService {

    private EntrenadorRepository entrenadorRepository;
    private PokemonRepository pokemonRepository;

    public EntrenadorService(EntrenadorRepository entrenadorRepository, PokemonRepository pokemonRepository) {
        this.entrenadorRepository = entrenadorRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public Entrenador createEntrenador(String nombre){
        return entrenadorRepository.save(new Entrenador(nombre));
    }

    public Entrenador updateEntrenador(Entrenador entrenador){
        return entrenadorRepository.save(entrenador);
    }

    public void deleteEntrenador(Long id){
        entrenadorRepository.deleteById(id);
    }

    public List<Pokemon> getPokemons(Long entrenador_id){
        return pokemonRepository.findByEntrenadorId(entrenador_id);
    }

    public Entrenador getEntrenador(Long id){
        return entrenadorRepository.findById(id).orElseThrow();
    }
}
