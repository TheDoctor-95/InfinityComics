/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.User;
import exeption.InfinityException;
import java.sql.PreparedStatement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    /**
     * Funcion para conectar a la bbdd
     *
     * @throws SQLException
     */
    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/infinitycomic";
        String user = "root";
        String pass = "";
        connection = DriverManager.getConnection(url, user, pass);
    }

    /**
     * Funcion para desconectar de la bbdd
     *
     * @throws SQLException
     */
    public void descoectar() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static String[] getUserPassword() {

        String rutaActual = System.getProperty("user.dir") + File.separator + "src" + File.separator + "enunciado" + File.separator + "sql.txt";
        File f = new File(rutaActual);
        String[] sql = new String[2];
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            int lineNum = 0;
            while (line != null) {
                if (lineNum < 2) {
                    sql[lineNum] = line;
                    lineNum++;
                }
                line = br.readLine();
            }

        } catch (FileNotFoundException ex) {
            sql[0] = "root";
            sql[1] = "";
        } catch (IOException ex) {
            sql[0] = "root";
            sql[1] = "";
        }finally{
            return sql;
        }
    }
    
    public void insertUser(User u) throws SQLException, InfinityException{
        
        if(existUser(u.getUsername())){
            throw new InfinityException(0);
        }
        
        String query = "INSERT INTO user VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getUsername());
        ps.setString(3, u.getPassword());
        ps.setDouble(4, u.getCash());
        ps.setString(5, u.getCity());
        ps.setString(6, u.getType());
        
        ps.executeUpdate();
    }
    
    public User getUser(String username) throws SQLException{
        String query = "SELECT * FROM user WHERE username='"+username+"'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        User u= new User();;
        if(rs.next()){
            u.setUsername(rs.getString("username"));
            u.setNombre(rs.getString("nombre"));
            u.setPasswoed(rs.getString("password"));
            u.setCash(rs.getDouble("cash"));
            u.setCity(rs.getString("city"));
            u.setType(rs.getString("type"));
        }
        return u;
    }
    
     public boolean existUser(String username) throws SQLException{
        String query = "SELECT * FROM user WHERE username='"+username+"'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(rs.next()){
            return true;
        }
        return false;
    }
    
    public boolean valUser(String username, String password) throws SQLException{
        String query = "SELECT * FROM user WHERE username=? AND password = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        
        ps.setString(1, username);
        ps.setString(2, password);
        
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()) return true;
        return false;
            
    }
    
}
