package matricesll;
/*** @author Luis Angel*/
public class ListaLigada {
    
    private Nodo cab, ult, x;
    Info objInfo = new Info();
    
    public ListaLigada(){ //constructor
        cab = new Nodo(0,0,0); 
        ult = x = cab; 
    } //fin constructor
    
    public void IngresarNuevo(int pfila,int pcolum, double pdato){ //metodo INGRESAR NUEVO EMPLEADO
        Nodo p = new Nodo(pfila,pcolum, pdato);
        ult.AsignaLiga(p); 
        ult = p;
    } //fin metodo INGRESAR NUEVO EMPLEADO
  
    public Info RecorreA(){ // metodo MOSTRAR DATOS DE LA LISTA
        x = x.RetornaLiga();
            if (x == null){ 
                x = cab;
            }
         return x.GetInfo();
    }// fin metodo MOSTRAR DATOS DE LA LISTA
    
    public Info RecorreB(){ // metodo MOSTRAR DATOS DE LA LISTA
        x = x.RetornaLiga();
            if (x == null){ 
                x = cab;
            }
         return x.GetInfo();
    }// fin metodo MOSTRAR DATOS DE LA LISTA
}
