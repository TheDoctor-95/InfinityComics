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
    private int number;
    private double precio;
    private String urlImg;
    private String Autor;
    private Coleccion coleccion;
    public Comic() {
    }

    public Comic(int id) {
        this.id = id;
    }
    
    public Comic(int id, String title, int number, double precio, String urlImg, String Autor, Coleccion coleccion) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.precio = precio;
        this.urlImg = urlImg;
        this.Autor = Autor;
        this.coleccion = coleccion;
    }

    public Coleccion getColeccion() {
        return coleccion;
    }

    public void setColeccion(Coleccion coleccion) {
        this.coleccion = coleccion;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int numbre) {
        this.number = numbre;
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
    
    @Override
    public String toString() {
        return "Comic{" + "id=" + id + ", title=" + title + ", number=" + number + ", precio=" + precio + ", urlImg=" + urlImg + ", Autor=" + Autor + ", coleccion=" + coleccion + '}';
    }
}
