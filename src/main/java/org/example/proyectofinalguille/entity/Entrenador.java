package org.example.proyectofinalguille.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "entrenador")
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany
    @JoinTable(name = "entrenador_pokemons",
            joinColumns = @JoinColumn(name = "entrenador_id"),
            inverseJoinColumns = @JoinColumn(name = "pokemons_id"))
    private List<Pokemon> pokemons = new ArrayList<>();

    @Column(name = "nombre")
    private String nombre;

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
        pokemon.getEntrenadors().add(this);
    }

    public void removePokemon(Pokemon pokemon) {
        this.pokemons.remove(pokemon);
        pokemon.getEntrenadors().remove(this);
    }


    public Entrenador(){
    }

    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String pokes = (pokemons == null || pokemons.isEmpty())
                ? "Sin Pokémon"
                : pokemons.stream()
                .map(Pokemon::toString2)
                .collect(Collectors.joining(", "));

        return id + " | " + nombre + " | " + pokes;
    }

}