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
public class Comic {
    private int id;
    private String title;
    private int numbre;
    private double precio;
    private String urlImg;
    private String Autor;
    
    public Comic() {
    }

    public Comic(int id, String title, int numbre, double precio, String urlImg, String Autor, Coleccion coleccion) {
        this.id = id;
        this.title = title;
        this.numbre = numbre;
        this.precio = precio;
        this.urlImg = urlImg;
        this.Autor = Autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumbre() {
        return numbre;
    }

    public void setNumbre(int numbre) {
        this.numbre = numbre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }
    
}
