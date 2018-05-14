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
public class Coleccion {
    private int id;
    private String name;
    private String editorial;
    private String type;
    public Coleccion() {
    }

    public Coleccion(int id) {
        this.id = id;
    }
    
    public Coleccion(String name, String editorial, String type) {
        this.name = name;
        this.editorial = editorial;
        this.type = type;
    }
    
    public Coleccion(int id, String name, String editorial, String type) {
        this.id = id;
        this.name = name;
        this.editorial = editorial;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
 
}
