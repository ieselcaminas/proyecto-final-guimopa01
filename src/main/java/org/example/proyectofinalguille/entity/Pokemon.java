package org.example.proyectofinalguille.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tipos_pokemons",
            joinColumns = @JoinColumn(name = "pokemons_id"),
            inverseJoinColumns = @JoinColumn(name = "tipos_id"))
    private List<Tipo> tipo = new ArrayList<>();

    private String nombre;

    @ManyToMany(mappedBy = "pokemons")
    private List<Entrenador> entrenadors = new ArrayList<>();

    public List<Entrenador> getEntrenadors() {
        return entrenadors;
    }

    public void setEntrenadors(List<Entrenador> entrenadors) {
        this.entrenadors = entrenadors;
    }

    public Pokemon() {
    }
    public Pokemon(String nombre) {
        this.nombre = nombre;
    }

    public List<Tipo> getTipo() {
        return tipo;
    }

    public void setTipo(List<Tipo> tipo) {
        this.tipo = tipo;
    }

    public void addEntrenador(Entrenador entrenador) {
        this.entrenadors.add(entrenador);
        entrenador.getPokemons().add(this);
    }

    public void removeEntrenador(Entrenador entrenador) {
        this.entrenadors.remove(entrenador);
        entrenador.getPokemons().remove(this);
    }

    public void addTipo(Tipo t) {
        if (!tipo.contains(t) && tipo.size() < 2) {
            tipo.add(t);
        }
    }

    public void removeTipo(Tipo t) {
        this.tipo.remove(t);
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
        String listaTipos = tipo.stream()
                .map(Tipo::getNombre)
                .collect(Collectors.joining(", "));

        return id + " | " + nombre + " (" + listaTipos + ")";
    }

    public String toString2() {
        String listaTipos = tipo.stream()
                .map(Tipo::getNombre)
                .collect(Collectors.joining(", "));

        return nombre + " (" + listaTipos + ")";
    }

}