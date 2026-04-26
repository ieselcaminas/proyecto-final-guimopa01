package org.example.proyectofinalguille.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.proyectofinalguille.entity.Entrenador;
import org.example.proyectofinalguille.entity.Pokemon;
import org.example.proyectofinalguille.entity.Tipo;
import org.example.proyectofinalguille.service.PokemonService;
import org.example.proyectofinalguille.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PokemonController {

    @FXML
    private TextField nomPoke;
    @FXML
    private ChoiceBox<String> Tipo1;
    @FXML
    private ChoiceBox<String> Tipo2;
    @FXML
    private ListView<Pokemon> lista2;
    private TipoService tipoService;
    private PokemonService pokemonService;

    public void setServices(TipoService tipoService, PokemonService pokemonService) {
        this.tipoService = tipoService;
        this.pokemonService = pokemonService;

        cargarTipos();
        actualizarLista();
    }




    //Cargar tipos en el choice box
    public void cargarTipos(){
        List<Tipo> tipos = tipoService.findAll();
        List<String> listaTipos = tipos.stream().map(Tipo::getNombre).toList();

        Tipo1.getItems().clear();
        Tipo2.getItems().clear();

        Tipo1.getItems().addAll(listaTipos);
        Tipo2.getItems().addAll(listaTipos);
    }

    //actualizarlista
    public void actualizarLista(){
        lista2.getItems().clear();
        lista2.getItems().addAll(pokemonService.findAll());
    }

    //limpiar campos
    public void limpiar(){
        nomPoke.clear();
        Tipo1.setValue(null);
        Tipo2.setValue(null);
    }

    //poner datos para modificar
    @FXML
    public void onSelecPokemon() {
        Pokemon p = lista2.getSelectionModel().getSelectedItem();
        if (p == null) {
            return;
        }

        nomPoke.setText(p.getNombre());
        Tipo1.setValue(null);
        Tipo2.setValue(null);

        List<Tipo> tipos = new ArrayList<>(p.getTipo());
        if(tipos.size()>=1){
            Tipo1.setValue(tipos.get(0).getNombre());
        }
        if(tipos.size()>=2){
            Tipo2.setValue(tipos.get(1).getNombre());
        }
    }

    //modificar poke + tipo
    public void modPoke(){
    Pokemon p = lista2.getSelectionModel().getSelectedItem();
    if (p == null) {
        return;
    }

    p.setNombre(nomPoke.getText());
    p.getTipo().clear();
    pokemonService.updatePokemon(p);
    asignarTipo(p,Tipo1.getValue());
    asignarTipo(p,Tipo2.getValue());

    pokemonService.updatePokemon(p);
    limpiar();
    actualizarLista();
    }

    private void asignarTipo(Pokemon p, String tipo){
        if(tipo != null){
            Tipo t = tipoService.findByNombre(tipo);
            if(t != null && !p.getTipo().contains(t)){
                p.addTipo(t);
            }
        }
    }

    private String mayusculas(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }
        texto = texto.trim().toLowerCase();
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }


    //Añadir poke + tipo
    @FXML
    public void onAddPoke2(javafx.event.ActionEvent event) {
        String nombre = mayusculas(nomPoke.getText());

        if(nombre.isEmpty()){
            return;
        }
        if(Tipo1.getValue() == null && Tipo2.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("No puede existir un Pokémon sin un tipo.");
            alert.showAndWait();
            return;
        }

        Pokemon p = pokemonService.createPokemon(nombre);
        asignarTipo(p,Tipo1.getValue());
        asignarTipo(p,Tipo2.getValue());

        pokemonService.updatePokemon(p);
        limpiar();
        actualizarLista();
    }


    //Eliminar Pokemon
    @FXML
    public void onDelPoke(javafx.event.ActionEvent event) {
        System.out.println("Eliminar Pokémon");
        int index = lista2.getSelectionModel().getSelectedIndex();

        if (index >= 0) {
            Pokemon p = pokemonService.findAll().get(index);
            pokemonService.deletePokemon(p.getId());
            limpiar();
            actualizarLista();
        }
    }

    @FXML
    private void onAddTipo(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/proyectofinalguille/Tipo.fxml"));
        Parent root = loader.load();

        TipoController controller = loader.getController();
        controller.setTipoService(tipoService);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Ventana Modal");

        stage.initModality(Modality.APPLICATION_MODAL); // Hace la ventana modal
        stage.initOwner(((Node)event.getSource()).getScene().getWindow()); // La asocia a la ventana principal

        stage.showAndWait(); // Bloquea hasta que se cierre

        cargarTipos();
    }

}