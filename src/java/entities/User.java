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
    private String password;
    private double cash;
    private String ciudad;
    private String tipo;
    
    private List<Inventory> inventario;
    private List<Coleccion> following;

    public User(String nombre, String username, String password, double cash, String city, String type) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.cash = cash;
        this.ciudad = city;
        this.tipo = type;
    }

    public User() {
    }

    public User(String username, String password, double cash, String ciudad, String tipo, List<Inventory> inventario, List<Coleccion> following) {
        this.username = username;
        this.password = password;
        this.cash = cash;
        this.ciudad = ciudad;
        this.tipo = tipo;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return "User{" + "nombre=" + nombre + ", username=" + username + ", password=" + password + ", cash=" + cash + ", ciudad=" + ciudad + ", tipo=" + tipo + ", inventario=" + inventario + ", following=" + following + '}';
    }
    
    
    
    
}
