package org.example.proyectofinalguille.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "entrenador")
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "entrenador", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Pokemon> pokemons = new LinkedHashSet<>();

    @Column(name = "nombre")
    private String nombre;

    public Entrenador(){
    }

    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        pokemon.setEntrenador(this);
    }

    public void removePokemon(Pokemon pokemon) {
        pokemons.remove(pokemon);
        pokemon.setEntrenador(null);
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
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

}