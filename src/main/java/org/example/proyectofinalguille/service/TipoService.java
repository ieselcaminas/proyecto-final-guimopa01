package org.example.proyectofinalguille.service;

import org.example.proyectofinalguille.entity.Tipo;
import org.example.proyectofinalguille.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService {

    private TipoRepository tipoRepository;

    @Autowired
    public TipoService(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    public Tipo crearTipo(String nombre){
        return tipoRepository.save(new Tipo(nombre));
    }

    public void deleteTipo(Long id){
        tipoRepository.deleteById(id);
    }

    public Tipo updateTipo(Tipo tipo){
        return tipoRepository.save(tipo);
    }

    public List<Tipo> findAll() {
        return (List<Tipo>) tipoRepository.findAll();
    }

    public Tipo findByNombre(String tipo) {
        return tipoRepository.findByNombre(tipo);
    }
}
