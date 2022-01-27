package proyectoArboles.guiatelefonica;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yeri
 */
public class Persona {
    String telefono;
    String nombres;
    String apellidos;
    
    public Persona(String telefono, String nombres, String apellidos){
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
    
    
}
