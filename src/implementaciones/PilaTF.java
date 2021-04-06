package implementaciones;

import api.PilaTDA;

public class PilaTF implements PilaTDA {

    int [] arr;
    int index;


    @Override
    public void InicializarPila() {

        arr=new int[15];
        index=0;

    } // InicializarPila Crea una nueva instancia de la pila

    @Override
    public void Apilar(int x) {
        arr[index]=x;
        index++;
    } //Apilar suma un nuevo valor a la pila

    @Override
    public void Desapilar() {
        index--;
    }

    @Override
    public int Tope() {
        return (arr[index-1]);
    } //

    @Override
    public boolean PilaVacia() {
        return (index==0);
    }

}
