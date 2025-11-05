package controlador;

import java.util.ArrayList;
import modelo.Usuario;

public class ManejarUsuario {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private int contadorId = 1;

    public ManejarUsuario() {
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

        if (email.matches("\"^[\\\\w._%+-]+@[\\\\w.-]+\\\\.[a-zA-Z]{2,6}$\"")) {
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
        
    public String obtenerUsuarios() {
        StringBuilder sb = new StringBuilder();
        for (Usuario usuario : usuarios) {
            sb.append(usuario.mostrarInfo()).append("\n");

        }
        return sb.toString();
    }

}
