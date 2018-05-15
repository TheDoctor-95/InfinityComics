/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author daw2m
 */
public class Inventory {
    
    private int cantidad;
    private Comic comic;

    public Inventory(int cantidad, Comic comic) {
        this.cantidad = cantidad;
        this.comic = comic;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }
    
    
    
}
