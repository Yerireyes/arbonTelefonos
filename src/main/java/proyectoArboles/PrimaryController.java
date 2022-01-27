package proyectoArboles;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import proyectoArboles.guiatelefonica.GuiaTelefonica;

public class PrimaryController {
    GuiaTelefonica guiaTelefonica;
    
    @FXML
    private void switchToArbolBinarioBusqueda(ActionEvent actionEvent) throws IOException {
        guiaTelefonica = new GuiaTelefonica((byte)0);
        irAVista(actionEvent);
    }

    @FXML
    private void switchToArbolAVL(ActionEvent actionEvent) throws IOException {
        guiaTelefonica = new GuiaTelefonica((byte)1);
        irAVista(actionEvent);
    }

    @FXML
    private void switchToArbolMviasBusqueda(ActionEvent actionEvent) throws IOException {
        guiaTelefonica = new GuiaTelefonica((byte)2);
        irAVista(actionEvent);
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
