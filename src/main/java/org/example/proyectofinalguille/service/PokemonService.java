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
    private final EntrenadorRepository entrenadorRepository;
    private final TipoRepository tipoRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository, EntrenadorRepository entrenadorRepository, TipoRepository tipoRepository) {
        this.pokemonRepository = pokemonRepository;
        this.entrenadorRepository = entrenadorRepository;
        this.tipoRepository = tipoRepository;
    }

    public Pokemon createPokemon(String nombre){
        Pokemon p = pokemonRepository.findByNombreIgnoreCase(nombre);
        if (p != null) {
            return p;
        }
        p = pokemonRepository.save(new Pokemon(nombre));
        p.getTipo().size();
        p.getEntrenadors().size();
        return p;
    }


    public void deletePokemon(Long id){
        pokemonRepository.deleteById(id);
    }

    @Transactional
    public void updatePokemon(Pokemon p) {
        Pokemon managed = pokemonRepository.findById(p.getId())
                .orElseThrow();

        managed.setNombre(p.getNombre());

        // Sobrescribimos completamente la lista de tipos
        managed.getTipo().clear();
        managed.getTipo().addAll(p.getTipo());
    }

    public Pokemon findById(Long id){
        Pokemon p = pokemonRepository.findById(id).orElseThrow();
        p.getTipo().size();
        p.getEntrenadors().size();
        return p;
    }

    public List<Pokemon> findAll(){
        return pokemonRepository.findAllWithTipos();
    }


    public Tipo addTipo(Long id, Long idPokemon){
        Pokemon p = pokemonRepository.findById(idPokemon).orElseThrow();
        Tipo t = tipoRepository.findById(id).orElseThrow();
        p.addTipo(t);
        pokemonRepository.save(p);
        return t;
    }

    public Pokemon findByNombre(String nomPokemon) {
        Pokemon p = pokemonRepository.findByNombre(nomPokemon);
        if (p != null) {
            p.getEntrenadors().size();
            p.getTipo().size();
        }
        return p;
    }
}


