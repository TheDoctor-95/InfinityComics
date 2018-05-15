/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exeption;

/**
 *
 * @author daw2m
 */
public class InfinityException extends Exception {

    private int code;

    public InfinityException(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        switch (this.code) {
            //Errores USER
            case 0:
                return "El usuario ya existe";
            case 1:
                return "El usuairo no tiene suficiente dinero";
            //ERRORES COMICS
            case 10:
                return "El comic ya existe";
            case 11:
                return "El comic no existe";
            //ERRORES COLECCION
            case 20:
                return "La colleccion ja existe";
            //ERRORES INVENTARIO
            case 30:
                return "La tienda no le quedan ejemplares de este tomo";
            //ERROES FOLLOW
            case 40:
                return "";
            default:
                return "CODE " + this.code + " ERROR UNKNOWN";
        }
    }

}
