package matriz_dispersa_LL_forma2;
/*** @author Luis Angel */
public class Nodo {
    
     //siendo [0]ID, [1] nombre, [2] sexo, [3]salario
     private Info objInfo = new Info();
     private Nodo liga; //atributos
  
    public Nodo (int pfila, int pcolum, double pdato  ){//constructor
        objInfo.colum = pcolum;
        objInfo.fila = pfila;
        objInfo.dato= pdato;
        liga = null;
    } //fin constructor
    
    public Info GetInfo (){ //metodo get
         return objInfo;
    } //fin metodo get
    
    public void AsignaLiga(Nodo pLiga){ //metodo ASIGNAR LIGA
        liga = pLiga;
    } //fin metodo ASIGNAR LIGA
    
    public Nodo RetornaLiga(){ //metodo RETORNAR LIGA
        return liga; 
    } //fin metodo RETORNAR LIGA 
}
