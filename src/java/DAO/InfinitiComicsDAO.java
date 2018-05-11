/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.*;
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
import java.util.ArrayList;

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
    /*============================================Conectar/Desconectar============================================*/
    public void conectar() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/infinitycomic";
        String user = "root";
        String pass = "";
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, pass);
    }

    /**
     * Funcion para desconectar de la bbdd
     *
     * @throws SQLException
     */
    public void desconectar() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    /*============================================User============================================*/
    private static String[] getUserPassword() {

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
        } finally {
            return sql;
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

    public void insertarCash(User u, Integer dinero) throws SQLException, ClassNotFoundException {
        this.conectar();
        String query = "UPDATE user SET cash = cash+" + dinero + " where username ='" + u.getUsername() + "'";
        Statement st = connection.createStatement();
        st.executeUpdate(query);

        this.desconectar();
    }

    public void updateProfile(User u) throws SQLException, ClassNotFoundException {
        this.conectar();
        String query = "UPDATE user SET nombre = " + u.getNombre() + ", password ='" + u.getPassword() + "', ciudad ='" + u.getCiudad() + "', tipo ='" + u.getTipo() + "'";
        Statement st = connection.createStatement();
        st.executeUpdate(query);

        this.desconectar();
    }

    /*============================================Coleccion============================================*/
    public void insertColeccion(Coleccion c) throws SQLException, InfinityException, ClassNotFoundException {
        this.conectar();

        String query = "INSERT INTO coleccion VALUES (null,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, c.getName());
        ps.setString(2, c.getEditorial());
        ps.setString(3, c.getType());

        ps.executeUpdate();
        this.desconectar();
    }

    public void BorrarComic(Coleccion c) throws SQLException, ClassNotFoundException, InfinityException {
        this.conectar();
        if (existeColeccion(c)) {
            String query = "DELETE FROM coleccion WHERE id='" + c.getId() + "'";
            Statement st = connection.createStatement();
            st.executeUpdate(query);
        } else {
            this.desconectar();
            throw new InfinityException(11);
        }

        this.desconectar();
    }

    public boolean existeColeccion(Coleccion c) throws SQLException {
        String query = "SELECT * FROM coleccion WHERE id='" + c.getId() + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            rs.close();
            return true;
        }
        rs.close();
        return false;
    }

    /*============================================Comic============================================*/
    public void insertComic(Comic c) throws SQLException, InfinityException, ClassNotFoundException {
        this.conectar();
        //mirar si existe comic
        if (existeComic(c)) {
            this.desconectar();
            throw new InfinityException(10);
        }
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

    public void BorrarComic(Comic c) throws SQLException, ClassNotFoundException, InfinityException {
        this.conectar();
        if (existeComic(c)) {
            String query = "DELETE FROM comic WHERE id='" + c.getId() + "'";
            Statement st = connection.createStatement();
            st.executeUpdate(query);
        } else {
            this.desconectar();
            throw new InfinityException(11);
        }

        this.desconectar();

    }

    public boolean existeComic(Comic c) throws SQLException {
        String query = "SELECT * FROM comic WHERE number='" + c.getNumber() + "' and id_coleccion= '" + c.getColeccion().getId() + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            rs.close();
            return true;
        }
        rs.close();
        return false;
    }

    /*============================================Secundarias============================================*/
    public void InsertarComicInventario(User u, Comic c, Integer cantidad) throws SQLException, ClassNotFoundException {
        this.conectar();

        String query = "INSERT INTO inventario (null,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, c.getId());
        ps.setString(2, u.getUsername());
        ps.setInt(3, cantidad);

        ps.executeUpdate();
        this.desconectar();

    }

    public boolean tenerComic(Comic c, User u) throws SQLException {
        String query = "SELECT * FROM inventario WHERE id_comic='" + c.getId() + "' and username = '" + u.getUsername() + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            rs.close();
            return true;
        }
        rs.close();
        return false;
    }

    public ArrayList<User> tiendasByCiudad(String ciudad) throws SQLException {
        ArrayList<User> lista = new ArrayList<>();
        String query = "SELECT * FROM user WHERE ciudad='" + ciudad + "' and tipo='tienda'";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);
        if (rs.next()) {
            while (rs.next()) {
                User u = new User();
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setCash(rs.getDouble("cash"));
                u.setCiudad(rs.getString("ciudad"));
                u.setTipo(rs.getString("tipo"));
                lista.add(u);
            }
            return lista;
        }
        return lista;
    }

    public ArrayList<Comic> comicsByTienda(String username) throws SQLException {
        ArrayList<Comic> lista = new ArrayList<>();
        String query = "SELECT * FROM inventario WHERE username='" + username + "'";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);
        if (rs.next()) {
            while (rs.next()) {
                Comic c = new Comic();
                c.setId(rs.getInt("id"));
                c.setTitle(rs.getString("titulo"));
                c.setPrecio(rs.getInt("precio"));
                c.setUrlImg(rs.getString("urlImg"));
                c.setAutor(rs.getString("Autor"));
                c.setColeccion((Coleccion) rs.getObject("id_coleccion"));
                lista.add(c);
            }
            return lista;
        }
        return lista;
    }

    public void comprarComic(Comic c, User user, User tienda, Integer cantidad) throws SQLException, ClassNotFoundException, InfinityException {
        this.conectar();
        connection.setAutoCommit(false);
        try {
            int totalprecio = (int) (user.getCash() - c.getPrecio());
            if (totalprecio >= 0) {
                if (tenerComic(c, user)) {
                    //Tiene el comic
                    String query1 = "UPDATE user SET cash = cash - " + c.getPrecio() + " where username = '" + user.getUsername() + "'";
                    String query2 = "UPDATE user SET cash = cash + " + c.getPrecio() + " where username = '" + tienda.getUsername() + "'";
                    String query3 = "UPDATE Inventario SET cantidad = - " + c.getPrecio() + " where username = '" + tienda.getUsername() + "' and id_comic= '" + c.getId() + "'";
                    String query4 = "UPDATE Inventario SET cantidad = + " + c.getPrecio() + " where username = '" + user.getUsername() + "' and id_comic= '" + c.getId() + "'";

                    Statement st = connection.createStatement();
                    st.executeUpdate(query1);
                    st.executeUpdate(query2);
                    st.executeUpdate(query3);
                    st.executeUpdate(query4);
                } else {
                    //no tiene el comic
                    String query1 = "UPDATE user SET cash = cash - " + c.getPrecio() + " where username = '" + user.getUsername() + "'";
                    String query2 = "UPDATE user SET cash = cash + " + c.getPrecio() + " where username = '" + tienda.getUsername() + "'";
                    String query3 = "UPDATE Inventario SET cantidad = - " + c.getPrecio() + " where username = '" + tienda.getUsername() + "' and id_comic= '" + c.getId() + "'";
                    String query4 = "INSERT INTO Inventario VALUES (null,?,?,?)";

                    Statement st = connection.createStatement();
                    st.executeUpdate(query1);
                    st.executeUpdate(query2);
                    st.executeUpdate(query3);
                    PreparedStatement ps2 = connection.prepareStatement(query4);

                    ps2.setInt(1, c.getId());
                    ps2.setString(2, user.getUsername());
                    ps2.setInt(3, cantidad);
                    ps2.executeUpdate();
                }
            } else {
                throw new InfinityException(0);
            }

        } finally {
            connection.setAutoCommit(true);
            this.desconectar();
        }

    }

}
