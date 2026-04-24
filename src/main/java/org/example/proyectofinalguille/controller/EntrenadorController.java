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
import org.example.proyectofinalguille.service.EntrenadorService;
import org.example.proyectofinalguille.service.PokemonService;
import org.example.proyectofinalguille.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;
    @Autowired
    private TipoService tipoService;
    @Autowired
    private PokemonService pokemonService;

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


    //iniciar 3
    public void initialize(){
        cargarPokes();
        actualizarLista();
    }

    //Cargar pokes en el choicebox 4
    private void cargarPokes(){
        List<Pokemon> pokemons = pokemonService.findAll();
        List<String> noms = pokemons.stream().map(Pokemon::getNombre).toList();

        poke1.getItems().clear();
        poke2.getItems().clear();
        poke3.getItems().clear();
        poke4.getItems().clear();
        poke5.getItems().clear();
        poke6.getItems().clear();

        poke1.getItems().addAll(noms);
        poke2.getItems().addAll(noms);
        poke3.getItems().addAll(noms);
        poke4.getItems().addAll(noms);
        poke5.getItems().addAll(noms);
        poke6.getItems().addAll(noms);
    }

    //actualizarlista
    public void actualizarLista(){
        lista.getItems().clear();

        List<Entrenador> entrenadors = entrenadorService.findAll();

        for (Entrenador ent : entrenadors) {
            String pokes = ent.getPokemons()
                    .stream()
                    .map(Pokemon::getNombre)
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("Sin pokémon");

            String item = ent.getId() + " | " + ent.getNombre() + " | " + pokes;

            lista.getItems().add(item);
        }
    }
    //limpiar campos
    public void limpiar(){
        nomEntrenador.clear();
        poke1.setValue(null);
        poke2.setValue(null);
        poke3.setValue(null);
        poke4.setValue(null);
        poke5.setValue(null);
        poke6.setValue(null);
    }

    //Poner datos para modificar
    @FXML
    public void onSelecEntrenador(){
        int index = lista.getSelectionModel().getSelectedIndex();
        if(index <0){
            return;
        }
        String item = lista.getItems().get(index);
        Long id = Long.parseLong(item.split("\\|")[0].trim());
        Entrenador e = entrenadorService.findById(id);

        nomEntrenador.setText(e.getNombre());
        cargarPokes();
        poke1.setValue(null);
        poke2.setValue(null);
        poke3.setValue(null);
        poke4.setValue(null);
        poke5.setValue(null);
        poke6.setValue(null);

        List<Pokemon> pokes = new ArrayList<>(e.getPokemons());
        for(int i = 0; i < pokes.size(); i++){
            String nomPokemon = pokes.get(i).getNombre();
            switch (i){
                case 0:
                    poke1.setValue(nomPokemon);
                    break;
                case 1:
                    poke2.setValue(nomPokemon);
                    break;
                case 2:
                    poke3.setValue(nomPokemon);
                    break;
                case 3:
                    poke4.setValue(nomPokemon);
                    break;
                case 4:
                    poke5.setValue(nomPokemon);
                    break;
                case 5:
                    poke6.setValue(nomPokemon);
                    break;
            }
        }
    }

    //modificar entrenador + poke
    public void modEnt(){
        int index = lista.getSelectionModel().getSelectedIndex();
        if(index < 0){
            return;
        }
        Entrenador e = entrenadorService.findAll().get(index);
        e.setNombre(nomEntrenador.getText());
        e.getPokemons().clear();
        asignarPokemon(e,poke1.getValue());
        asignarPokemon(e,poke2.getValue());
        asignarPokemon(e,poke3.getValue());
        asignarPokemon(e,poke4.getValue());
        asignarPokemon(e,poke5.getValue());
        asignarPokemon(e,poke6.getValue());

        entrenadorService.updateEntrenador(e);
        limpiar();
        actualizarLista();
    }

    private void asignarPokemon(Entrenador entrenador, String nomPokemon){
        if(nomPokemon != null){
            Pokemon pok = pokemonService.findByNombre(nomPokemon);
            if(pok != null){
                entrenador.addPokemon(pok);
                pokemonService.updatePokemon(pok);
            }
        }
    }

    //Añadir entrenador + poke
    @FXML
    protected void onAddEnt() {
        String nombre = nomEntrenador.getText();

        if(nombre.isEmpty()){
            return;
        }

        Entrenador entrenador = entrenadorService.createEntrenador(nombre);
        asignarPokemon(entrenador, poke1.getValue());
        asignarPokemon(entrenador, poke2.getValue());
        asignarPokemon(entrenador, poke3.getValue());
        asignarPokemon(entrenador, poke4.getValue());
        asignarPokemon(entrenador, poke5.getValue());
        asignarPokemon(entrenador, poke6.getValue());

        entrenadorService.updateEntrenador(entrenador);
        limpiar();
        actualizarLista();
    }

    //Eliminar entrenador
    @FXML
    protected void onDelEnt() {
        int indice = lista.getSelectionModel().getSelectedIndex();

        if(indice >= 0){
            Entrenador e = entrenadorService.findAll().get(indice);
            entrenadorService.deleteEntrenador(e.getId());
            limpiar();
            actualizarLista();
        }
    }


    @FXML
    public void onAddPoke(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/proyectofinalguille/Pokemon.fxml"));
        Parent root = loader.load();

        PokemonController controller = loader.getController();
        controller.setServices(tipoService, pokemonService);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Ventana Modal");

        stage.initModality(Modality.APPLICATION_MODAL); // Hace la ventana modal
        stage.initOwner(((Node)event.getSource()).getScene().getWindow()); // La asocia a la ventana principal

        stage.showAndWait(); // Bloquea hasta que se cierre

        cargarPokes();
    }

}