package org.example.proyectofinalguille.service;

import org.example.proyectofinalguille.entity.Pokemon;
import org.example.proyectofinalguille.repository.EntrenadorRepository;
import org.example.proyectofinalguille.repository.PokemonRepository;
import org.example.proyectofinalguille.repository.TipoRepository;

public class PokemonService {

    private PokemonRepository pokemonRepository;
    private EntrenadorRepository entrenadorRepository;
    private TipoRepository tipoRepository;

    public PokemonService(PokemonRepository pokemonRepository, EntrenadorRepository entrenadorRepository, TipoRepository tipoRepository) {
        this.pokemonRepository = pokemonRepository;
        this.entrenadorRepository = entrenadorRepository;
        this.tipoRepository = tipoRepository;
    }

    public Pokemon createPokemon(String nombre){
        return pokemonRepository.save(new Pokemon(nombre));
    }

    public void deletePokemon(Long id){
        pokemonRepository.deleteById(id);
    }

    public Pokemon updatePokemon(Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }
}
