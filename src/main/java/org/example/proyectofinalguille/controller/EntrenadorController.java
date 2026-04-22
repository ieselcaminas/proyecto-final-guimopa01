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
import org.example.proyectofinalguille.service.EntrenadorService;
import org.example.proyectofinalguille.service.PokemonService;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;


public class EntrenadorController {

    private PokemonService pokemonService;
    private EntrenadorService entrenadorService;

    @FXML
    private TextField nomEntrenador;
    @FXML
    private ChoiceBox<String> poke1;
    @FXML
    private ChoiceBox<String> poke2;
    @FXML
    private ChoiceBox<String> poke3;
    @FXML
    private ChoiceBox<String> poke4;
    @FXML
    private ChoiceBox<String> poke5;
    @FXML
    private ChoiceBox<String> poke6;
    @FXML
    private ListView<String> lista;


    //iniciar
    public void initialize(){
        //actualizarLista();
    }
    //actualizarlista
    public void actualizarLista(){
        lista.getItems().clear();

        List<Entrenador> entrenadors = entrenadorService.findAll();
        
        for(Entrenador entrenador : entrenadors){
            lista.getItems().add(entrenador.getNombre());
        }
    }

    //modificar entrenador + poke
    public void modEnt(){

    }

    //Añadir entrenador + poke
    @FXML
    protected void onAddEnt() {
        if (!nomEntrenador.getText().isEmpty()) {
            entrenadorService.createEntrenador(nomEntrenador.getText());
        }
        if (!poke1.getValue().isEmpty()) {
            pokemonService.createPokemon(poke1.getValue());
        }
        if (!poke2.getValue().isEmpty()) {
            pokemonService.createPokemon(poke2.getValue());
        }
        if (!poke3.getValue().isEmpty()) {
            pokemonService.createPokemon(poke3.getValue());
        }
        if (!poke4.getValue().isEmpty()) {
            pokemonService.createPokemon(poke4.getValue());
        }
        if (!poke5.getValue().isEmpty()) {
            pokemonService.createPokemon(poke5.getValue());
        }
        if (!poke6.getValue().isEmpty()) {
            pokemonService.createPokemon(poke6.getValue());
        }
        actualizarLista();
    }

    //Eliminar entrenador
    @FXML
    protected void onDelEnt() {
        int indice = lista.getSelectionModel().getSelectedIndex();
        
        if(indice >= 0){
            Entrenador e = entrenadorService.findAll().get(indice);
            entrenadorService.deleteEntrenador(e.getId());
        }
    }

    
    @FXML
    public void onAddPoke(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pokemon.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Ventana Modal");

        stage.initModality(Modality.APPLICATION_MODAL); // Hace la ventana modal
        stage.initOwner(((Node)event.getSource()).getScene().getWindow()); // La asocia a la ventana principal

        stage.showAndWait(); // Bloquea hasta que se cierre
    }

}
