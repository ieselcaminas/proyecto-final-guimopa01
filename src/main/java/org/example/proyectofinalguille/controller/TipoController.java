package org.example.proyectofinalguille.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    private TextField nomType;
    @FXML
    private ListView<Tipo> lista3;



    //actualizarlista
    public void actualizarLista(){
        lista3.getItems().clear();
        lista3.getItems().addAll(tipoService.findAll());
    }

    //limpiar campos
    public void limpiar(){
        nomType.clear();
    }

    //poner datos para modificar
    @FXML
    public void onSelecTipo(){
        Tipo t = lista3.getSelectionModel().getSelectedItem();
        if(t == null){
            return;
        }
        nomType.setText(t.getNombre());
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

    private String mayusculas(String texto) {
        if (texto == null || texto.isEmpty()) return texto;
        texto = texto.trim().toLowerCase();
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }

    //añadir tipo
    @FXML
    protected void onAddTipo2() {
        String nombre = mayusculas(nomType.getText());

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
