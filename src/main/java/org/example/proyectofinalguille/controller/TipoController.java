package org.example.proyectofinalguille.controller;

import javafx.fxml.FXML;
import org.example.proyectofinalguille.entity.Pokemon;
import org.example.proyectofinalguille.entity.Tipo;
import org.example.proyectofinalguille.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TipoController {

    private TipoService tipoService;
    public void setTipoService(TipoService tipoService) {
        this.tipoService = tipoService;

        actualizarLista();
    }

    @FXML
    private javafx.scene.control.TextField nomType;
    @FXML
    private javafx.scene.control.ListView<String> lista3;



    //actualizarlista
    public void actualizarLista(){
        lista3.getItems().clear();

        List<Tipo> tipos = tipoService.findAll();

        for(Tipo tipo : tipos){
            lista3.getItems().add(tipo.getNombre());
        }
    }

    //limpiar campos
    public void limpiar(){
        nomType.clear();
    }

    //poner datos para modificar
    @FXML
    public void onSelecTipo(){
        int index = lista3.getSelectionModel().getSelectedIndex();
        if(index < 0){
            return;
        }
        Tipo tipo = tipoService.findAll().get(index);
        nomType.setText(tipo.getNombre());
    }

    //modificar tipo
    public void modTipo(){
        int index = lista3.getSelectionModel().getSelectedIndex();
        if(index < 0){
            return;
        }
        Tipo tipo = tipoService.findAll().get(index);
        tipo.setNombre(nomType.getText());
        tipoService.updateTipo(tipo);
        limpiar();
        actualizarLista();
    }


    //añadir tipo
    @FXML
    protected void onAddTipo2() {
        String nombre = nomType.getText();

        if(nombre.isEmpty()){
            return;
        }

        Tipo tipo = tipoService.crearTipo(nombre);
        tipoService.updateTipo(tipo);
        limpiar();
        actualizarLista();
    }

    //eliminar tipo
    @FXML
    protected void onDelTipo() {
        int index = lista3.getSelectionModel().getSelectedIndex();
        if(index >= 0){
            Tipo tipo = tipoService.findAll().get(index);
            tipoService.deleteTipo(tipo.getId());
            limpiar();
            actualizarLista();
        }
    }


}
