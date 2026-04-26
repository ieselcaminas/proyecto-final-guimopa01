package org.example.proyectofinalguille.service;

import jakarta.transaction.Transactional;
import org.example.proyectofinalguille.entity.Tipo;
import org.example.proyectofinalguille.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService {

    private final TipoRepository tipoRepository;

    @Autowired
    public TipoService(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    public Tipo crearTipo(String nombre){
        Tipo t = tipoRepository.findByNombreIgnoreCase(nombre);
        if (t != null) {
            return t;
        }
        return tipoRepository.save(new Tipo(nombre));
    }


    public void deleteTipo(Long id){
        tipoRepository.deleteById(id);
    }

    public Tipo updateTipo(Tipo tipo){
        return tipoRepository.save(tipo);
    }

    @Transactional
    public List<Tipo> findAll() {
        List<Tipo> lista = (List<Tipo>) tipoRepository.findAll();
        lista.forEach(t -> t.getPokemons().size());
        return lista;
    }
    public Tipo findByNombre(String tipo) {
        return tipoRepository.findByNombre(tipo);
    }

    public Tipo findById(Long id){
        Tipo t = tipoRepository.findById(id).orElseThrow();
        t.getPokemons().size();
        return t;
    }
}
