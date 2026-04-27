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

    private final EntrenadorRepository entrenadorRepository;
    private final PokemonRepository pokemonRepository;

    @Autowired
    public EntrenadorService(EntrenadorRepository entrenadorRepository, PokemonRepository pokemonRepository) {
        this.entrenadorRepository = entrenadorRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public Entrenador createEntrenador(String nombre){
        return entrenadorRepository.save(new Entrenador(nombre));
    }

    public Entrenador updateEntrenador(Entrenador entrenador){
        entrenadorRepository.save(entrenador);
        return entrenador;
    }

    public void deleteEntrenador(Long id){
        entrenadorRepository.deleteById(id);
    }

    public List<Pokemon> getPokemons(Long entrenadorId){
        Entrenador e = entrenadorRepository.findById(entrenadorId).orElseThrow();
        e.getPokemons().size();
        return new ArrayList<>(e.getPokemons());
    }
    public Entrenador getEntrenador(Long id){
        return entrenadorRepository.findById(id).orElseThrow();
    }

    public Pokemon addPokemon(Long entrenadorId, Long pokemonId){
        Entrenador entrenador = entrenadorRepository.findById(entrenadorId).orElseThrow();
        Pokemon poke = pokemonRepository.findById(pokemonId).orElseThrow();
        entrenador.addPokemon(poke);
        entrenadorRepository.save(entrenador);
        return poke;
    }

    public List<Entrenador> findAll() {
        List<Entrenador> lista = entrenadorRepository.findAll();

        lista.forEach(e -> {
            e.getPokemons().size();

            e.getPokemons().forEach(p -> {
                p.getTipo().size();
            });
        });

        return lista;
    }

    public Entrenador findById(Long id) {
        return entrenadorRepository.findById(id).orElseThrow();
    }
}