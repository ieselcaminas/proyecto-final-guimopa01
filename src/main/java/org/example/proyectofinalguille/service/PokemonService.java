package org.example.proyectofinalguille.service;

import jakarta.transaction.Transactional;
import org.example.proyectofinalguille.entity.Entrenador;
import org.example.proyectofinalguille.entity.Pokemon;
import org.example.proyectofinalguille.entity.Tipo;
import org.example.proyectofinalguille.repository.EntrenadorRepository;
import org.example.proyectofinalguille.repository.PokemonRepository;
import org.example.proyectofinalguille.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final TipoRepository tipoRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository,
                          TipoRepository tipoRepository) {
        this.pokemonRepository = pokemonRepository;
        this.tipoRepository = tipoRepository;
    }

    public Pokemon createPokemon(String nombre){
        Pokemon p = pokemonRepository.findByNombreIgnoreCase(nombre);
        if (p != null) {
            return p;
        }
        p = new Pokemon(nombre);
        return pokemonRepository.save(p);
    }

    public void deletePokemon(Long id){
        pokemonRepository.deleteById(id);
    }

    public List<Pokemon> findAll(){
        return pokemonRepository.findAllWithTipos();
    }

    public Pokemon findByNombre(String nomPokemon) {
        Pokemon p = pokemonRepository.findByNombre(nomPokemon);
        if (p != null) {
            p.getTipo().size();
            p.getEntrenadors().size();
        }
        return p;
    }

    public Pokemon findById(Long id){
        Pokemon p = pokemonRepository.findById(id).orElseThrow();
        p.getTipo().size();
        p.getEntrenadors().size();
        return p;
    }

    

    @Transactional
    public void updatePokemon(Pokemon p) {
        pokemonRepository.save(p);
    }
}



