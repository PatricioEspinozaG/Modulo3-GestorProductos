/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Producto;
import bd.conexion;
import java.sql.Connection;
import java.sql.*;
import java.util.*;


/**
 *
 * @author patoe
 */
public class ControladorProductos {
    //crud de basedatos
    
    public ControladorProductos(){
    }

    public boolean agregar(Producto prod) {
        try{
            conexion con = new conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "INSERT INTO producto(id,nombre,stock,precio) VALUES(?,?,?,?);";
            java.sql.PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, prod.getId());
            stmt.setString(2, prod.getNombre());
            stmt.setInt(3, prod.getStock());
            stmt.setDouble(4, prod.getStock());
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
            
            
        }
        catch (SQLException e){
            System.out.println("Error al consultar para insertar datos"+e.getMessage());
            return false;
        }
    }
    
            
            
}
