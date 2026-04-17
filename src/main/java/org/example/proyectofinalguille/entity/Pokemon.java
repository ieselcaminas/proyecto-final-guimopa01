package org.example.proyectofinalguille.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;

    public Pokemon() {
    }
    public Pokemon(String nombre) {
        this.nombre = nombre;
    }

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    @ManyToMany(mappedBy = "pokemons")
    private Set<Tipo> tipo = new LinkedHashSet<>();

    public Set<Tipo> getTipo() {
        return tipo;
    }

    public void setTipo(Set<Tipo> tipo) {
        this.tipo = tipo;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
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