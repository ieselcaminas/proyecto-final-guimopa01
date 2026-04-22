package org.example.proyectofinalguille.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.proyectofinalguille.entity.Entrenador;
import org.example.proyectofinalguille.entity.Pokemon;
import org.example.proyectofinalguille.service.PokemonService;
import org.example.proyectofinalguille.service.TipoService;


import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

public class PokemonController {

    private PokemonService pokemonService;
    private TipoService tipoService;

    @FXML
    private TextField nomPoke;
    @FXML
    private ChoiceBox<String> Tipo1;
    @FXML
    private ChoiceBox<String> Tipo2;
    @FXML
    private ListView<String> lista2;


    //iniciar
    public void iniciar(){
        actualizarLista();
    }
    //actualizarlista
    public void actualizarLista(){
        lista2.getItems().clear();

        List<Pokemon> pokes = pokemonService.findAll();

        for(Pokemon poke : pokes){
            lista2.getItems().add(poke.getNombre());
        }
    }

    //modificar poke + tipo
    public void modPoke(){

    }

    //Añadir poke + tipo
    @FXML
    protected void onAddEnt() {
        if (!nomPoke.getText().isEmpty()) {
            pokemonService.createPokemon(nomPoke.getText());
        }
        if (!Tipo1.getValue().isEmpty()) {
            tipoService.crearTipo(Tipo1.getValue());
        }
        if (!Tipo2.getValue().isEmpty()) {
            tipoService.crearTipo(Tipo2.getValue());
        }
        actualizarLista();
    }

    //Eliminar Pokemon
    @FXML
    protected void onDelEnt() {
        int indice = lista2.getSelectionModel().getSelectedIndex();

        if(indice >= 0){
            Pokemon p = pokemonService.findAll().get(indice);
            pokemonService.deletePokemon(p.getId());
        }
    }

    @FXML
    private void onAddTipo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Tipo.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Ventana Modal");

        stage.initModality(Modality.APPLICATION_MODAL); // Hace la ventana modal
        stage.initOwner(((Node)event.getSource()).getScene().getWindow()); // La asocia a la ventana principal

        stage.showAndWait(); // Bloquea hasta que se cierre
    }
}
