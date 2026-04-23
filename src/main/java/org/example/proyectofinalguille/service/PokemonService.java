package org.example.proyectofinalguille.service;

import jakarta.transaction.Transactional;
import org.example.proyectofinalguille.entity.Pokemon;
import org.example.proyectofinalguille.repository.EntrenadorRepository;
import org.example.proyectofinalguille.repository.PokemonRepository;
import org.example.proyectofinalguille.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class PokemonService {

    private PokemonRepository pokemonRepository;
    private EntrenadorRepository entrenadorRepository;
    private TipoRepository tipoRepository;

    @Autowired
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

    public List<Pokemon> findAll(){
        return (List<Pokemon>) pokemonRepository.findAll();

    }

    public Pokemon findByNombre(String nomPokemon) {
        return pokemonRepository.findByNombre(nomPokemon);
    }
}


