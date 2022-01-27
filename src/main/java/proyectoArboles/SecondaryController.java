package proyectoArboles;

import java.io.IOException;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.stage.Stage;
import proyectoArboles.arboles.ExcepcionClaveNoExiste;
import proyectoArboles.guiatelefonica.GuiaTelefonica;
import proyectoArboles.guiatelefonica.Persona;

public class SecondaryController {
    GuiaTelefonica guiaTelefonica;
    Persona personaActual;
    String[] personas;

    @FXML
    ListView listaDePersonas;
    @FXML
    Label labelDatos;
    @FXML
    Label labelDatosRellenados;
    @FXML
    TextField nombreCompleto;
    
    @FXML
    private void eliminar() throws IOException, ExcepcionClaveNoExiste {
        guiaTelefonica.eliminarPersona(personaActual.getApellidos() + " " + personaActual.getNombres());
        this.cargarGuia(guiaTelefonica);
    }

    @FXML
    private void crear(ActionEvent actionEvent) throws IOException{
        irAVista(actionEvent);
    }

    @FXML
    private void buscar() throws IOException{
        Persona personaABuscar = guiaTelefonica.buscarPersona(nombreCompleto.getText());
        if (personaABuscar != null) {
            personaActual = personaABuscar;
            labelDatosRellenados.setText(personaActual.getApellidos() + "\n" + personaActual.getNombres() + "\n" + personaActual.getTelefono());
        }
    }

    @FXML
    private void volver(ActionEvent actionEvent) throws IOException {
        volverAVistaPrincipal(actionEvent);
    }

    private void volverAVistaPrincipal(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("primary.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        //Carga el controlador de la nueva escena
        PrimaryController primaryController = loader.getController();

        //Se obtienen los datos del Escenario
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
    }

    public void cargarGuia(GuiaTelefonica guiaTelefonica){
        listaDePersonas.getItems().clear();
        this.guiaTelefonica = guiaTelefonica;
        personas = new String[guiaTelefonica.size()];
        List<String> listaDeApellidos = guiaTelefonica.listaDePersonas();
        for (int i = 0; i < listaDeApellidos.size(); i++) {
            Persona personaAInsertar = guiaTelefonica.buscarPersona(listaDeApellidos.get(i));
            personas[i] = personaAInsertar.getApellidos() + " " + personaAInsertar.getNombres();
        }
        listaDePersonas.getItems().addAll(personas);
        labelDatos.setText("Apellidos:\nNombres:\nTelefono:");
        personaActual = guiaTelefonica.buscarPersona(listaDeApellidos.get(0));
        labelDatosRellenados.setText(personaActual.getApellidos() + "\n" + personaActual.getNombres() + "\n" + personaActual.getTelefono());
        listaDePersonas.getSelectionModel().selectedItemProperty().addListener(new ListaDePersonasListener());;
    }

    private final class ListaDePersonasListener implements ChangeListener<String>{

        @Override
        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
             int personaSeleccionada = listaDePersonas.getSelectionModel().getSelectedIndex();
             personaActual = guiaTelefonica.buscarPersona(personas[personaSeleccionada]);
             labelDatosRellenados.setText(personaActual.getApellidos()+"\n"+personaActual.getNombres() + "\n" + personaActual.getTelefono());          
        }
    }

    public void irAVista(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("create.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        //Carga el controlador de la nueva escena
        CreateController createController = loader.getController();
        createController.cargarGuia(this.guiaTelefonica);

        //Se obtienen los datos del Escenario
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
    }
}