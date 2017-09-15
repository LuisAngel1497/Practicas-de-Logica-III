package matricesll;
/*** @author Luis Angel*/
public class ListaLigada {
    
    private Nodo cab, ult, x;
    Tripleta objInfo = new Tripleta();
    
    public ListaLigada(){ //constructor
        cab = new Nodo(0,0,0); 
        ult = x = cab; 
    } //fin constructor
    
    public void IngresarNuevo(int pfila,int pcolum, double pdato){ //metodo INGRESAR NUEVO EMPLEADO
        Nodo p = new Nodo(pfila,pcolum, pdato);
        ult.AsignaLiga(p); 
        ult = p;
    } //fin metodo INGRESAR NUEVO EMPLEADO
  
    public Tripleta RecorreA(){ // metodo MOSTRAR DATOS DE LA LISTA
        x = x.RetornaLiga();
            if (x == null){ 
                x = cab;
            }
         return x.GetInfo();
    }// fin metodo MOSTRAR DATOS DE LA LISTA
    
    public Tripleta RecorreB(){ // metodo MOSTRAR DATOS DE LA LISTA
        x = x.RetornaLiga();
            if (x == null){ 
                x = cab;
            }
         return x.GetInfo();
    }// fin metodo MOSTRAR DATOS DE LA LISTA
}
