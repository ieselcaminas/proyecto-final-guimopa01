package org.example.proyectofinalguille.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo")
public class Tipo {
    @ManyToMany
    @JoinTable(name = "tipos_pokemons",
            joinColumns = @JoinColumn(name = "tipos_id"),
            inverseJoinColumns = @JoinColumn(name = "pokemons_id"))
    private Set<Pokemon> pokemons = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
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

}