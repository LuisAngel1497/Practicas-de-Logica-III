package matricesll;
import java.util.Scanner;
/*** @author Luis Angel*/
public class Principal {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lector =  new Scanner(System.in);
        
        ListaLigada objmatrizA = new ListaLigada();
        ListaLigada objmatrizB = new ListaLigada();
        OpMatrices objOp = new OpMatrices();
        
        int numfA, numcA, numfB, numcB ;
        float dato;
        
        
        //bloque de codigo para el ingreso de la matriz A  y su dimension 
        System.out.println("Digite el número de filas de la matriz A");
        numfA = lector.nextInt();
        System.out.println("Digite el número de columnas de la matriz A");
        numcA = lector.nextInt();
        
        for(int fila = 1; fila <= numfA ;fila = fila+1 ){
            for(int colum = 1; colum <= numcA ;colum = colum+1 ){
                 System.out.println("Digite el valor del elemento A "+fila+ " - " +colum);
                 dato = lector.nextFloat();
                 if (dato != 0){
                     objmatrizA.IngresarNuevo(fila,colum, dato);
                 }
            }
        }
        //fin bloque de codigo para el ingreso de la matriz A  y su dimension 
        
        //bloque de codigo para el ingreso de la matriz B  y su dimension 
        System.out.println("Digite el número de filas de la matriz B");
        numfB = lector.nextInt();
        System.out.println("Digite el número de columnas de la matriz B");
        numcB = lector.nextInt();
        
        for(int fila = 1; fila <= numfB ;fila = fila+1 ){
            for(int colum = 1; colum <= numcB ;colum = colum+1 ){
                 System.out.println("Digite el valor del elemento B "+fila+ " - " +colum);
                 dato = lector.nextFloat();
                 if (dato != 0){
                     objmatrizB.IngresarNuevo(fila,colum, dato);
                 }
            }
        }
        //fin bloque de codigo para el ingreso de la matriz B  y su dimension 
        
        
        //bloque de codigo para realizar la multiplicacion
        if(numcA==numfB){//si el numero de columnas de la matriz A es igual al numero de filas de la matriz B, entonces
           objmatrizA = objOp.Multiplicacion(numfA, numcA, numcB, objmatrizA, objmatrizB);//la matriz A aerá igual a la multiplicacion entre la matriz A ingresada y la matriz B
        }else{
            System.out.println("NO SE PUEDE MULTIPLICAR");
        }
        //fin bloque de codigo para realizar la multiplicacion


        //mostrar resultado de la multiplicacion
        Tripleta info = objmatrizA.RecorreA();
        while (info.dato != 0 ){ //recorrerá toda la lista ligada de A 
            System.out.println("fila:    "+info.fila);
            System.out.println("columna: "+info.colum);
            System.out.println("dato:    "+info.dato);
            System.out.println("-----------------------");
            info = objmatrizA.RecorreA();
        }
        System.out.println("*****************************************************************************");
        
        
        //bloque de codigo para hallar el det de la matriz A
        double det = objOp.determinate(numfA, numcA, objmatrizA);
        if (det==0) {//si el determinante es cero entonces
            System.out.println("NO EXISTE INVERSA DE LA MATRIZ"); 
            System.exit(0);//termina la ejecucion
        }
        //fin bloque de codigo para hallar el det de la matriz A
        
        
        //linea de codigo para hallar la adjunta
        ListaLigada  objmatrizAdj = objOp.Adjunta(numfA, numcA, objmatrizA);
  

        //bloque de codigo para hallar la inversa
        ListaLigada objmatrizInv = new ListaLigada();
        Tripleta infoAdj = new Tripleta();
        System.out.println("la inversa de la matriz A es:");
        
        infoAdj = objmatrizAdj.RecorreA();
        while (infoAdj.dato != 0 ){ //recorrerá toda la lista ligada de la matriz adjunta
            objmatrizInv.IngresarNuevo(infoAdj.fila, infoAdj.colum, (infoAdj.dato/det));//en la lista ligada (_objmatrizInv) se almacena en su respectiva fila y columna correspondiente a la matriz adjunta
            //el dato de la matriz adjunta, dividido entre el det
            infoAdj = objmatrizAdj.RecorreA();
        }            
        //fin bloque de codigo para hallar la inversa
        
        //mostrar resultado de la inversa
        Tripleta info2 = objmatrizInv.RecorreA();
        while (info2.dato != 0 ){ //recorrerá toda la lista ligada de A 
            System.out.println("fila:    "+info2.fila);
            System.out.println("columna: "+info2.colum);
            System.out.println("dato:    "+info2.dato);
            System.out.println("-----------------------");
            info2 = objmatrizInv.RecorreA();
        }
        System.out.println("*****************************************************************************");
        
    }
}
