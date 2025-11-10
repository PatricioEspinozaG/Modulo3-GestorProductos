package controlador;

import java.util.ArrayList;
import modelo.Usuario;

public class ControladorUsuarios {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private int contadorId = 1;

    public ControladorUsuarios() {
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String agregarUsuario(String nombre, String email) {
        String error = validar(nombre,email);
        if(error != null){
            return error;
        }
        
        Usuario usuario = new Usuario(contadorId++,nombre, email);
        usuarios.add(usuario);
        return "Usuario agregado correctamente.";
    }   

    public String validar(String nombre, String email) {
        if (nombre.trim().isEmpty()) {
            return "El nombre no puede estar vacio.";
        }
        if (email.trim().isEmpty()) {
            return "El email no puede estar vacio.";
        }

        if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            return "El formato del email no es valido.";
        }
        if (existeEmail(email)){
            return "El email ya esta registrado."; 
        }
        
        return null;
    }
    
    public boolean existeEmail(String email){
        for (Usuario u : usuarios) {
            if(u.getEmail().equalsIgnoreCase(email)){
                return true;
            }            
        }
        return false;
    }
    
    public String obtenerUsuarios(String emailTexto) {
        for (Usuario u : usuarios) {
            if(u.getEmail().equalsIgnoreCase(emailTexto)){
                return u.mostrarInfo();
            }            
        }
        return "Usuario no encontrado.";
    }
    

    public String editarUsuario(int id, String nuevoNombre, String nuevoEmail){
        for (Usuario u : usuarios) {
            if(u.getId() == id){
                u.setId(id);
                u.setNombre(nuevoNombre);
                u.setEmail(nuevoEmail);
                return "Usuario editado correctamente.";
            }
        }
        return "Usuario no encontrado.";
    }
    
    public boolean buscarUsuarioPorId(int id){
        for (Usuario u : usuarios) {
            if(u.getId() == id){
                return true;
            }
        }
        return false;
    }
    
    
    public String borrarUsuario(int id){
        for (Usuario u : usuarios) {
            if(u.getId() == id){
                usuarios.remove(id);
                return "Uusario eliminado correctamente";
            }
            
        }
        return "Usuario no encontrado.";
    }
    
         
    
    
    
}
