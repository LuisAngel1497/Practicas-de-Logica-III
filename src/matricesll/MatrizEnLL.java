/*
 * Esta clase crea una lista ligada que almacena cada tripleta en un nodo
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
public class MatrizEnLL {
    
    private Nodo cab; 
    private Nodo ult;
    private Nodo x;
    Tripleta objInfo = new Tripleta(0, 0, 0);
    
    public MatrizEnLL(){ //constructor
        cab = new Nodo(objInfo); 
        ult = x = cab; 
    } //fin constructor
    
    public void IngresarNuevo(int pFila,int pColumn, int pDato){ //metodo INGRESAR NUEVO EMPLEADO
        Tripleta t = new Tripleta(pFila, pColumn, pDato);
        Nodo p = new Nodo(t);
        ult.setLiga(p); 
        ult = p;
    } //fin metodo INGRESAR NUEVO EMPLEADO
  
    public Tripleta RecorreA(){ // metodo MOSTRAR DATOS DE LA LISTA
        x = x.getLiga();
            if (x == null){ 
                x = cab;
            }
         return x.getT();
    }// fin metodo MOSTRAR DATOS DE LA LISTA
    
    public Tripleta RecorreB(){ // metodo MOSTRAR DATOS DE LA LISTA
        x = x.getLiga();
            if (x == null){ 
                x = cab;
            }
         return x.getT();
    }// fin metodo MOSTRAR DATOS DE LA LISTA
}
