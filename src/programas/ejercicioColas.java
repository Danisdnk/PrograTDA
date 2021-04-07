package programas;

import api.ColaTDA;
import api.PilaTDA;
import implementaciones.ColaTF;
import implementaciones.PilaTF;

//A partir del TDA Cola definido, escribir distintos métodos que permitan

//b) Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)
// c) Invertir el contenido de una Cola (NO pueden usarse Pilas auxiliares)
// d) Determinar si el final de la Cola C1 coincide o no con la Cola C2.
// e) Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir
// que el primer elemento es igual al último, el segundo igual al penúltimo, etc.
//f) Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán
// inversas, si tienen los mismos elementos pero en orden inverso.

public class ejercicioColas {
    public static void mostrarCola(ColaTDA cola) {
        /*copiarCola(cola, copia);*/
        ColaTDA copia = new ColaTF();
        copia.Inicializar();
        copiarCola(cola,copia);
        InvertirCola(cola);
       //imprime cola original
        System.out.print("original: ");
        while (!cola.ColaVacia()) {
            System.out.print(cola.Primero() + " ");
            cola.Desacolar();
        }

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

    public static void InvertirCola(ColaTDA cola) {
        ColaTDA invertida = new ColaTF();
        invertida.Inicializar();
        int []vec;
        int largo=0;
        while (!cola.ColaVacia()) {
            //vector[largo] =cola.Primero();
            invertida.Acolar(cola.Primero());
            largo += 1;
            cola.Desacolar();
        }
        vec= new int[largo]; //vector del largo de mi cola

        for (int i = 0; i < vec.length ; i++)  {
            vec[i] =invertida.Primero();
            System.out.print(vec[i]+ "array ");
            invertida.Desacolar();
        }
        //for(int i =largo+1; i > 0; i--)
        //{
        // System.out.print(vec[i]+ "array ");
        // System.out.println(i);
        //}

    }

    public static void main(String[] args) {
        ColaTDA nuevaCola = new ColaTF();
        nuevaCola.Inicializar();
        nuevaCola.Acolar(1);
        nuevaCola.Acolar(3);
        nuevaCola.Acolar(5);
        nuevaCola.Acolar(7);
        nuevaCola.Acolar(9);
        mostrarCola(nuevaCola);
    }
}
