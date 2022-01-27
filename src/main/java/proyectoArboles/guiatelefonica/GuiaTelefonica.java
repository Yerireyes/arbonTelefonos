package proyectoArboles.guiatelefonica;
import java.util.List;

import proyectoArboles.arboles.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yeri
 */
public class GuiaTelefonica {
    IArbolBusqueda<String,Persona> arbolBinario;
    
    public GuiaTelefonica(byte tipoDeArbol){
        switch(tipoDeArbol){
            case 0 :
                this.arbolBinario = new ArbolBinarioBusqueda();
                break;
            case 1 :
                 this.arbolBinario = new AVL();
                 break;
            case 2 :
                 this.arbolBinario = new ArbolMViasBusqueda();
                 break;
        }
        this.cargarguia();
    }

    public void cargarguia(){
        Persona persona1 = new Persona("1111", "Luis Erik", "Reyes Soleto");
        Persona persona2 = new Persona("1112", "Cecilia", "Justiniano Pessoa");
        Persona persona3 = new Persona("1113", "Catherine Denis", "Gomez Quispe");
        Persona persona4 = new Persona("1114", "Mauricio", "Sauza");
        Persona persona5 = new Persona("1115", "Ibai", "Llanos");
        Persona persona6 = new Persona("1116", "David", "Canovas");
        Persona persona7 = new Persona("1117", "Renato", "Alvarez");
        Persona persona8 = new Persona("1118", "Raul", "Buhajerok");
        Persona persona9 = new Persona("1119", "Tomas", "Arbillaga");
        Persona persona10 = new Persona("1121", "Guillermo", "Diaz");
        this.arbolBinario.insertar(persona1.getApellidos() + " " + persona1.getNombres(), persona1);
        this.arbolBinario.insertar(persona2.getApellidos() + " " + persona2.getNombres(), persona2);
        this.arbolBinario.insertar(persona3.getApellidos() + " " + persona3.getNombres() , persona3);
        this.arbolBinario.insertar(persona4.getApellidos() + " " + persona4.getNombres(), persona4);
        this.arbolBinario.insertar(persona5.getApellidos() + " " + persona5.getNombres(), persona5);
        this.arbolBinario.insertar(persona6.getApellidos() + " " + persona6.getNombres(), persona6);
        this.arbolBinario.insertar(persona7.getApellidos() + " " + persona7.getNombres(), persona7);
        this.arbolBinario.insertar(persona8.getApellidos() + " " + persona8.getNombres(), persona8);
        this.arbolBinario.insertar(persona9.getApellidos() + " " + persona9.getNombres(), persona9);
        this.arbolBinario.insertar(persona10.getApellidos() + " " + persona10.getNombres(), persona10);
    }
    
    public void insertarPersona(String telefono, String nombres, String apellidos){
        Persona persona = new Persona(telefono, nombres, apellidos);
        arbolBinario.insertar(apellidos + " " + nombres, persona);
    }
    
    public void eliminarPersona(String apellidos) throws ExcepcionClaveNoExiste{
        arbolBinario.eliminar(apellidos);
    }
    
    public Persona buscarPersona(String apellidos){
        return arbolBinario.buscar(apellidos);
    }
    
    public int size(){
        return this.arbolBinario.size();
    }

    public List<String> listaDePersonas(){
        return this.arbolBinario.recorridoEnInOrden();
    }
}
