/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        String url = "jdbc:mysql://localhost:3306/InfinityComics";
        String user = getUserPassword()[0];
        String pass = getUserPassword()[1];
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
}
