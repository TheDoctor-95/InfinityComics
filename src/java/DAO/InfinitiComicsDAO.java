/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.*;
import exeption.InfinityException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author daw2m
 */
public class InfinitiComicsDAO {

    public static Connection connection;

    public static String user="root";
    public static String pass="";
    /**
     * Funcion para conectar a la bbdd
     *
     * @throws SQLException
     */
    public void conectar() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/infinitycomic";
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, pass);
    }

    /**
     * Funcion para desconectar de la bbdd
     *
     * @throws SQLException
     */
    private void desconectar() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    

    public void insertUser(User u) throws SQLException, InfinityException, ClassNotFoundException {
        this.conectar();
        if (existUser(u.getUsername())) {
            throw new InfinityException(0);
        }

        String query = "INSERT INTO user VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, u.getNombre());
        ps.setString(2, u.getUsername());
        ps.setString(3, u.getPassword());
        ps.setDouble(4, u.getCash());
        ps.setString(5, u.getCiudad());
        ps.setString(6, u.getTipo());

        ps.executeUpdate();
        this.desconectar();
    }

    public User getUser(String username) throws SQLException, ClassNotFoundException {
        this.conectar();
        String query = "SELECT * FROM user WHERE username='" + username + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        User u = new User();
        if (rs.next()) {
            u.setUsername(rs.getString("username"));
            u.setNombre(rs.getString("nombre"));
            u.setPassword(rs.getString("password"));
            u.setCash(rs.getDouble("cash"));
            u.setCiudad(rs.getString("ciudad"));
            u.setTipo(rs.getString("tipo"));
        }

        this.desconectar();
        return u;
    }

    private boolean existUser(String username) throws SQLException {
        String query = "SELECT * FROM user WHERE username='" + username + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            rs.close();
            return true;
        }
        rs.close();
        return false;
    }

    public boolean valUser(String username, String password) throws SQLException, ClassNotFoundException {
        this.conectar();
        String query = "SELECT * FROM user WHERE username=? AND password = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();
        boolean is = false;
        if (rs.next()) {
            is = true;
        }
        rs.close();
        this.desconectar();
        return is;

    }

    public void insertColeccion(Coleccion c) throws SQLException, InfinityException, ClassNotFoundException{
        this.conectar();
        
        
        String query = "INSERT INTO user VALUES (null,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        
        ps.setString(1, c.getName());
        ps.setString(2, c.getEditorial());
        ps.setString(3, c.getType());
        
        
        ps.executeUpdate();
        this.desconectar();
    }
    
    public void insertComic(Comic c) throws SQLException, InfinityException, ClassNotFoundException{
        this.conectar();
        
        
        String query = "INSERT INTO user VALUES (null,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        
        ps.setString(1, c.getTitle());
        ps.setInt(2, c.getNumber());
        ps.setDouble(3, c.getPrecio());
        ps.setString(4, c.getUrlImg());
        ps.setString(5, c.getAutor());
        ps.setInt(6, c.getColeccion().getId());
        
        
        ps.executeUpdate();
        this.desconectar();
    }
    
}
