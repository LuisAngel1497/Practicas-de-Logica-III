/*
 * Esta clase 
 */
package matricesll;

/**
 *
 * @author Felipe Cadavid
 * @author Carolina Diaz
 * @author Luis Angel Vanegas
 * @version 14-09-2017
 * 
 */
public class Tripleta {
    
    private int columna;
    private int fila;
    private int dato;

    public Tripleta(int columna, int fila, int dato) {
        this.columna = columna;
        this.fila = fila;
        this.dato = dato;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
    
    


    
}