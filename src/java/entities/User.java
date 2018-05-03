/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;

/**
 *
 * @author daw2m
 */
public class User {
    private String nombre;
    private String username;
    private String passwoed;
    private double cash;
    private String city;
    private String type;
    
    private List<Inventory> inventario;
    private List<Coleccion> following;

    public User() {
    }

    public User(String username, String passwoed, double cash, String city, String type, List<Inventory> inventario, List<Coleccion> following) {
        this.username = username;
        this.passwoed = passwoed;
        this.cash = cash;
        this.city = city;
        this.type = type;
        this.inventario = inventario;
        this.following = following;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswoed() {
        return passwoed;
    }

    public void setPasswoed(String passwoed) {
        this.passwoed = passwoed;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Inventory> getInventario() {
        return inventario;
    }

    public void setInventario(List<Inventory> inventario) {
        this.inventario = inventario;
    }

    public List<Coleccion> getFollowing() {
        return following;
    }

    public void setFollowing(List<Coleccion> following) {
        this.following = following;
    }
    
    
    
}
