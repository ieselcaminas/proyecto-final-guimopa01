package org.example.proyectofinalguille.service;

import jakarta.transaction.Transactional;
import org.example.proyectofinalguille.entity.Entrenador;
import org.example.proyectofinalguille.entity.Pokemon;
import org.example.proyectofinalguille.repository.EntrenadorRepository;
import org.example.proyectofinalguille.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class EntrenadorService {

    private EntrenadorRepository entrenadorRepository;
    private PokemonRepository pokemonRepository;

    @Autowired
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

    public Pokemon addPokemon(Long entrenador_id, Long pokemonId){
        Entrenador entrenador = entrenadorRepository.findById(entrenador_id).orElseThrow();
        Pokemon poke = pokemonRepository.findById(pokemonId).orElseThrow();
        entrenador.addPokemon(poke);
        entrenadorRepository.save(entrenador);
        return pokemonRepository.save(poke);
    }

    public List<Entrenador> findAll(){
        List<Entrenador> lista = (List<Entrenador>) entrenadorRepository.findAll();
        lista.forEach(e -> e.getPokemons().size());
        return lista;
    }

    public Entrenador findById(Long id) {
        return entrenadorRepository.findById(id).orElseThrow();
    }
}