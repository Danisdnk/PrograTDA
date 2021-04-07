package programas;

import api.PilaTDA;
import implementaciones.PilaTF;

public class Main {

    public static void mostraPila(PilaTDA pila) {
        PilaTDA copia = new PilaTF();
        copia.InicializarPila();
        copiarPila(pila, copia);
        System.out.print("tope");

        while (!pila.PilaVacia()) { // duplico codigo porque sino no me imprime la pila original?
            System.out.print(pila.Tope() + " ");
            pila.Desapilar();
        }
        System.out.println("tope");
        while (!copia.PilaVacia()) {
            System.out.print(copia.Tope() + " ");
            copia.Desapilar();
        }

        System.out.println("fondo");
    }
//B
    public static void copiarPila(PilaTDA original, PilaTDA copia) {
        PilaTDA pilaIntermedia= new PilaTF();
        pilaIntermedia.InicializarPila();
        while (!original.PilaVacia()){ // primera parte original -> intermedia
            pilaIntermedia.Apilar(original.Tope());
            original.Desapilar();
        }
        while (!pilaIntermedia.PilaVacia()){ //segunda parte  intermedio -> original,copia
            original.Apilar(pilaIntermedia.Tope());
            copia.Apilar(pilaIntermedia.Tope());
            pilaIntermedia.Desapilar();
        }
    }

    public static void ContarPila(PilaTDA pila) {
     int largoPila = 0;

      while (!pila.PilaVacia()) {
         largoPila++;
         pila.Desapilar();
      }
      System.out.println("El largo de la pila es : "+ largoPila);
    }

    public static void SumarPila(PilaTF pila) {
        int sumaPila = 0;
        int i=0;

        while (!pila.PilaVacia()) {
            i++;
            sumaPila=sumaPila+pila.Tope();
            pila.Desapilar();
        }
        System.out.println("la suma de la pila es : "+ sumaPila);
    }

    public static void PromediarPila(PilaTF pila) {
        int sumaPila = 0;
        int i=0;

        while (!pila.PilaVacia()) {
            i++;
            sumaPila=sumaPila+pila.Tope();
            pila.Desapilar();
        }
        System.out.println("la suma de la pila es : "+ sumaPila);
    }

    // a) Pasar una Pila a otra (dejándola en orden inverso)
    // c) Invertir el contenido de una Pila.
   // f) Calcular el promedio de los elementos de una Pila

    public static void main(String[] args) {
        PilaTF nuevaPila = new PilaTF();
        nuevaPila.InicializarPila();
        nuevaPila.Apilar(1);
        nuevaPila.Apilar(3);
        nuevaPila.Apilar(5);
        nuevaPila.Apilar(7);
        nuevaPila.Apilar(9);

        //ContarPila(nuevaPila); // d) Contar los elementos de una Pila
        //SumarPila(nuevaPila);  // e) Sumar los elementos de una Pila
        //b) Copiar una Pila en otra (dejándola en el mismo orden que la original)
        mostraPila(nuevaPila);
    }

}