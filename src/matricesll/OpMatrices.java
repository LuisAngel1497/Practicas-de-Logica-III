/*
 * Esta clase organiza las operaciones 
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
public class OpMatrices {

     //metodo para multiplicar A * B      
    public MatrizEnLL Multiplicacion (int numfA, int numcA, int numcB, MatrizEnLL objmatrizA, MatrizEnLL objmatrizB){
        
        MatrizEnLL objmatrizC = new MatrizEnLL();
        
        Tripleta infoA;
        Tripleta infoB;
        
         for(int filaa = 1; filaa <= numfA ;filaa = filaa+1 ){ //recorrera todas las filas de A
                for(int columb = 1; columb<= numcB ;columb = columb+1 ){//recorrera todas las columnas de B
                    int valor =0;                    
                    for(int k = 1; k<= numcA ;k = k+1 ){//recorrera las columnas de A
                        
                        infoA = objmatrizA.RecorreA();
                        while (infoA.getDato() != 0 ){//recorre toda la lista ligada de la matrizA
                            
                            
                            if (infoA.getColumna() == k && infoA.getFila() == filaa){// si hay una columna y fila igual a la indicada entonces
                                //tiene valor mayor a cero y se multiplica por (lo que esta deltro del if del B)
                                infoB = objmatrizB.RecorreB();
                                while (infoB.getDato() != 0 ){//se recorre la matriz B con el fin de multiplicar la fila de A con la columna de B
                                    if (infoB.getColumna() == columb && infoB.getFila() == k){// si hay una columna y fila igual a la indicada entonces
                                        //tiene valor mayor a cero y se multiplica por 
                                        valor = valor + (infoA.getDato() * infoB.getDato());
                                    }else{
                                        //es cero
                                       valor= valor+0;
                                    }
                                    infoB = objmatrizB.RecorreB();
                                }
                                
                            }else{
                                //es cero
                                valor= valor+0;
                            }
                            
                            
                            infoA = objmatrizA.RecorreA();
                        }
                    }  //fin for k
                    if (valor == 0){
                        //no se almacena
                    }else{
                        objmatrizC.IngresarNuevo(filaa, columb, valor);
                    }
                }
            }
        return objmatrizC;
    }

    
    
    //metodo que calcule la determinante
    //por cofactores
    public double determinate(int numfA, int numcA, MatrizEnLL objmatrizA){
        Tripleta infoA;
        int i;//fila
        int j;//columna
        
        double opRest1 = 1, opRest2 = 1, deter=0;
        int contIngDia=0,contIngNo=0 ;
        
            
        if (numfA == 2 && numcA == 2) {// este caso es por si la matriz es de 2X2
            
            infoA = objmatrizA.RecorreA();
            while (infoA.getDato() != 0 ){ //recorrerá toda la lista ligada de A    
                
                    if (infoA.getColumna() == infoA.getFila()){ //si columna es igual a fila, operará la resta de la diagonal principal
                        opRest1 = opRest1 * infoA.getDato();
                        contIngDia=contIngDia+1;
                    }else{//sino opera los que no son de la diagonal principal
                        opRest2 = opRest2 * infoA.getDato();
                        contIngNo = contIngNo+1;
                    }
                    
                infoA = objmatrizA.RecorreA();
            }
            
            if (contIngDia== 1 || contIngDia == 0){//si _contIngresoDiagonal es 1 entonces quiere decir que en la diagonal principal hay un cero y por tanto
                opRest1=0; //la multiplicacion por cero da cero
            }
            if (contIngNo== 1 || contIngNo == 0){//si _contIngresoNoDiagonal es 1 entonces quiere decir que en la diagonal principal hay un cero y por tanto
                opRest2=0; //la multiplicacion por cero da cero
            }//si _contIngresoDiagonal y _contIngresoNoDiagonal es mayor a 2 entonces no hubo multiplicacion por cero 

                 deter = opRest1 - opRest2;

            return deter;
            
        }else{//esto es para matrices con order mayor a 2x2
            deter=0;//inicializamos deter = 0 porque habrán llamados dentro de este metodo que invoque a este mismo metodo
            int nFilas= (numfA-1);//para hallar la determinante se tendrá que eliminar una fila 
            int nColum= (numcA-1);//para hallar la determinante se tendrá que eliminar 1 columna
            //y estos dos ingresarán como parametro para la nueva matriz (la cual se ha eliminado la fila y columna)_matrizfilasElim
            
            for ( i = 1; i <= numfA; i++){//recorrera el numero de filas de A 
            for ( j = 1; j <= numcA; j++) //recorrera el numero de columnas de A si son 3, recorrerá 3 veces
            {
                
                //el siguiente es el bloque de codigo para eliminar fila y columna
                 MatrizEnLL matrizfilasElim = new MatrizEnLL();
                 int fnueva=1;//esta _fnueva es para las filas de la nueva matriz (lista) sin la fila y columna eliminada
                 int cnueva=1;//esta _cnueva es para las columnas de la nueva matriz (lista) sin la fila y columna eliminada
                 
                 infoA = objmatrizA.RecorreA();
                 while (infoA.getDato() != 0 ){ //recorrerá toda la lista ligada de A   
                     //"eliminamos" la fila i y colum j de A
                     if(infoA.getFila() != i && infoA.getColumna() != j){//si el info es distito a los que estan "eliminados" entonces 
                         //se crea nodos en una matriz nueva _matrizfilasElim con esas infos 
                        matrizfilasElim.IngresarNuevo(fnueva, cnueva, infoA.getDato());//creamos nueva matriz
                        
                        //el siguiente bloque de codigo de if anidados es para asignarle la fila nueva y la columna nueva a la matriz que se crea anteriormente
                        if(fnueva==1 && cnueva==1){
                            fnueva=1;
                            cnueva=2;
                        }else if(fnueva==1 && cnueva==2){
                            fnueva=2;
                            cnueva=1;
                        }else if(fnueva==2 && cnueva==1){
                            fnueva=2;
                            cnueva=2;
                        }
                        
                     }
                     infoA = objmatrizA.RecorreA(); 
                 }
                 //fin del bloque de codigo para eliminar fila y columna
                 
                 //despues que se haya eliminado la fila y la columna, hallamos el det por cofactores, sacando el det de la matriz eliminada
                 //calculamos el det
                 deter = deter + (Math.pow(-1, i+j) * this.determinate(nFilas, nColum, matrizfilasElim));

                        
            }//cierre del for de colum
            }//cierre del for de fila
            return deter;
        }//cierre del else   
    }  

    
    //metodo para hallar la adjunta de la matriz dada
    public MatrizEnLL Adjunta( int numfA, int numcA, MatrizEnLL objmatrizA){
        MatrizEnLL objmatrizD = new MatrizEnLL();//la matriz D es la matriz Adjunta resultante
        Tripleta infoAdj;
        
         if (numfA == 2 && numcA == 2) {// este caso es por si la matriz es de 2X2
            infoAdj = objmatrizA.RecorreA();
            while (infoAdj.getDato() != 0 ){ //recorrerá toda la lista ligada de A    
                
                if (infoAdj.getColumna() == infoAdj.getFila()){ //si columna es igual a fila
                    //entonces hablamos de la diagonal principal la cual
                    if (infoAdj.getColumna()==2){//si la columna es 2 entonces 
                         objmatrizD.IngresarNuevo(1, 1, infoAdj.getDato());//se ingresa en la matriz adjunta, el dato pero con columna y fila = 1
                    }else{//sino esporque es 1 y entonces se ingresa con fila y columna iguala  2
                         objmatrizD.IngresarNuevo(2, 2, infoAdj.getDato());
                    }
                }else{//si no es la diagonal principal entonces
                    if(infoAdj.getColumna()==2 && infoAdj.getFila()==1){//si la columna es 2 y la fila 1 entonces
                        objmatrizD.IngresarNuevo(2, 1,((-1)* infoAdj.getDato()));// se ingresa con fila 2 y columna 1 y se cambia el signo
                    }else{
                        objmatrizD.IngresarNuevo(1, 2,((-1)* infoAdj.getDato()));
                    }
                }
                
                infoAdj = objmatrizA.RecorreA();
            }
            //con el bloque de codigo anterior se ha hallado la adjunta para cuando es de 2x2 Y POR ENDE SE HA HALLADO LA TRANSPUESTA 
         }else{//esto es para matrices con order mayor a 2x2
             
            for (int ii = 1; ii <= numfA; ii++) {//recorremos toda la fila de la matriz que entra como parametro
            for (int jj = 1; jj <= numcA; jj++) {//recorremos toda la fila de la matriz que entra como parametro
                
                //el siguiente es el bloque de codigo para eliminar fila y columna. explicado anteriormente
                MatrizEnLL matrizfilasElim = new MatrizEnLL();
                 int fnueva=1;
                 int cnueva=1;
                 
                 infoAdj = objmatrizA.RecorreA();
                 while (infoAdj.getDato() != 0 ){ //recorrerá toda la lista ligada de A   
                     //"eliminamos" la fila i y colum j de A
                     if(infoAdj.getFila() != ii && infoAdj.getColumna() != jj){//si el info es distito a los que estan "eliminados" entonces se opera
                        matrizfilasElim.IngresarNuevo(fnueva, cnueva, infoAdj.getDato());//creamos nueva matriz
                        if(fnueva==1 && cnueva==1){
                            fnueva=1;
                            cnueva=2;
                        }else if(fnueva==1 && cnueva==2){
                            fnueva=2;
                            cnueva=1;
                        }else if(fnueva==2 && cnueva==1){
                            fnueva=2;
                            cnueva=2;
                        }
                     }
                     infoAdj = objmatrizA.RecorreA(); 
                 }
                 //fin del bloque de codigo para eliminar fila y columna
                 
              //despues que se haya eliminado la fila y columna, calculamos el elemento a adjuntar, por cofactores
              double elementoAdjunto = Math.pow(-1, ii+jj) * this.determinate(numfA,numcA,  matrizfilasElim);          
              if (elementoAdjunto != 0){ //si el elemento a adjuntar es diferente de 0 entonces
                  objmatrizD.IngresarNuevo(ii, jj, (int) elementoAdjunto);//a la matriz D en la posicion i j se almacena el elemento adjunto. 
                  //LA MATRIZ D ES LA MATRIZ ADJUNTA QUE VA RESULTANDO
              }
                
            }//cierre for colum
            }//cierre for fila
        }
         if(numfA!=2){// no necestio que trasponga cuando tengo una matriz de 2x2 porque arriba ya estoy trasponiendo para matriz de 2x2
            objmatrizD=this.Transpuesta(numfA, numcA, objmatrizD);
         }             
        return objmatrizD;
    }
    
    
    //metodo para obtener la transpuesta de la matriz
    public MatrizEnLL Transpuesta( int numfA, int numcA, MatrizEnLL objmatrizA){

        MatrizEnLL objmatrizE = new MatrizEnLL();//_objmatrizE es la matriz que contendrá la matriz transpuesta resultante
        Tripleta infoTrans;

            infoTrans = objmatrizA.RecorreA();
            while (infoTrans.getDato() != 0 ){ //recorrerá toda la lista ligada de A (A es la matriz que entra como parametro)
                objmatrizE.IngresarNuevo(infoTrans.getColumna(), infoTrans.getFila(), infoTrans.getDato()); //aquí solo al _objetomatrizE se le agregan los datos que tiene la matriz a transponer
                //pero las filas serán columnas y las columnas serán filas
                infoTrans = objmatrizA.RecorreA();
            }

        return objmatrizE;
    }
    
}
