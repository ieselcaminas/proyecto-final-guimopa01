package org.example.proyectofinalguille.controller;

import javafx.fxml.FXML;
import org.example.proyectofinalguille.entity.Pokemon;
import org.example.proyectofinalguille.entity.Tipo;
import org.example.proyectofinalguille.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TipoController {

    private TipoService tipoService;

    @FXML
    private javafx.scene.control.TextField nomType1;
    @javafx.fxml.FXML
    private javafx.scene.control.TextField nomType2;
    @javafx.fxml.FXML
    private javafx.scene.control.ListView<String> lista3;

    //iniciar
    public void iniciar(){
        actualizarLista();
    }

    @FXML
    protected void onAddTipo2() {
        if (!nomType1.getText().isEmpty()) {
            tipoService.crearTipo(nomType1.getText());
        }
        if (!nomType2.getText().isEmpty()) {
            tipoService.crearTipo(nomType2.getText());
        }
        actualizarLista();
    }

    @FXML
    protected void onDelTipo() {
        // Lógica para eliminar tipo seleccionado
    }

    //actualizarlista
    public void actualizarLista(){
        lista3.getItems().clear();

        List<Tipo> tipos = tipoService.findAll();

        for(Tipo tipo : tipos){
            lista3.getItems().add(tipo.getNombre());
        }
    }

    //modificar tipo
    public void modTipo(){

    }

    //Eliminar Tipo
    @FXML
    protected void onDelEnt() {
        int indice = lista3.getSelectionModel().getSelectedIndex();

        if(indice >= 0){
            Tipo tipo = tipoService.findAll().get(indice);
            tipoService.deleteTipo(tipo.getId());
        }
    }
}
