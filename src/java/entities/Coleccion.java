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
    private List<Comic> comics;

    public Coleccion() {
    }

    public Coleccion(int id, String name, String editorial, String type, List<Comic> comics) {
        this.id = id;
        this.name = name;
        this.editorial = editorial;
        this.type = type;
        this.comics = comics;
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

    public List<Comic> getComics() {
        return comics;
    }

    public void setComics(List<Comic> comics) {
        this.comics = comics;
    }
    
    
    
}
