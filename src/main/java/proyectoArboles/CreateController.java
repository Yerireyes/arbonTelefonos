package proyectoArboles;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proyectoArboles.guiatelefonica.GuiaTelefonica;
public class CreateController {
    GuiaTelefonica guiaTelefonica;
    @FXML
    TextField apellidos;
    @FXML
    TextField nombres;
    @FXML
    TextField telefono;
    @FXML
    private void create(ActionEvent actionEvent) throws IOException {
        guiaTelefonica.insertarPersona(telefono.getText(), nombres.getText(), apellidos.getText()); 
        irAVista(actionEvent);
    }

    public void cargarGuia(GuiaTelefonica guiaTelefonica2) {
        this.guiaTelefonica = guiaTelefonica2;
    }

    public void irAVista(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("secondary.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        //Carga el controlador de la nueva escena
        SecondaryController secondaryController = loader.getController();
        secondaryController.cargarGuia(this.guiaTelefonica);

        //Se obtienen los datos del Escenario
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
    }
}
