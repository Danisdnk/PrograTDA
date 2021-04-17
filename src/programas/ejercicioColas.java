package programas;
import api.ColaTDA;
import implementaciones.ColaTF;
import java.util.Arrays; //esto puede usarse???

// e) Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir
// que el primer elemento es igual al último, el segundo igual al penúltimo, etc.
public class ejercicioColas {
    public static void mostrarCola(ColaTDA cola) {
        /*copiarCola(cola, copia);*/
        ColaTDA copia = new ColaTF();
        copia.Inicializar();
        copiarCola(cola,copia);
        System.out.print("Cola invertida: ");
        System.out.println(Arrays.toString(InvertirCola(cola))); //se puede? imprime invertida

       //imprime cola original
       // System.out.println("original: ");
       // while (!cola.ColaVacia()) {
           // System.out.print(cola.Primero() + " ");
            //cola.Desacolar();
        //}
        //imprime cola copia
        System.out.print("copia: ");
        while (!copia.ColaVacia()) {
            System.out.print(copia.Primero() + " ");
            copia.Desacolar();
        }
    }

    public static void copiarCola(ColaTDA original,ColaTDA copia)  {
        ColaTDA colaIntermedia= new ColaTF();
        colaIntermedia.Inicializar();

        while (!original.ColaVacia()){ // primera parte original -> intermedia
            colaIntermedia.Acolar(original.Primero()); //copio los valores en cola intermedia
            original.Desacolar(); //desacolo los valores de la original
        }
        while (!colaIntermedia.ColaVacia()){ //segunda parte  intermedio -> original,copia
            original.Acolar(colaIntermedia.Primero()); //acolo en la original los valores de la intermedia
            copia.Acolar(colaIntermedia.Primero());// tambien en la copia
            colaIntermedia.Desacolar();
        }
    }

    //b) Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)
    //hago este metodo para cada que necesito obtener el tamaño
    public static int ObtenerTamanioCola(ColaTDA cola) {
        ColaTDA intermedia = new ColaTF();
        intermedia.Inicializar();
        int largo=0;
        while (!cola.ColaVacia()) {
            intermedia.Acolar(cola.Primero());
            largo += 1;
            cola.Desacolar();
        }
        return largo;
    }

    public static int[] InvertirCola(ColaTDA cola) {
        ColaTDA intermedia = new ColaTF();
        intermedia.Inicializar();
        int []vec;
        int largo=0;
        while (!cola.ColaVacia()) {
            intermedia.Acolar(cola.Primero());
            largo += 1;
            cola.Desacolar();
        }
        vec= new int[largo]; //vector del largo de mi cola
        while (largo!=0) {
            vec[largo-1]=intermedia.Primero();
            largo=largo-1;
            intermedia.Desacolar();
        }
    return vec;
    }

    // d) Determinar si el final de la Cola C1 coincide o no con la Cola C2.
    public static void CompararUltimoIndice(ColaTDA colaUno, ColaTDA colaDos) {
        int valorUno=0;
        int valorDos=0;
        String resultado;
        while (!colaUno.ColaVacia()) {
            valorUno=colaUno.Primero();
            colaUno.Desacolar();
        }
        while (!colaDos.ColaVacia()) {
            valorDos=colaDos.Primero();
            colaDos.Desacolar();
        }
        if(valorDos == valorUno) {
        System.out.print("El ultimo valor de ambas colas es igual");
        }else{
        System.out.print("El ultimo valor de ambas colas es distinto");
        }
    }

    public static int[] MostrarColaArray(ColaTDA colaDos) {
        ColaTDA intermedia = new ColaTF();
        intermedia.Inicializar();
        int []vec;
        int largo=0;
        while (!colaDos.ColaVacia()) {
            intermedia.Acolar(colaDos.Primero());
            largo += 1;
            colaDos.Desacolar();
        }
        int i=0;
        vec= new int[largo]; //vector del largo de mi cola

        while (largo!=i) {
            vec[i]=intermedia.Primero();
            i++;
            intermedia.Desacolar();
        }
        return vec;
    }

//f) Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán
// inversas, si tienen los mismos elementos pero en orden inverso.
    public static void CompararColasInvertidas(ColaTDA colaUno, ColaTDA colaDos) {
        ColaTDA intermedia = new ColaTF();
        int []cola1= InvertirCola(colaUno);
        int largo=cola1.length;
        boolean resultado = false;
        int []cola2= MostrarColaArray(colaDos);

        while (largo!=0 ){
            if (cola1[largo-1]!=cola2[largo-1]){
                largo=largo-1;
                resultado= false;
                break;
            }else {
                largo=largo-1;
                resultado=true;
            }
        }
        if(resultado){
            System.out.print("C1 invertida y C2 son iguales");}
        else {
            System.out.print("C1 invertida y C2  son distintas");}
        }


    public static void main(String[] args) {
        ColaTDA colaUno = new ColaTF();
        ColaTDA colaDos = new ColaTF();
        colaUno.Inicializar();
        colaDos.Inicializar();
        //cola uno
        colaUno.Acolar(1);
        colaUno.Acolar(3);
        colaUno.Acolar(5);
        colaUno.Acolar(7);
        colaUno.Acolar(9);

        //cola dos
        colaDos.Acolar(9);
        colaDos.Acolar(7);
        colaDos.Acolar(5);
        colaDos.Acolar(3);
        colaDos.Acolar(12);
        // d) Determinar si el final de la Cola C1 coincide o no con la Cola C2.
        //CompararUltimoIndice(colaUno, colaDos);
        CompararColasInvertidas(colaUno, colaDos);

    }
}
