module proyectoArboles {
    requires javafx.controls;
    requires javafx.fxml;

    opens proyectoArboles to javafx.fxml;
    exports proyectoArboles;
}
